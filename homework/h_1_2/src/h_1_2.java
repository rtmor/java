import java.util.Random;

/**
 * H.1.2: Modify program H.1.1 to automatically test the program for both the
 * positive and negative cases of each situation.
 */
public class h_1_2 {

    public static void main(String[] args) {

        Random r = new Random();
        int z = r.nextInt(1);

        // generate rand int and determine if odd/even
        int n = r.nextInt(1000);
        if (is_odd(n)) {
            System.out.format("The number %d is odd", n);
        } else {
            System.out.format("The number %d is even", n);
        }

        // generate rand int and determine if prime < 100
        int p = r.nextInt(200);
        if (is_prime(p)) {
            System.out.format("\nThe number %d is a prime under 100", p);
        } else {
            System.out.format("\nThe number %d is not a prime under 100", p);
        }

        // generate rand int 65<c<90 || 97<c<122; determine if between 'N' & 'V'
        int c = (z == 0) ? r.nextInt((90 - 65) + 1) + 65 : r.nextInt((122-97) + 1) + 97;
        // int c = r.nextInt((122 - 65) + 1) + 65;
        if (isBetween(c)) {
            System.out.format("\nThe char %c is between 'N' and 'V'", c);
        } else {
            System.out.format("\nThe char %c is not between 'N' and 'V'", c);
        }

        // generate rand int and determine if solution
        int q = r.nextInt(20);
        if (isSolution(q)) {
            System.out.format("\nThe number %d is a solution to the above quadratic.", q);
        } else {
            System.out.format("\nThe number %d is not a solution to the above quadratic.", q);
        }
    }

    public static boolean isSolution(int n) {

        if (Math.pow(n, 2) + 5 * n + 6 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isBetween(int c) {

        char a = 'N';
        char b = 'V';

        if (c > (int) a && c < (int) b) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean is_odd(int n) {

        if (Math.abs(n) % 2 == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean is_prime(int n) {
        if (n <= 1 || n > 100) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}