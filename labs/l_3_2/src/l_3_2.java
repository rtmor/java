import java.util.Scanner;

/**
 * L.3.2: Write a program that accepts a string form the user. List all
 * characters in the string from lowest ASCII value to highest and output the
 * number of occurences for each of those characters.
 */
public class l_3_2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter valid string: ");
        String s = input.next();
        input.close();

        for (int i = 0; i < s.length(); i++) {
            System.out.printf("%c:%d\n", s.charAt(i), (int) s.charAt(i));
        }

    }
}