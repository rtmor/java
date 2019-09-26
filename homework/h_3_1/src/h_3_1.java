import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * H.3.1: Write a method that takes in two strings as parameters and returns a
 * boolean. The two strings are filenames. Open up each file and compare their
 * contents. Your method should return true if the contents are equal and false
 * if they are not.
 */
public class h_3_1 {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the names of two files to compare: ");

        String file1 = input.next();
        String file2 = input.next();

        if (compare(file1, file2)) {
            System.out.println("The two files are IDENTICAL");
        } else {
            System.out.println("The two files are UNIQUE");
        }
        input.close();
    }

    public static boolean compare(String file1, String file2) throws FileNotFoundException {
        
        BufferedReader input1 = new BufferedReader(new FileReader(file1));
        BufferedReader input2 = new BufferedReader(new FileReader(file2));

        try {
            String content1 = input1.readLine();
            String content2 = input2.readLine();
            
            while(content1 != null && content2 != null) {
                if(!content1.equalsIgnoreCase(content2)) {
                    input1.close();
                    input2.close();
                    return false;
                } else {
                    content1 = input1.readLine();
                    content2 = input2.readLine();
                }
            }
		} catch (IOException e) {
			System.out.println("Error: The file(s) do not exist");
        }
        return true;
    }
}