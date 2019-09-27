/**
 * L.4.2: Add a "pow" method that raises a Rational to a Rational power (i.e.
 * raise 1/4 to the 5/6 power should be possible) and returns a double (not a
 * Rational, because rational numbers are not closed under exponentiation). Add
 * a method called "reciprocal" that returns a Rational object that is the
 * reciprocal of the Rational. Add a method called divide that divides one
 * Rational by another Rational and returns a Rational (be sure to disallow
 * division by zero). Your divide method can only be one line of code and should
 * use two of the other methods that Rational has in place already. Update
 * L.4.1. to include the new methods in your tests.
 */
public class l_4_2 {

    public static void main(String[] args) {
        
        int num1 = 2;
        int den1 = 1;
        int num2 = 3;
        int den2 = 1;

        Rational r = new Rational(num1, den1);
        Rational x = new Rational(num2, den2);

        // return POW
        System.out.println(r.pow(r, x));

        // return reciprocal
        System.out.println(r.reciprocal(r));

        // return division
        System.out.println(r.divide(r, x));
    }
}