/**
 * L.1.4: For any side or hypotenuse of a right triangle of size greater than 1
 * but less than or equal to 500, print a table of Pythagorean triples (with
 * appropriate table headers). The table must not include duplicates: if 3 and 4
 * are listed as legs with hypotenuse 5, the output should not contain 4 and 3
 * listed as legs with hypotenuse 5.
 */
public class l_1_4 {

    public static void main(String[] args) {

        int a, b, c = 0;
        int limit = 500;
        int m = 2;

        System.out.println("a   +   b   =   c");
        System.out.println("-----------------");

        while (c <= 500) {
            for (int n = 1; n < m; n++) {
                a = m * m - n * n;
                b = 2 * m * n;
                c = m * m + n * n;

                if (c > limit) {
                    break;
                }
                System.out.format("%-7d %-7d %-7d\n", a, b, c);
            }
            m++;
        }
    }
}