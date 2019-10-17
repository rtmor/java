/**
 * Subtraction
 */
public class Subtraction extends Addition {

    public Subtraction(Expression left, Expression right) {
        super(left, new Multiplication(right, new Negate(new Constant(2))));
    }

    @Override
    public String toString() {
        return super.toString().replace("+", "-");
    }

    
}