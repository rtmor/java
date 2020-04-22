import javafx.fxml.FXML;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * HypotenuseController
 */
public class HypotenuseController {

    DecimalFormat df = new DecimalFormat("#.##");

    @FXML
    private TextField lengthA;

    @FXML
    private TextField lengthB;

    @FXML
    private TextField hypotenuse;

    @FXML
    private Button btnHypotenuse;

    @FXML
    void getHypotenuse(ActionEvent event) {
        try {
            Double a = Double.parseDouble(lengthA.getText());
            try {
                Double b = Double.parseDouble(lengthB.getText());
                df.setRoundingMode(RoundingMode.CEILING);
                Double hypotenuseValue = Double.parseDouble(df.format(Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2))));
                hypotenuse.setText(hypotenuseValue.toString());
            } catch (NumberFormatException e) {
                hypotenuse.clear();
                hypotenuse.setPromptText("Hypotenuse");
                lengthB.setText("Enter Length B");
                lengthB.selectAll();
                lengthB.requestFocus();
            }
        } catch (NumberFormatException e) {
            hypotenuse.clear();
            hypotenuse.setPromptText("Hypotenuse");
            lengthA.setText("Enter Length A");
            lengthA.selectAll();
            lengthA.requestFocus();
        }

    }

    public static void main(String[] args) {

    }
}