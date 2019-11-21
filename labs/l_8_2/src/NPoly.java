
/**
 * L.8.2: Create a program which prompts the user for an integer from 3 to 20.
 * Draw a closed shape of that many equal length sides on the screen (i.e. if 
 * the user enters 6, draw a hexagon).
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NPoly extends Application {

    public static void main(String[] args) {

        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("NPoly.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("NPolygon");
        stage.setScene(scene);
        stage.show();

    }

}