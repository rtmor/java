import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Stream;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Gradient extends Application {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField startGradient;

    @FXML
    private TextField endGradient;

    @FXML
    private ToggleGroup gradientType;

    @FXML
    private RadioButton radLinear;

    @FXML
    private RadioButton radRadient;

    @FXML
    private HBox rectangleBox;

    @FXML
    private Rectangle rectangle;

    @FXML
    private VBox vbox;

    private int red1 = 20;
    private int green1 = 200;
    private int blue1 = 50;
    private int red2 = 70;
    private int green2 = 10;
    private int blue2 = 110;
    private Stop[] stops;
    private String selected = "Radial";

    @FXML
    void initialize() {

        RadialGradient rg = new RadialGradient(0, 0, 0.5, 0.5, 1, true, CycleMethod.NO_CYCLE, getStops());
        rectangle.setFill(rg);

        gradientType.selectedToggleProperty().addListener((ov, oldValue, newValue) -> {

            RadioButton rb = (RadioButton) gradientType.getSelectedToggle();
            selected = rb.getText();

            buildRectangle(rectangle, selected, getStops());

        });

        startGradient.textProperty().addListener((ov, oldValue, newValue) -> {
            try {
                int[] rgbValues = extractRGB(newValue);
                red1 = rgbValues[0];
                green1 = rgbValues[1];
                blue1 = rgbValues[2];

                buildRectangle(rectangle, selected, getStops());
                // STUPID
            } catch (Exception ignore) { // STUPID
            }
        });

        endGradient.textProperty().addListener((ov, oldValue, newValue) -> {
            try {
                int[] rgbValues = extractRGB(newValue);
                red2 = rgbValues[0];
                green2 = rgbValues[1];
                blue2 = rgbValues[2];

                buildRectangle(rectangle, selected, getStops());
                // STUPID
            } catch (Exception ignore) { // STUPID
            }
        });
    }

    public Stop[] getStops() {

        stops = new Stop[] { new Stop(0, Color.rgb(red1, green1, blue1)), new Stop(1, Color.rgb(red2, green2, blue2)) };

        return stops;
    }

    public void buildRectangle(Rectangle rectangle, String gradientFill, Stop[] stops) {

        LinearGradient lg = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
        RadialGradient rg = new RadialGradient(0, 0, 0.5, 0.5, 1, true, CycleMethod.NO_CYCLE, stops);

        rectangle.setFill(gradientFill.equals("Radial") ? rg : lg);

    }

    public int[] extractRGB(String rawRGB) {

        int[] rgbValue = Stream.of(rawRGB.replaceAll("[()]", "").split(",")).mapToInt(Integer::parseInt).toArray();

        return rgbValue;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("Gradient.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setTitle("Rectangle Gradient");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
