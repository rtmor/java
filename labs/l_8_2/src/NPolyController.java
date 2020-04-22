
/**
 * NPoly
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class NPolyController {

   @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private HBox polyPane;

    @FXML
    private Slider spinner; 

    @FXML
    void initialize() {

        polyPane.setBackground(new Background(new BackgroundFill(Color.web("#3b4252"), null, null)));
        Polygon polygon = new Polygon();
        polygon.setFill(Color.web("#b48ead"));
        buildPolygon(polygon, (int) spinner.getValue());

        spinner.valueProperty().addListener((ov, oldValue, newValue) -> {
            buildPolygon(polygon, newValue.intValue());
            System.out.println(newValue.intValue());
        });

        polyPane.getChildren().add(polygon);

    }

    private void buildPolygon(Polygon polygon, int sides) {

        polygon.getPoints().clear();
        final double centerX = 200;
        final double centerY = 200;
        final double angleStep = Math.PI * 2 / sides;
        double radius = 150;
        double angle = 0;

        for (int i = 0; i < sides; i++, angle += angleStep) {
            polygon.getPoints().addAll(Math.sin(angle) * radius + centerX,
                    Math.cos(angle) * radius + centerY 
            );
        }
    }
}