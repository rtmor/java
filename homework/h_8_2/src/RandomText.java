import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import org.apache.commons.lang3.RandomStringUtils;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * H.8.2: Create an application which draws 500 random characters of random
 * fonts, sizes, colors, and font-attributes on the screen.
 */
public class RandomText extends Application {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane randomPane;

    Random random = new Random();

    @FXML
    void initialize() {

        randomPane.getChildren().clear();

        for (int i = 0; i < 500; i++) {

            Label randomLabel = new Label();
            randomLabel.setLayoutX(getRandomLocation('x'));
            randomLabel.setLayoutY(getRandomLocation('y'));

            String randomChar = RandomStringUtils.randomAlphanumeric(1);

            randomLabel.setText(randomChar);
            randomLabel.setTextFill(getRandomColor());
            randomLabel.setFont(Font.font(getRandomFont(), getRandomWeight(), getRandomPosture(), getRandomSize()));

            randomPane.getChildren().add(randomLabel);
        }

    }

    
    /** 
     * @return String
     */
    private String getRandomFont() {

        List<String> fonts = FXCollections.observableArrayList(Font.getFamilies());
        Collections.shuffle(fonts);

        return fonts.get(0);

    }

    
    /** 
     * @return float
     */
    private float getRandomSize() {

        return random.nextFloat() * (72 - 20) + 20;

    }

    
    /** 
     * @return FontWeight
     */
    private FontWeight getRandomWeight() {

        FontWeight fw = random.nextInt(2) == 0 ? FontWeight.NORMAL : FontWeight.BOLD;

        return fw;
    }

    
    /** 
     * @return FontPosture
     */
    private FontPosture getRandomPosture() {

        FontPosture fp = random.nextInt(2) == 0 ? FontPosture.REGULAR : FontPosture.ITALIC;

        return fp;
    }

    
    /** 
     * @return Color
     */
    private Color getRandomColor() {

        float R = random.nextFloat();
        float G = random.nextFloat();
        float B = random.nextFloat();

        Color randomColor = new Color(R, G, B, 1);

        return randomColor;
    }

    
    /** 
     * @param c
     * @return double
     */
    private double getRandomLocation(Character c) {

        double randomLocation = c.equals('x') ? random.nextDouble() * (800) : random.nextDouble() * 500;

        return randomLocation;
    }

    
    /** 
     * @param args
     */
    public static void main(String[] args) {

        launch(args);

    }

    
    /** 
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        Parent root = FXMLLoader.load(getClass().getResource("RandomText.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setTitle("Random Characters");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}