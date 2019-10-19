
public class Negate implements Expression {

    private final Expression value;

    public Negate(Expression constant) {
        this.value = constant;
    }

    @Override
    public double evaluate() {
        return value.evaluate() * -1;
    }

    /**
     * @return
     * @see Constant#toString()
     */

    @Override
    public String toString() {
        return String.format(" - ( %s )  ", value.toString());
    }

}
