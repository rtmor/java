import java.math.BigInteger;

public class Combination {

    private static boolean useFact;

    /**
     * Computes some combinations.
     * 
     * @param args unused
     */
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            useFact = (i % 2 == 0);
            System.out.println(useFact ? "FACTORIAL METHOD" : "RECURSIVE METHOD");
            System.out.println();

            combination(2, 2);
            combination(3, 2);
            combination(4, 3);
            combination(10, 2);
            combination(52, 5);
            combination(60, 4);
            combination(75, 3);
            combination(100, 4);
            System.out.println();
        }
    }

    /**
     * A method which switches between the two combination methods
     * 
     * @param n the number of things
     * @param k how many to choose
     */
    public static void combination(int n, int k) {
        System.out.print(n + " choose " + k + " = ");
        try {
            if (useFact)
                System.out.println(combinationFactorial(n, k));
            else
                System.out.println(combinationRecursive(n, k));
        } catch (ArithmeticException ex) {
            System.out.println("LOL!");
            ex.printStackTrace();
        }
    }

    /**
     * Computes the factorial of n. Try not to be jealous of glorious for loop.
     * 
     * @param n the number whose factorial to compute
     * @return n!
     */
    private static BigInteger fact(int n) {
        BigInteger prod = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            prod = prod.multiply(new BigInteger(i + ""));
        }
        return prod;
    }

    /**
     * Computes the number of ways to take n things k at a time
     * 
     * @param n things to choose from
     * @param k in a group
     * @return the number of ways to take n things k at a time
     */
    private static String combinationFactorial(int n, int k) {

        BigInteger product;

        // divide BigNumber fact(n) by BigNumber (fact(k) * fact(n-k))
        product = (fact(n).divide(fact(k).multiply(fact(n - k))));

        return product.toString();

    }

    /**
     * Computes the number of ways to take n things k at a time
     * 
     * @param n things to choose from
     * @param k in a group
     * @return the number of ways to take n things k at a time
     */
    public static int combinationRecursive(int n, int k) {

        if (n == k || k == 0) {
            return 1;
        } else {
            return combinationRecursive(n - 1, k - 1) + 
                  combinationRecursive(n - 1, k);
        }
    }

}