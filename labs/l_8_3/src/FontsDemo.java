import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FontsDemo extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		launch(args);
		
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		Parent root =
				FXMLLoader.load(getClass().getResource("FontCSS.fxml"));
		
		Scene scene = new Scene(root);
		
		//scene.getStylesheets().add(getClass().getResource("FontsCSS.css").toExternalForm());
		
		stage.setTitle("Fonts Demo");
		stage.setScene(scene);
		stage.show();
		
	}

}
