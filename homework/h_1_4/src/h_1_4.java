import java.util.Scanner;

/**
 * H.1.4: Write a program that accepts three doubles from the user: A, B, and C.
 * Assuming these are the A, B, and C coefficients of a quadratic equation, use
 * the quadratic formula to display the roots rounded to two decimal places. If
 * the roots are imaginary (i.e. the discriminate is negative) display so and
 * quit, do not calculate the roots. You might need Math.sqrt().
 */
public class h_1_4 {

    public static void main(String[] args) {

        int a, b, c;
        double discriminate, root1, root2;

        System.out.print("Provide three coefficients of quadratic eqn: ");
        Scanner input = new Scanner(System.in);
        a = input.nextInt();
        b = input.nextInt();
        c = input.nextInt();
        input.close();

        discriminate = (Math.pow(b, 2) - (4 * a * c));

        if (discriminate > 0) {
            root1 = (((b * -1) + Math.sqrt(discriminate)) / 2 * a);
            root2 = (((b * -1) - Math.sqrt(discriminate)) / 2 * a);

            System.out.format("\nRoots of %dx^2 + %dx + %d\n", a, b, c);
            System.out.format("x = %.2f, %.2f", root1, root2);

        } else {
            System.out.println("The discriminate is negative. Exiting.");
            System.exit(1);
        }
    }
}