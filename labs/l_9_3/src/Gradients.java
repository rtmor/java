
/**
 * L.9.3: Create at least 10 shapes with a variety of linear and radial 
 * gradients.  Research the JavaFX CSS gradient capabilities.
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Gradients extends Application {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private HBox shapeBox;

    private List<Shape> shapes = new ArrayList<Shape>();
    private Stop[] stops;
    private Random r = new Random();

    @FXML
    void initialize() {

        shapeBox.getChildren().clear();
        Collections.addAll(shapes, new Rectangle(50, 50), new Circle(40), new Ellipse(40, 30), new Rectangle(50, 40),
                new Circle(40), new Ellipse(40, 30), new Rectangle(40, 50), new Circle(40), new Ellipse(40, 30),
                new Circle(40));

        Collections.shuffle(shapes, new Random());

        for (int i = 0; i < 10; i++) {
            StackPane sp = new StackPane();
            sp.setMinSize(50, 50);
            Shape shape = shapes.get(i);
            shape.setFill(getFill());
            sp.getChildren().add(shape);
            shapeBox.getChildren().add(sp);
        }

    }

    private Paint getFill() {
        
        LinearGradient lg = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, getStops());
        RadialGradient rg = new RadialGradient(0, 0, 0.5, 0.5, 1, true, CycleMethod.NO_CYCLE, getStops());

        return r.nextInt(2) == 0 ? lg : rg;
    }

    private int getColor() {

		return r.nextInt((255) + 1);
    }

    private Stop[] getStops() {

        stops = new Stop[] { new Stop(0, Color.rgb(getColor(), getColor(), getColor())), new Stop(1, Color.rgb(getColor(), getColor(), getColor())) };

        return stops;
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub

        Parent root = FXMLLoader.load(getClass().getResource("Gradients.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setTitle("Shape Gradients");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {

        launch(args);
    }

}