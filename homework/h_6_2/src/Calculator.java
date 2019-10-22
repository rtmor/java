import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * H.6.2: Take your finished product from H.6.1 and make it a functional
 * calculator. You may choose one of the following options:
 * 
 * 1. Program the calculator so that the following sequence of button presses
 * will work: 2 + 2 = (4 is then displayed) 6 + 4 = (ten is then displayed). In
 * other words, it does not use the result of the previous calculation to
 * determine the new one.
 */
public class Calculator extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("Calculator.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Awful Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
        

    }
}