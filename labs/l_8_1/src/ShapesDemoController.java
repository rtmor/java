
/**
 * ShapesDemoController
 */
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ShapesDemoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane paneDisplay;

    @FXML
    private HBox shapeBox;

    @FXML
    private Arc arc;

    @FXML
    private Ellipse ellipse;

    @FXML
    private Circle circle;

    @FXML
    private Rectangle rectangle;

    @FXML
    private Pane linePane;

    @FXML
    private Line line1;

    @FXML
    private Line line2;

    List<Node> shapes = new ArrayList<Node>();

    int index = 0;
    Stage stage = new Stage();


    @FXML
    void initialize() {

        Collections.addAll(shapes, rectangle, circle, ellipse, arc, linePane);
        Collections.shuffle(shapes);
        //Collections.shuffle(shapeBox.getChildren());
        shapeBox.getChildren().clear();
        shapeBox.getChildren().addAll(shapes);

/*         for (Node shape : shapes) {

            if (shape.getId().equals("linePane")) {
                Pane lines = new Pane();
                lines.getChildren().add(shape);
                shapeBox.getChildren().add(lines);
            } else {
                shapeBox.getChildren().add(shape);
            }

        } */
        
    }

}
