import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * L.6.4: Using the example from Lab 4, create a GUI which allows you to add,
 * subtract, multiply, and divide Rational numbers by entering the numerator and
 * denominator in separate fields. The results should also be displayed in two
 * separate fields.
 */
public class l_6_4 extends Application {

    
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


        Parent root = FXMLLoader.load(getClass().getResource("Rational.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Rational Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}