
/**
 * H.7.3: Refactor the tip calculator so it no longer needs a button.  You should use property listeners to perform the calculations every time the user modifies a field.  You should also use a property binding to update the tip percentage label when appropriate.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TipCalculator extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub

		Parent root = FXMLLoader.load(getClass().getResource("TipCalculator.fxml"));

		Scene scene = new Scene(root);
		stage.setTitle("Tip Calculator");
		stage.setScene(scene);
		stage.show();

	}

}
