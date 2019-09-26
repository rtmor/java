import java.util.Scanner;

/**
 * H.2.1: Write a program that converts a user-entered binary number to a
 * decimal number. Your program must use loops, modulus, and division.
 */
public class h_2_1 {

    public static int bin2dec(int binary) {

        int decimal = 0;
        int base = 1;
        int temp = binary;

        while (temp > 0) {
            int digit = temp % 10;
            temp /= 10;
            decimal += digit * base;
            base *= 2;
        }

        return decimal;
    }
    public static void main(String[] args) {

        int binary;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter binary value to convert to decimal: ");
        binary = input.nextInt();
        input.close();

        System.out.printf("Binary: %d - Decimal: %d", binary, bin2dec(binary));

    }
}