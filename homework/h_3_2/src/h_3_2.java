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

    public static void main(String[] args) {

    }

    public static double euclideanDistance(double[] i, double[] j) {

        double sum = 0;

        for (int x = 0; x < i.length - 1; x++) {
            sum += Math.pow((i[x] - j[x]), 2);
        }

        return Math.sqrt(sum);

    }
}