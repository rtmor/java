import java.util.ArrayList;

/**
 * L.2.3 Using integer data types determine the index of the Fibonacci number
 * that is the largest which the integer data type can handle.
 */
public class l_2_4 {

    static int largest() {

        // initialize beginning variables
        double a = 1, b = 0, c = 0;

        // initialize return array

        // initialize list to hold fib numbers
        ArrayList<Integer> sequence = new ArrayList<Integer>();
        sequence.add(0);
        int i = 1;

        // while fib number is less than doublem.Max 
        while ( a + b <= Double.MAX_VALUE) {
            c = a + b;
            a = b;
            b = c;
            i++;
        }


        // organize size and max fib value for return
        return i;
    }

    public static void main(String[] args) {

        int ans = largest();
        System.out.format("Index value of fib value: %9d", ans - 1);

    }
}