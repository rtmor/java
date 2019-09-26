import java.util.ArrayList;
import java.util.Scanner;

/**
 * L.2.5 Allow the user to enter as many integers that they please and put them
 * into an array. You may not use an integer value to stop accepting input from
 * the user (i.e. "Enter -1 to quit" is not allowed). Sort the array using the
 * bubble sort algorithm and print it to the screen.
 */
public class l_2_5 {

    public static ArrayList<Integer> BubbleSort(ArrayList<Integer> number_list) {

        int size = number_list.size();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                // if given value is greater than the next - swap
                if (number_list.get(j) > number_list.get(j + 1)) {
                    int temp = number_list.get(j);
                    number_list.set(j, number_list.get(j + 1));
                    number_list.set(j + 1, temp);
                }
            }
        }
        return number_list;

    }

    public static void main(String[] args) {

        // initialize int_list ArrayList
        ArrayList<Integer> int_list = new ArrayList<Integer>();
        int i = 1;

        Scanner in = new Scanner(System.in);
        System.out.format("::Bubble Sort::\n" + "Add as many integers as desired\n" + "or a non-integer to quit\n\n");

        // while input matches integer data type
        // else break input promopt
        while (true) {
            System.out.printf("Enter integer %d: ", i);
            try {
                int_list.add(in.nextInt());
            } catch (Exception e) {
                in.close();
                break;
            }
            i++;
        }
        System.out.printf("\nSorted List:\n");
        System.out.println(BubbleSort(int_list));
    }
}