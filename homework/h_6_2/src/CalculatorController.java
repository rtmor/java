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
    private Double number1;
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
            number1 = Double.parseDouble(result.getText());
            result.setText(result.getText() + operator);
        } else {
            if (operator.isEmpty()) {
                return;
            } 
            double number2 = Double.parseDouble(result.getText().split("[x/+-]")[1]);
            double output = calculate.getCalculate(number1, number2, operator);
            result.setText(String.valueOf(output));
            operator = "";
            start = true;
        }

    }

}