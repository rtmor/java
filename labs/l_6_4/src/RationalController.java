import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * RationalController
 */
public class RationalController {

    @FXML
    private ComboBox<String> operand;

    @FXML
    private Button getResult;

    @FXML
    private TextField num1;

    @FXML
    private TextField den1;

    @FXML
    private TextField num2;

    @FXML
    private TextField den2;

    @FXML
    private TextField resNum;

    @FXML
    private TextField resDen;

    
    /** 
     * @param event
     */
    @FXML
    void getResult(ActionEvent event) {
        try {
            Rational one = new Rational(Integer.parseInt(num1.getText()), Integer.parseInt(den1.getText()));
            try {
                Rational two = new Rational(Integer.parseInt(num2.getText()), Integer.parseInt(den2.getText()));
                switch (operand.getValue()) {
                case "Addition": {
                    resNum.setText(Integer.toString(one.add(two).getNumerator()));
                    resDen.setText(Integer.toString(one.add(two).getDenominator()));
                    break;
                }
                case "Subtraction": {
                    Rational neg = new Rational(-1, 1);
                    resNum.setText(Integer.toString(one.add(two.multiply(neg)).getNumerator()));
                    resDen.setText(Integer.toString(one.add(two.multiply(neg)).getDenominator()));
                    break;
                }
                case "Multiply": {
                    resNum.setText(Integer.toString(one.multiply(two).getNumerator()));
                    resDen.setText(Integer.toString(one.multiply(two).getDenominator()));
                    break;
                }
                case "Divide": {
                    resNum.setText(Integer.toString(one.divide(one, two).getNumerator()));
                    resDen.setText(Integer.toString(one.divide(one, two).getDenominator()));
                    break;
                }
                default:
                    System.out.println("No Case");
                    break;
                }
            } catch (NumberFormatException e) {
                num2.setText("Provide Numerator");
                den2.setText("Provide Denominator");
                num2.selectAll();
                num2.requestFocus();
            }
        } catch (NumberFormatException e) {
            num1.setText("Provide Numerator");
            den2.setText("Provide Denominator");
            num1.selectAll();
            num1.requestFocus();
        }
    }

    @FXML
    public void initialize() {

        operand.getItems().addAll("Addition", "Subtraction", "Multiply", "Divide");
    }
}