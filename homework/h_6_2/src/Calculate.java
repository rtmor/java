/**
 * Calculate
 */
public class Calculate {

    public float getCalculate(long number1, long number2, String operand) {

        switch (operand) {
        case "+": {
            return number1 + number2;
            }
        case "-": {
            return number1 - number2;
        }
        default:
            return 0;
        }
    }
}