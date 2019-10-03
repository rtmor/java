import java.util.ArrayList;
import java.util.Scanner;

/**
 * H.4.2: Create a class called Queens. The constructor should take in a single
 * integer. The class should have a method which returns a three-dimensional
 * arraylist of solutions for the N-Queens problem where N is the integer taken
 * in by the constructor. The result is an ArrayList of two dimensional
 * ArrayLists representing the board (hence why it is three-dimensional). In
 * your main prompt the user for which size Queens problem they would like to
 * solve, then print the results and the total number of results.
 */
public class h_4_2 {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Solve N-Queens");
        System.out.println("--------------");
        int n = input.nextInt();


        Queens q = new Queens(n);

        ArrayList<ArrayList<String>> result = q.solveNQueens();
        for (ArrayList<String> list : result)
            System.out.println(list);
    }
}