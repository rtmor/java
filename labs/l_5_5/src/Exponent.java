

public class Exponent implements Expression {

	private final Expression value;
    private final int exponent;

    public Exponent(Expression mult, int i) {
        this.value = mult;
        this.exponent = i;
	}

    @Override
    public double evaluate() {
        return Math.pow(value.evaluate(), exponent);
    }

    /** 
     * @return String
     */
    @Override
    public String toString() {
        return String.format(" %s ^ %s ", this.value, this.exponent);
    }

}
