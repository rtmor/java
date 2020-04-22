import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MemoryMatch extends Application {

    @FXML
    private StackPane gamePane;

    @FXML
    private VBox menuPane;

    @FXML
    private AnchorPane leftPane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private BorderPane rootPane;

    @FXML
    private Label clockWatch;

    @FXML
    private ComboBox<String> challengeMenu;

    @FXML
    private Label winnerLabel;

    @FXML
    private Label highLabel;

    @FXML
    private URL location;

    static int PAIR_COUNT = 18;
    static int NUM_PER_ROW = 6;

    String currentDifficulty = "Medium";
    Cubes selected = null;
    int clickCount = 2;
    AnimationTimer stopclock;
    private FadeTransition winFade;
    private long currentTime;
    String path = System.getProperty("user.dir");
    String data = path + "/src/scoreboard.ser";
    String topScores = "";
    ScoreBoard score;

    // build scene components
    // & begin timer
    @FXML
    void initialize() {
        buildScene();
        buildChallengeMenu();
        stopclock = setTimer();
        stopclock.start();
    }

    // build all scene requirements
    private void buildScene() {
        rootPane.setBackground(new Background(new BackgroundFill(Color.web("#f2f2e4"), null, null)));
        menuPane.setBackground(new Background(new BackgroundFill(Color.web("#3b4252"), null, null)));
        Group content = createContent();
        gamePane.getChildren().add(content);
        StackPane.setAlignment(content, Pos.CENTER);
        initializeScore();
    }

    // reset scene
    @FXML
    void restart(ActionEvent event) {

        // catch difficulty and assign difficulty constants
        setDifficulty();

        // clear winner label-animation & scores
        winnerLabel.setVisible(false);
        topScores = "";

        try {
            winFade.stop();
        } catch (Exception e) {
        }

        stopclock.stop();
        gamePane.getChildren().clear();

        // restart scene
        initialize();

    }

    // set difficulty constants
    private void setDifficulty() {
        switch (challengeMenu.getValue()) {
        case "Easy":
            NUM_PER_ROW = 4;
            PAIR_COUNT = 8;
            currentDifficulty = "Easy";
            break;
        case "Medium":
            NUM_PER_ROW = 6;
            PAIR_COUNT = 18;
            currentDifficulty = "Medium";
            break;
        case "Hard":
            NUM_PER_ROW = 10;
            PAIR_COUNT = 50;
            currentDifficulty = "Hard";
            break;
        case "Impossible":
            NUM_PER_ROW = 20;
            PAIR_COUNT = 200;
            currentDifficulty = "Impossible";
            break;
        }
    }

    // clear - stop game & reset scoreboard
    @FXML
    void clear(ActionEvent event) {

        stopclock.stop();
        gamePane.getChildren().clear();
        topScores = "";
        initializeScore();

        try {
            winFade.stop();
        } catch (Exception e) {
        }

    }

    // build difficulty drop-down
    private void buildChallengeMenu() {
        challengeMenu.getItems().setAll("Easy", "Medium", "Hard", "Impossible");
        challengeMenu.setValue(currentDifficulty);
    }

    // get & set highscore values
    private void highScore() throws FileNotFoundException, IOException {
        long currentScore = currentTime;
        System.out.println(currentDifficulty + " " + currentScore);

        // if stored score is > current score; replace & write
        if (score.getValue(currentDifficulty) > currentScore) {
            score.replace(currentDifficulty, currentScore);
            try {
                writeScore();
            } catch (Exception e) {

            }
        }
    }

    // import serialized (ScoreBoard) object
    public void initializeScore() {

        try {
            FileInputStream fis = new FileInputStream(data);
            ObjectInputStream ois = new ObjectInputStream(fis);
            score = (ScoreBoard) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException ioe) {
            // if serialized object does not already exist, build new
            score = new ScoreBoard();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }

        // convert scoreboard map contents to suitable label string 
        for (Map.Entry<String, Long> entry : score.getScores().entrySet()) {
            topScores += String.format("%-10s - %6d\n", entry.getKey(), entry.getValue());
        }

        highLabel.setText(topScores);
    }

    // write serialized (ScoreBoard) object to file
    public void writeScore() throws FileNotFoundException, IOException {

        File file = new File(data);
        FileOutputStream f = new FileOutputStream(file);
        ObjectOutputStream s = new ObjectOutputStream(f);
        s.writeObject(score);
        s.close();

    }

    // build and set timer
    private AnimationTimer setTimer() {
        AnimationTimer timer = new AnimationTimer() {
            private long timestamp;
            private long time = 0;
            private long fraction = 0;

            @Override
            public void start() {
                timestamp = System.currentTimeMillis() - fraction;
                super.start();
            }

            @Override
            public void stop() {
                currentTime = time;
                super.stop();
            }

            @Override
            public void handle(long now) {
                long newTime = System.currentTimeMillis();
                if (timestamp + 1000 <= newTime) {
                    long deltaT = (newTime - timestamp) / 1000;
                    time += deltaT;
                    timestamp += 1000 * deltaT;
                    clockWatch.setText(String.format("%02d seconds", time));
                }
            }
        };

        return timer;
    }

    // instantiate cube instances & export as group
    private Group createContent() {
        Group root = new Group();
        int size = 600 / NUM_PER_ROW;

        // build desired number of cubes in ArrayList
        List<Cubes> cubes = new ArrayList<>();
        for (int i = 0; i < PAIR_COUNT; i++) {
            Color c = getColor();
            cubes.add(new Cubes(this, c));
            cubes.add(new Cubes(this, c));
        }

        Collections.shuffle(cubes);

        // set cubes in grid
        for (int i = 0; i < cubes.size(); i++) {
            Cubes tile = cubes.get(i);
            tile.setTranslateX(size * (i % NUM_PER_ROW));
            tile.setTranslateY(size * (i / NUM_PER_ROW));
            root.getChildren().add(tile);
        }

        return root;
    }

    // random color generator
    private Color getColor() {

        Random random = new Random();

        float r = random.nextFloat();
        float g = random.nextFloat();
        float b = random.nextFloat();

        Color color = new Color(r, g, b, 1);

        return color;
    }

    // display winner animation & check highscore
    void winner() throws FileNotFoundException, IOException {

        winnerLabel.setVisible(true);

        try {
            highScore();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        winFade = new FadeTransition(Duration.seconds(0.2), winnerLabel);
        winFade.setFromValue(1.0);
        winFade.setToValue(0.0);
        winFade.setAutoReverse(true);
        winFade.setCycleCount(Animation.INDEFINITE);
        winFade.play();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MemoryMatch.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Memory Match Game");
        primaryStage.show();
        primaryStage.sizeToScene();
    }

    public static void main(String[] args) {
        launch(args);
    }
}