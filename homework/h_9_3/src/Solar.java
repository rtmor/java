import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.Circle;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Solar extends Application {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane galaxyPane;

    @FXML
    private Ellipse orbit1;

    @FXML
    private Ellipse orbit2;

    @FXML
    private Ellipse orbit3;

    @FXML
    private Ellipse orbit4;

    @FXML
    private Ellipse orbit5;

    @FXML
    private Ellipse orbit6;

    private final Circle planet1 = new Circle(12.0, Color.web("#d08770"));
    private final Circle planet2 = new Circle(10.0, Color.web("#b48ead"));
    private final Circle planet3 = new Circle(16.0, Color.web("#81a1c1"));
    private final Circle planet4 = new Circle(13.0, Color.web("#a3be8c"));
    private final Circle planet5 = new Circle(8.0, Color.web("#bf616a"));
    private final Circle planet6 = new Circle(8.0, Color.web("#d8dee9"));

    private final List<Circle> planets = new ArrayList<>();
    private final List<Ellipse> orbits = new ArrayList<>();

    private PathTransition pt = new PathTransition();
    private Double count = 4.0;

    @FXML
    public void initialize() {

        Collections.addAll(
            planets, planet1, planet2, 
            planet3, planet4, planet5, planet6);
        Collections.addAll(
            orbits, orbit1, orbit2, 
            orbit3, orbit4, orbit5, orbit6);

        final Map<Circle, Ellipse> result = 
            IntStream.range(0, planets.size()).boxed()
                .collect(Collectors.toMap(i -> planets.get(i), 
                i -> orbits.get(i)));

        result.forEach((p, o) -> setPlanet(p, o));
        result.forEach((p, o) -> buildPath(p, o));
        orbits.forEach(o -> o.setStroke(Color.WHITE));

        galaxyPane.setBackground(new Background(new BackgroundFill(Color.web("#3b4252"), null, null)));
        galaxyPane.getChildren().addAll(planets);
        galaxyPane.getChildren().add(buildLabel());
    }

    private Label buildLabel() {

        Label warning = new Label("Model Drawn Exactly to Scale") {
            {
                setLayoutX(10);
                setLayoutY(galaxyPane.getHeight() + 10);
                setFont(Font.font(16.0));
                setTextFill(Color.WHITE);
            }
        };

        buildDisclaimer(warning);

        return warning;

    }

    private void buildPath(final Circle p, final Ellipse o) {

        final Path path = createEllipsePath(
            o.getLayoutX() + 
            o.getRadiusX(),
            o.getLayoutY(),
            o.getRadiusX(), 
            o.getRadiusY(), 
            0.0);

        galaxyPane.getChildren().add(path);

        pt = new PathTransition();
        pt.setDuration(Duration.seconds(count *= 1.25));
        pt.setPath(path);
        pt.setNode(p);
        pt.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setInterpolator(Interpolator.LINEAR);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(false);
        pt.play();

        System.out.println(String.format("%s : %f", p.getId(), count));

    }

    private Path createEllipsePath(final double centerX, final double centerY, final double radiusX,
            final double radiusY, final double rotate) {
        final ArcTo arcTo = new ArcTo() {
            {
                setX(centerX - radiusX + 1); 
                setY(centerY - radiusY);
                setSweepFlag(false);
                setLargeArcFlag(true);
                setRadiusX(radiusX);
                setRadiusY(radiusY);
                setXAxisRotation(rotate);
            }
        };

        final Path path = new Path();
        path.getElements()
                .addAll(new MoveTo(
                centerX - radiusX, centerY - radiusY), 
                arcTo, new ClosePath());
        path.setStroke(Color.rgb(0, 0, 0, 0));
        return path;

    }

    private void buildDisclaimer(Label warning) {
        
        FadeTransition fade = new FadeTransition(Duration.seconds(1.5), warning);
        fade.setFromValue(1.0);
        fade.setToValue(0.0);
        fade.setAutoReverse(true);
        fade.setCycleCount(Animation.INDEFINITE);
        fade.play();

    }

    private void setPlanet(final Circle planet, final Ellipse orbit) {
        final Bounds bounds = orbit.getBoundsInParent();
        planet.setCenterX(bounds.getMaxX());
        planet.setCenterY(galaxyPane.getPrefHeight() / 2);
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {

        final Parent root = FXMLLoader.load(getClass().getResource("Solar.fxml"));

        final Scene scene = new Scene(root);
        primaryStage.setTitle("Solar System");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(final String[] args) {

        launch(args);
    }

}
