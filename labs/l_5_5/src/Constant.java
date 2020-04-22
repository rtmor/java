
public class Constant implements Expression {

    private final int value;

    /**
     * 
     * @param value
     */
    public Constant(int value) {
        this.value = value;
    }

    @Override
    public double evaluate() {
        return this.value;
    }

    @Override
    public String toString() {
        return String.format(" %d ", this.value);
    }

}