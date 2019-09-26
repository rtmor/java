import java.util.Scanner;

/**
 * L.3.6: Write a program that prints all characters of a user-entered string in
 * order, giving each first letter the chance to start first. For example, if
 * the user enters "happy" the program should print:
 * 
 * happy appyh ppyha pyhap yhapp
 */
public class l_3_6 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Please provide a string: ");
        String userString = input.nextLine();
        input.close();

        for (int i = 0; i < userString.length(); i++) {

            String tempString = "";

            for (int j = 0; j < userString.length(); j++) {

                tempString += userString.charAt((i + j) % userString.length());
            }
            System.out.println(tempString);
        }

    }
}