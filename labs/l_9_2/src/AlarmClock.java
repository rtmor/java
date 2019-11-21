import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import javax.sound.sampled.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AlarmClock extends Application {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private StackPane clockPane;

    @FXML
    private Spinner<Integer> hourSpin;

    @FXML
    private Spinner<Integer> minSpin;

    @FXML
    private Spinner<Integer> secSpin;

    @FXML
    private Label currentAlarm;

    @FXML
    private Button setBtn;

    @FXML
    private Button resetBtn;

    private final Calendar calendar = Calendar.getInstance(Locale.US);

    private Timeline delayTimeline, secondTimeline;

    private final Label clock = new Label();

    private Boolean alarmSet = false;

    private int hours, minutes, seconds;
    private int alarmHours, alarmMinutes, alarmSeconds;
    private Map<String, Integer> alarmMap = new TreeMap<String, Integer>();
    private Map<String, Integer> timeMap = new TreeMap<String, Integer>();
    private Sound obnoxiousNoise;
    private AnalogClock aclock = new AnalogClock(100);

    @FXML
    void initialize() {

        clock.setFont(Font.font("Monospace", 48.0));

        hourSpin.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23));

        minSpin.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59));

        secSpin.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59));

        aclock.setTranslateY(-15.0);
        clockPane.getChildren().add(aclock);

        buildClock();

    }

    
    /** 
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(final Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub

        final Parent root = FXMLLoader.load(getClass().getResource("AlarmClock.fxml"));

        final Scene scene = new Scene(root);
        primaryStage.setTitle("Alarm Clock");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    
    /** 
     * @param event
     * @throws IOException
     */
    @FXML
    void resetAlarm(final ActionEvent event) throws IOException {

        hourSpin.getEditor().clear();
        minSpin.getEditor().clear();
        secSpin.getEditor().clear();

        alarmMap.clear();

        obnoxiousNoise.stopAudio();

        currentAlarm.setTextFill(Color.web("#c7c7c7"));
        currentAlarm.setText("Current Alarm: XX:XX:XX");

        alarmSet = false;
        resetBtn.setDisable(true);
    }

    
    /** 
     * @param event
     */
    @FXML
    void setAlarm(final ActionEvent event) {

        try {
            alarmHours = Integer.parseInt(hourSpin.getEditor().getText());
            try {
                alarmMinutes = Integer.parseInt(minSpin.getEditor().getText());
                try {
                    alarmSeconds = Integer.parseInt(secSpin.getEditor().getText());

                    if (!alarmSet && sanityCheck()) {

                        alarmSet = true;
                        resetBtn.setDisable(false);

                        alarmMap.put("hour", alarmHours);
                        alarmMap.put("minute", alarmMinutes);
                        alarmMap.put("second", alarmSeconds);

                        currentAlarm.setTextFill(Color.web("#000"));
                        currentAlarm.setText(
                                String.format("Current Alarm: %02d:%02d:%02d", alarmHours, alarmMinutes, alarmSeconds));
                    }

                } catch (final NumberFormatException e) {
                    secSpin.getEditor().requestFocus();
                }
            } catch (final NumberFormatException e) {
                minSpin.getEditor().requestFocus();
            }
        } catch (final NumberFormatException e) {
            hourSpin.getEditor().requestFocus();
        }
    }

    
    /** 
     * @return boolean time falls within parameters
     */
    private boolean sanityCheck() {

        if (alarmHours > 23 || alarmHours < 0) {
            return false;
        }
        if (alarmMinutes > 59 || alarmMinutes < 0) {
            return false;
        }
        if (alarmSeconds > 59 || alarmSeconds < 0) {
            return false;
        }

        return true;
    }

    // get update time and update map
    private void refreshClock() {

        calendar.setTimeInMillis(System.currentTimeMillis());

        hours = calendar.get(Calendar.HOUR_OF_DAY);
        minutes = calendar.get(Calendar.MINUTE);
        seconds = calendar.get(Calendar.SECOND);

        clock.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));

        timeMap.clear();
        timeMap.put("hour", hours);
        timeMap.put("minute", minutes);
        timeMap.put("second", seconds);

        alarmCheck();

    }

    // compare time and alarm maps
    private void alarmCheck() {
        if (alarmMap.equals(timeMap)) {
            System.out.println("ALARM");
            try {
                obnoxiousNoise = new Sound("C:/Users/rtmor/java/labs/l_9_1/src/sound/noise.wav");
            } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
                e.printStackTrace();
            }
            try {
                obnoxiousNoise.playAudio();
            } catch (IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
        }
    }

    private void buildClock() {

        refreshClock();
        play();

    }

    // construct timeline & call refreshClock()
    public void play() {

        delayTimeline = new Timeline();
        delayTimeline.getKeyFrames().add(
                new KeyFrame(new Duration(1000 - (System.currentTimeMillis() % 1000)), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent event) {
                        if (secondTimeline != null) {
                            secondTimeline.stop();
                        }
                        secondTimeline = new Timeline();
                        secondTimeline.setCycleCount(Timeline.INDEFINITE);
                        secondTimeline.getKeyFrames()
                                .add(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(final ActionEvent event) {
                                        refreshClock();
                                    }
                                }));
                        secondTimeline.play();
                    }
                }));
        delayTimeline.play();
    }

    public void stop() {
        delayTimeline.stop();
        if (secondTimeline != null) {
            secondTimeline.stop();
        }
    }

    
    /** 
     * @param args
     */
    public static void main(final String[] args) {

        launch(args);

    }

}

/**
 * Inner Sound Class
 */
class Sound extends Parent {

    private AudioInputStream audioStream;
    private Clip audioClip;

    public Sound(String song) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        File audioFile = new File(song);
        audioStream = AudioSystem.getAudioInputStream(audioFile);
        AudioFormat format = audioStream.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);
        audioClip = (Clip) AudioSystem.getLine(info);
    }

    public void playAudio() throws IOException, LineUnavailableException {
        audioClip.open(audioStream);
        audioClip.start();
        audioClip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stopAudio() throws IOException {
        audioClip.close();
        audioStream.close();
    }

}