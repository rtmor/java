import java.text.DecimalFormat;

/**
 * Calculate
 */
public class Calculate {

    private static DecimalFormat df = new DecimalFormat("#.##");

    public double getCalculate(double number1, double number2, String operand) {

        switch (operand.charAt(0)) {
        case '+': {
            return Double.parseDouble(df.format(number1 + number2));
            }
        case '-': {
            return Double.parseDouble(df.format(number1 - number2));
        }
        case 'x': {
            return (number1 * number2);
        }
        case '/': {
            return (number1 / number2);
        }
        default:
            return 0;
        }
    }
}