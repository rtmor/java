import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;

/**
 * l_6_1
 */
public class l_6_1 extends Application {

    public static void main(String[] args) {
       launch(args); 
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("l_6_1.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Kinnsley");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
}