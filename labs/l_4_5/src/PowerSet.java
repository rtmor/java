import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Scanner;

public class PowerSet {

    public static void main(String[] args) {

        System.out.print("Please enter size of set: ");
        Scanner keyboard = new Scanner(System.in);
        int size = keyboard.nextInt();

        ArrayList<Integer> input = new ArrayList<Integer>();
        for (int i = 1; i <= size; i++) {
            input.add(i);
        }

        ArrayList<ArrayList<Integer>> powerSet = getPowerSet(input);
        String display = powerSet.toString().replace("], ", "],\n");
        System.out.println(display);
        System.out.println("Count: " + powerSet.size());
        keyboard.close();
    }

    private static ArrayList<ArrayList<Integer>> getPowerSet(ArrayList<Integer> input) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (input.size() == 0) {
            return result;
                
        } else {
            for (int element : input) {
                for (ListIterator<ArrayList<Integer>> inputIterator = result.listIterator(); inputIterator.hasNext();) {
                    ArrayList<Integer> newSet = new ArrayList<>(inputIterator.next());
                    newSet.add(element);
                    inputIterator.add(newSet);
                }
                result.add(new ArrayList<>(Arrays.asList(element)));
            }
        }
        return result;
    }
}