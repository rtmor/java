import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * H.3.2: Complete exercise H.3.1 using the function you wrote in L.3.3.
 * 
 * H.3.1: Write a method that takes in two strings as parameters and returns a
 * boolean. The two strings are filenames. Open up each file and compare their
 * contents. Your method should return true if the contents are equal and false
 * if they are not.
 * 
 */
public class h_3_2 {

    public static void main(String[] args) throws IOException {

        ArrayList<Integer> f1 = new ArrayList<Integer>();
        ArrayList<Integer> f2 = new ArrayList<Integer>();
        ArrayList<Integer> f3 = new ArrayList<Integer>();

        File file1 = new File("./file1");
        File file2 = new File("./file2");
        File file3 = new File("./file3");

        FileReader fr1 = new FileReader(file1);
        FileReader fr2 = new FileReader(file2);
        FileReader fr3 = new FileReader(file3);

        BufferedReader br1 = new BufferedReader(fr1);
        BufferedReader br2 = new BufferedReader(fr2);
        BufferedReader br3 = new BufferedReader(fr3);

        // transform each file into array of ascii characters
        // feed each object of both arrays into euclidean

        String str1;
        String str2;
        String str3;

        while ((str1 = br1.readLine()) != null) {
            for (char c : str1.toCharArray()) {
                f1.add((int)c);
            }
        } 

        while ((str2 = br2.readLine()) != null) {
            for (char c : str2.toCharArray()) {
                f2.add((int)c);
            }
        }

        while ((str3 = br3.readLine()) != null) {
            for (char c : str3.toCharArray()) {
                f3.add((int)c);
            }
        }

        if (f1.size() == f2.size()) {
            System.out.println(euclideanDistance(f1, f2));
        } else {
            System.out.println("Array lengths incompatible");
        }

        br1.close();
        br2.close();
        br3.close();

    }

    public static double euclideanDistance(ArrayList<Integer>i, ArrayList<Integer> j) {

        double sum = 0;

        for (int x = 0; x < i.size(); x++) {
            sum += Math.pow((i.get(x) - j.get(x)), 2);
        }

        return Math.sqrt(sum);

    }
}