

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
    public int evaluate() {
        return value1.evaluate() * value2.evaluate();
    }

    public int getLeft() {
        return value1.evaluate();
    }

    public int getRight() {
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
