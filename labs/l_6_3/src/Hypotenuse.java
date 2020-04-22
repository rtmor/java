import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * L.6.3: Create a window that calculates the hypotenuse from two sides of a
 * triangle. It should work as such: enter the 2 sides in text fields and then
 * press a calculate button. The result is then displayed in the same window on
 * a label or textfield.
 */
public class Hypotenuse extends Application {

    public static void main(String[] args) {
        launch(args);
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Hypotenuse.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Hypotenuse Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}