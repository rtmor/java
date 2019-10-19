import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;

public class Welcome extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Welcome to JavaFX!");
		stage.setScene(scene);
		stage.show();
	}

}
