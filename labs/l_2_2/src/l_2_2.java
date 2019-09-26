import java.util.Arrays;
import java.util.Scanner;

/**
 * L.2.2 Prompt the user to enter a number greater than 100 and less than or
 * equal to 1000. Verify that the input meets that criteria and re-prompt the
 * user if it does not. Using the Sieve of Eratosthenes print all prime numbers
 * between 2 and the number that was input by the user.
 */
public class l_2_2 {

    void sieveOfEratosthenes(int n) {
        boolean range[] = new boolean[n + 1];
        Arrays.fill(range, true);

        for (int p = 2; p * p <= n; p++) {
            if (range[p] == true) {
                for (int i = p * p; i <= n; i += p)
                    range[i] = false;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (range[i] == true)
                System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {

        int int_x = 0;
        Scanner input = new Scanner(System.in);

        while (int_x < 100 || int_x > 1000) {

            System.out.print("Enter an integer greater than 100 but less than or equal to 1000: ");
            int_x = input.nextInt();
        }

        input.close();

        l_2_2 g = new l_2_2();
        g.sieveOfEratosthenes(int_x);

    }
}