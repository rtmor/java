/**
 * Division
 */
public class Division extends Multiplication {

    private Expression right;
    private Expression left;

    public Division(Expression left, Expression right) {
        super(left, right);
        this.left = left;
        this.right = right;
    }


    @Override
    public int evaluate() {
        return left.evaluate() / right.evaluate();
    }

    @Override
    public String toString() {
        return super.toString().replace("*", "/");
    }


    
}