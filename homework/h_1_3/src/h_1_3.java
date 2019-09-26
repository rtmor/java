import java.util.Scanner;

/**
 * H.1.3: Write a program that asks the user for an integer. Use any of the
 * shift operators (<<, >>, <<=, >>=) to divide the number by 2 and multiple the
 * number by 2. Display the results. You may not use any other operators to do
 * the multiplication or division.
 */
public class h_1_3 {

    public static void main(String[] args) {

        System.out.println("Enter an integer: ");
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        input.close();

        System.out.println(x << 1);
        System.out.println(x >> 1);

    }
}