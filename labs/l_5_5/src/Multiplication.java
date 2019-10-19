

public class Multiplication implements Expression {


    private final Expression value1;
    private final Expression value2;

    /**
     * 
     * @param sumTwoFour
     * @param negOne
     */
	public Multiplication(Expression sumTwoFour, Expression negOne) {
        this.value1 = sumTwoFour;
        this.value2 = negOne;
	}

    @Override
    public double evaluate() {
        return value1.evaluate() * value2.evaluate();
    }

    public double getLeft() {
        return value1.evaluate();
    }

    public double getRight() {
        return value2.evaluate();
    }

    /** 
     * @return String
     */
    @Override
    public String toString() {
        return String.format(" (%s * %s) ", this.value1, this.value2);
    }


}
