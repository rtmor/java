import java.util.Scanner;

/**
 * L.1.6: Prompt the user for a string of no more than 10 characters (but it can
 * be less). Display an error message if the string is longer than 10
 * characters. Display the ASCII value of each character of the string. Using
 * integer math find the average ASCII value of the string and display its
 * corresponding character.
 */
public class l_1_6 {

    public static void main(String[] args) {

        int sum = 0;

        System.out.print("Enter string containing 10 characters or less: ");
        Scanner input = new Scanner(System.in);
        String s = input.next();
        input.close();

        if (s.length() <= 10) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                System.out.println((int) c);
                sum += (int) c;

            }
            int average = (sum / s.length());
            System.out.format("Average ASCII Value: %2d - %c", average, (char) average);
        } else {
            System.out.println("Invalid String Length");
            System.exit(1);
        }
    }
}