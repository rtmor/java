import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * CalculatorController
 */
public class CalculatorController {

    @FXML
    private Label result;
    private long number1 = 0;
    private String operator = "";
    private Boolean start = true;
    private Calculate calculate = new Calculate();

    @FXML
    public void getNumber(ActionEvent event) {

        if (start) {
            result.setText("");
            start = false;
        }

        String value = ((Button) event.getSource()).getText();
        result.setText(result.getText() + value);

    }

    @FXML
    public void getOperand(ActionEvent event) {

        String value = ((Button) event.getSource()).getText();

        if (!value.equals("=")) {
            if (!operator.isEmpty()) {
                return;
           } 
            operator = value;
            number1 = Long.parseLong(result.getText());
            result.setText("");
        } else {
            if (operator.isEmpty()) {
                return;
            } 
            long number2 = Long.parseLong(result.getText());
            float output = calculate.getCalculate(number1, number2, operator);
            result.setText(String.valueOf(output));
            operator = "";
            start = true;
        }

    }

}