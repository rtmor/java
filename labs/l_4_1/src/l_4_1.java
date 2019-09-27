/**
 * L.4.1: Create a main class which tests all functions of the Rational class.
 */
public class l_4_1 {

    public static void main(String[] args) {
        
        int num = 5;
        int den = 12;

        Rational r = new Rational(num, den);

        System.out.println(r.getNumerator());
        System.out.println(r.getDenominator());
        r.setNumerator(4);
        r.setDenominator(9);
        System.out.println(r.toString());
        System.out.println(r.equals(r));
        System.out.println(r.multiply(r));
        System.out.println(r.add(r));
        System.out.println(r.toString());

    }
}