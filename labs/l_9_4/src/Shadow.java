import java.net.URL;
import javafx.scene.Group;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Shadow extends Application {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private StackPane shadowPane;

    private final Slider setWidth = new Slider(0, 40, 21);
    private final Slider setHeight = new Slider(0, 40, 21);
    private final Slider setOffsetX = new Slider(-15, 15, 0);
    private final Slider setOffsetY = new Slider(-15, 15, 0);
    private final Slider setRadius = new Slider(0, 50, 10);
    private final List<Slider> sliders = new ArrayList<Slider>();
    private Double width = 21.0;
    private Double height = 21.0;
    private Double offsetX = 0.0;
    private Double offsetY = 0.0;
    private Double radius = 10.0;
    private final DropShadow e = new DropShadow();

    @FXML
    void initialize() {

        setWidth.setId("setWidth");
        setHeight.setId("setHeight");
        setOffsetX.setId("setOffsetX");
        setOffsetY.setId("setOffsetY");
        setRadius.setId("setRadius");

        Collections.addAll(
                sliders, 
                setWidth, 
                setHeight, 
                setOffsetX, 
                setOffsetY, 
                setRadius);

        for (final Slider slider : sliders) {
            slider.setPadding(new Insets(2, 4, 2, 22));
            slider.setMinHeight(22.0);
        }

        final Rectangle rectangle = new Rectangle(100, 100);
        rectangle.setFill(Color.LIGHTGRAY);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(2);

        final HBox hbox = new HBox(
                new StackPane(rectangle),
                new HBox(
                    new VBox(
                        setWidth, 
                        setHeight, 
                        setOffsetX, 
                        setOffsetY, 
                        setRadius),
                    getLabels()));

        shadowPane.getChildren().add(hbox);

        for (final Slider slider : sliders) {
            slider.valueProperty().addListener((ov, oldValue, newValue) -> {

                switch (slider.getId()) {
                case "setWidth":
                    width = newValue.doubleValue();
                    break;
                case "setHeight":
                    height = newValue.doubleValue();
                    break;
                case "setOffsetX":
                    offsetX = newValue.doubleValue();
                    break;
                case "setOffsetY":
                    offsetY = newValue.doubleValue();
                    break;
                case "setRadius":
                    radius = newValue.doubleValue();
                    break;
                }

                rectangle.setEffect(getShadow());
            });
        }

    }

    private Group getLabels() {

        final Group labels = new Group();

        final Label widthLabel = new Label("- Width");
        final Label heightLabel = new Label("- Height");
        final Label offsetXLabel = new Label("- X-Offset");
        final Label offsetYLabel = new Label("- Y-Offset");
        final Label radiusLabel = new Label("- Radius");

        widthLabel.setMinHeight(22.0);
        heightLabel.setMinHeight(22.0);
        offsetXLabel.setMinHeight(22.0);
        offsetYLabel.setMinHeight(22.0);
        radiusLabel.setMinHeight(22.0);

        labels.getChildren().add(
                new VBox(widthLabel, 
                        heightLabel, 
                        offsetXLabel, 
                        offsetYLabel, 
                        radiusLabel));

        return labels;
    }

    private Effect getShadow() {

        e.setWidth(width);
        e.setHeight(height);
        e.setOffsetX(offsetX);
        e.setOffsetY(offsetY);
        e.setRadius(radius);

        return e;
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub

        final Parent root = FXMLLoader.load(getClass().getResource("Shadow.fxml"));

        final Scene scene = new Scene(root);
        primaryStage.setTitle("Shadows");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(final String[] args) {

        launch(args);
    }

}