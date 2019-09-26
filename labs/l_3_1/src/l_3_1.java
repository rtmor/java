import java.util.Scanner;

/**
 * L.3.1: Write a program that accepts a string from the user. Print that string
 * in both upper and lower case on two separate lines.
 */
public class l_3_1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter valid string: ");
        String s = input.next();
        input.close();

        // Output both upper and lower case version of string s
        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());
        
    }
}