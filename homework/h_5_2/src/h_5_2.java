import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * H.5.2: Research and find three unchecked exceptions and three checked
 * exceptions in Java. Write one method that generates each exception (so six
 * total) and test them in a main.
 */
public class h_5_2 {

    public static void main(String[] args) {
        generateException("cat");
    }

    public static void generateException(String x) {
        File file = new File(x);

        try {
            FileInputStream fis = new FileInputStream(file);
            fis.read();
            fis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            Class.forName(x);
            ClassLoader.getSystemClassLoader().loadClass(x);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            URL url = new URL(x);
            url.getPath();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            String ptr = null;
            if (ptr.equals(x)) {
                System.out.print("Same");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        try {
            int[] y = new int[1];
            if (y[5] == 12) {
                System.out.println("Nope");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        try {
            if ((int) x.charAt(0) > -100) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}