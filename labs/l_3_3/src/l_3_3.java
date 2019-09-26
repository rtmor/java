/**
 * L.3.3: Write a method called euclideanDistance which takes in two arrays of
 * type double of equal length representing points in a Euclidean space and
 * calculates the Euclidean distance between them. The arrays can be any length
 * in size but your function may assume that the arrays will always be the same
 * size. The arrays can be of any length, but they will be the same length.
 */
public class l_3_3 {

    public static void main(String[] args) {

        double[] i = { 1.3, 5.2, 6.7, 11.2, 12, 0 };
        double[] j = { 1.5, 22.5, 22.3, 51.1, 23.2 };

        System.out.println(euclideanDistance(i, j));
    }

    public static double euclideanDistance(double[] i, double[] j) {

        double sum = 0;

        for (int x = 0; x < i.length - 1; x++) {

            sum += Math.pow((i[x] - j[x]), 2);

        }

        return Math.sqrt(sum);

    }
}