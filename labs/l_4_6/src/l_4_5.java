import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

/**
 * L.4.6: Randomly populate a TreeSet with 50 integers between 0 and 100,
 * inclusive. If Random produces the same number twice the set will
 * automatically remove it and that is fine. Print all of the numbers less than
 * 50 using the headSet function of TreeSet. Print all of the numbers greater
 * than or equal to 50 using the tailSet function of TreeSet.
 */
public class l_4_5 {

    public static void main(String[] args) {
        
        TreeSet<Integer> intSet = new TreeSet<Integer>();
        TreeSet<Integer> headSet = new TreeSet<Integer>();
        TreeSet<Integer> tailSet = new TreeSet<Integer>();
        Iterator<Integer> iterate1, iterate2;
        Random rand = new Random();

        for (int i = 0; i < 50; i++) {
            intSet.add(rand.nextInt(101));
        }

        headSet = (TreeSet<Integer>) intSet.headSet(50);
        iterate1 = headSet.iterator();

        tailSet = (TreeSet<Integer>) intSet.tailSet(50);
        iterate2 = tailSet.iterator();

        System.out.print("Head Set: ");
        while (iterate1.hasNext()) {
            System.out.print(iterate1.next() + " ");
        }

        System.out.print("\nTail Set: ");
        while (iterate2.hasNext()) {
            System.out.print(iterate2.next() + " ");
        }
    }
}