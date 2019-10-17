
public class Negate implements Expression {

    private final Constant value;

    public Negate(Constant constant) {
        this.value = constant;
    }

    @Override
    public int evaluate() {
        return value.evaluate() * -1;
    }

    /**
     * @return
     * @see Constant#toString()
     */

    @Override
    public String toString() {
        return String.format(" %s  ", -1);
    }

}
