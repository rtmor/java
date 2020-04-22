
/**
 * H.9.1: Create an app that has two rectangles with the same height but different widths begin at
 * opposite ends of the window and move across the screen at the same speed to the other end of the
 * window. The start position of each rectangle should be random. One rectangle should be red and
 * the other one blue.
 */
import javafx.util.Duration;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

/**
 * Rectangles
 */
public class Rectangles extends Application {

    @FXML
    private Pane pane;

    @FXML
    private Circle c;

    private Shape shape;
    private Bounds bounds;
    private Random random = new Random();

    public void initialize() {

        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle();
        List<Rectangle> rectangleList = 
            initializeRectangles(random.nextInt(2), r1, r2);

        r1 = rectangleList.get(0);
        r2 = rectangleList.get(1);

        r2.setLayoutX(pane.getPrefWidth() - r2.getWidth());

        pane.getChildren().addAll(r1, r2);

        bounds = pane.getBoundsInParent();

        buildMovement(bounds, r1, r2);

        /*
         * pane.widthProperty().addListener((obs, oldVal, newVal) -> { Bounds bound =
         * pane.getBoundsInLocal(); buildMovement(bound); });
         */

        /*
         * AnimationTimer timer1 = new AnimationTimer() { int velocity = 300; // Used to scale
         * distance changes long previousTime = System.nanoTime(); // Time Since app launch
         * 
         * double velocity2 = velocity * (r1.getWidth() / r2.getWidth());
         * 
         * // Move the circle by the dx and dy amounts
         * 
         * @Override public void handle(long now) { double elapsedTime = (now - previousTime) /
         * 1000000000.0; previousTime = now; double scale1 = elapsedTime * velocity; double scale2 =
         * elapsedTime * velocity2;
         * 
         * // setTranslationX(r1, r2);
         * 
         * r1.setLayoutX(r1.getLayoutX() + boolToInt(moveRight1) * scale1); //
         * r2.setLayoutX(r2.getLayoutX() + boolToInt(moveRight2) * scale);
         * r2.setLayoutX(r2.getLayoutX() + boolToInt(moveRight2) * scale2);
         * 
         * hitRight2(r2); hitLeft2(r2);
         * 
         * hitRight1(r1); hitLeft1(r1);
         * 
         * }
         * 
         * private void hitRight2(Rectangle r) { if (r.getLayoutX() <= 0) { moveRight2 = true; } }
         * 
         * private void hitLeft2(Rectangle r) { if (r.getLayoutX() >= pane.getWidth() -
         * r.getWidth()) { moveRight2 = false; } }
         * 
         * private void hitRight1(Rectangle r) { if (r.getLayoutX() <= 0) { moveRight1 = true; } }
         * 
         * private void hitLeft1(Rectangle r) { if (r.getLayoutX() >= pane.getWidth() -
         * r.getWidth()) { moveRight1 = false; } }
         * 
         * };
         * 
         * timer1.start();
         */

    }

    private List<Rectangle> initializeRectangles(int n, Rectangle r1, Rectangle r2) {

        return (n == 1)
                ? Arrays.asList(buildRectangle(110.0, 150.0, Color.BLUE),
                        buildRectangle(230.0, 150.0, Color.RED))
                : Arrays.asList(buildRectangle(230.0, 150.0, Color.RED),
                        buildRectangle(110.0, 150.0, Color.BLUE));

    }

    private void buildMovement(Bounds bounds, Rectangle r1, Rectangle r2) {

        Timeline timeline1 = new Timeline(new KeyFrame(Duration.seconds(2),
                new KeyValue(r1.layoutXProperty(), bounds.getMaxX() - r1.getWidth()),
                new KeyValue(r2.layoutXProperty(), bounds.getMinX())));
        Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(2),
                new KeyValue(r1.layoutXProperty(), bounds.getMinX()),
                new KeyValue(r2.layoutXProperty(), bounds.getMaxX() - r2.getWidth())));

        r1.boundsInParentProperty().addListener((observable, oldValue, newValue) -> {
            Bounds r1Bounds = r1.getBoundsInParent();
            Bounds r2Bounds = r2.getBoundsInParent();
            if (r1Bounds.intersects(r2Bounds)) {
                pane.getChildren().remove(shape);
                shape = Shape.intersect(r1, r2);
                // pane.getChildren().remove(shape);
                shape.setFill(Color.PURPLE);
                pane.getChildren().addAll(shape);
            } else {
                pane.getChildren().remove(shape);
            }
        });

        SequentialTransition sq = new SequentialTransition(timeline1, timeline2);
        sq.setCycleCount(1);
        sq.play();
        sq.setOnFinished(e -> {
            buildMovement(pane.getLayoutBounds(), r1, r2);
        });

    }

    private Rectangle buildRectangle(double width, double height, Color color) {

        Rectangle r = new Rectangle() {
            {
                setWidth(width);
                setHeight(height);
                setFill(color);
                setTranslateY(-(pane.getLayoutBounds().getMaxY() - height) * 0.5);
            }
        };

        return r;
    }


    @Override
    public void start(final Stage primaryStage) throws Exception {

        final Parent root = FXMLLoader.load(getClass().getResource("Rectangles.fxml"));

        final Scene scene = new Scene(root);
        primaryStage.setTitle("Rectangles");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(final String[] args) {

        launch(args);
    }

}
