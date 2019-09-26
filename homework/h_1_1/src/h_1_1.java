import java.util.Scanner;

/**
 * H.1.1: Write a program that does the following in succession: Accept a number
 * * from the user, determine if that number is odd and print the result Accept
 * a number from the user, determine if that * number is a non-zero negative
 * number and print the result Accept a * number from the user, determine if
 * that number is a prime number less than * 100 and print the result Accept a
 * letter * from the user, determine if that letter is a capital between N and V
 * and * print the result Accept a number from the user, determine if that
 * number is a * solution to the quadratic equation x2 + 5x + 6 (i.e. plug x
 * into the formula and see if it equals zero) and print the result
 */
public class h_1_1 {

    public static void main(String[] args) {

        System.out.print("Determine if the following int is odd: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        is_odd(n);

        System.out.print("\n\nDetermine if int is prime under 100: ");
        int p = input.nextInt();
        if (is_prime(p)) {
            System.out.format("The number %d is a prime under 100", p);
        } else {
            System.out.format("The number %d is not a prime under 100", p);
        }

        System.out.print("\n\nDetermine if char is between 'N' and 'V': ");
        char c = input.next().charAt(0);
        if (isBetween(c)) {
            System.out.format("The char %c is between 'N' and 'V'", c);
        } else {
            System.out.format("The char %c is not between 'N' and 'V'", c);
        }

        System.out.print("\n\nDetermine if int is solution to x^2 + 5x + 6: ");
        int q = input.nextInt();
        input.close();
        if (isSolution(q)) {
            System.out.format("The number %d is a solution to the above quadratic.", q);
        } else {
            System.out.format("The number %d is not a solution to the above quadratic.", q);
        }
    }

    public static boolean isSolution(int n) {

        if (Math.pow(n, 2) + 5 * n + 6 == 0) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean isBetween(char c) {

        char a = 'N';
        char b = 'V';

        if ((int) c > (int) a && (int) c < (int) b) {
            return true;
        } else {
            return false;
        }
    }

    public static void is_odd(int n) {

        if (n % 2 == 1) {
            System.out.format("The number %d is odd.", n);
        } else {
            System.out.format("The number %d is not odd", n);
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