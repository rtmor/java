import java.util.ArrayList;

/**
 * L.2.3 Using integer data types determine the index of the Fibonacci number
 * that is the largest which the integer data type can handle.
 */
public class l_2_3 {

    static int[] largest() {

        // initialize beginning variables
        int a = 1, b = 0, c = 0;

        // initialize return array
        int[] results = new int[2];

        // initialize list to hold fib numbers
        ArrayList<Integer> sequence = new ArrayList<Integer>();
        sequence.add(0);

        // while fib number is positive
        while (a + b >= c) {
            c = a + b;
            a = b;
            b = c;
            sequence.add(c);
        }

        int size = sequence.size();

        // organize size and max fib value for return
        results[0] = c;
        results[1] = size;
        return results;
    }

    public static void main(String[] args) {

        int[] ans = largest();
        System.out.format("Greatest Fib Value for Type Int: %d\n", ans[0]);
        System.out.format("Index value of fib value: %9d", ans[1] - 1);

    }
}