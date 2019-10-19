/**
 * Division
 */
public class Division extends Multiplication {

    public Division(Expression left, Expression right) {
        super(left, new Exponent(right, -1));
    }

    @Override
    public String toString() {
        return super.toString().replace("*", "/").replace("^ -1", "");
    }


    
}