import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 * H.4.3: Write a program that takes in the full text of The Time Machine
 * written by H.G. Wells. Replace all instances of "--" with space. From that
 * result, remove any character that is not A-Z, a-z, or space. From that
 * result, convert the entire text to uppercase. From that result split the
 * string on space and store the results in a String array. Use the recursive
 * merge sort algorithm sort the words array alphabetically.
 */
public class TimeMachine {

    public static void main(String[] args) {

        String location = "https://www.gutenberg.org/files/35/35.txt";
        String line;
        ArrayList<String> collection = new ArrayList<String>();

        try {
            URL url = new URL(location);
            BufferedReader text = new BufferedReader(new InputStreamReader(url.openStream()));

            while ((line = text.readLine()) != null) {
                String[] words;
                words = rmNonAlpha(rmDash(line)).toUpperCase().split("\\s+");
                for (String word : words) {
                    if (word.matches("[a-zA-Z]+")) {
                        collection.add(word.trim());
                    }
                }
            }

            text.close();

            testCollection();

/* 
            mergeSort(collection);

            System.out.println(collection);
            System.out.println(collection.size()); */

        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    }

    /**
     * recursively splits collection by two
     * @param words
     */

    public static void mergeSort(ArrayList<String> words) {

        if (words.size() > 1) {
            ArrayList<String> left = new ArrayList<String>();
            ArrayList<String> right = new ArrayList<String>();

            for (int i = 0; i < words.size() ; i++) {
                if (i < words.size() / 2) {
                    left.add(i, words.get(i));
                } else {
                    right.add(i - words.size() /2 , words.get(i));
                }
            }

            mergeSort(left);
            mergeSort(right);
            merge(words, left, right);

        }
    }

    /**
     * sort left and right and recompile to main collection
     * @param words
     * @param left
     * @param right
     */
    private static void merge(ArrayList<String> words, ArrayList<String> left, ArrayList<String> right) {

        int a = 0;
        int b = 0;

        for (int i = 0; i < words.size(); i++) {
            if (b >= right.size() || (a < left.size() && left.get(a).compareToIgnoreCase(right.get(b)) < 0)) {
                words.set(i, left.get(a));
                a++;
            } else {
                words.set(i, right.get(b));
                b++;
            }
        }
    }

    /**
     * 
     * @param line buffered line
     * @return line with all double dashes removed
     */
    public static String rmDash(String line) {

        return line.replaceAll("--", "");
    }

    /**
     * 
     * @param line buffered line
     * @return remove all non-alphabetical + non-whitespace characters
     */
    public static String rmNonAlpha(String line) {

        return line.replaceAll("[^a-zA-Z\\s]", "");
    }

    /**
     * Test collection for debugging
     * @return test collection
     */
    public static void testCollection() {

        ArrayList<String> test = new ArrayList<String>();
        
        test.add("l");
        test.add("q");
        test.add("p");
        test.add("a");

        mergeSort(test);
        System.out.println(test);
    }
}