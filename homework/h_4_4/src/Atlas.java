import java.util.*;


/**
 * H.4.4: Using the example from class as a start, write a program that allows
 * the user to edit an atlas of states and cities. The user should be able to
 * insert and delete states as well as insert and delete cities belonging to a
 * specific state from the atlas.
 */

public class Atlas {

    /**
     * @param args
     */
    private TreeMap<String, TreeSet<String>> atlas = new TreeMap<String, TreeSet<String>>();
    private Scanner input = new Scanner(System.in);


    public  void getMenu() {

        char choice;
        String state;

        System.out.println();
        System.out.println(this.atlas);
        System.out.println("\nWorld Atlas");
        System.out.println("-----------");
        System.out.println("Insert State (s)");
        System.out.println("Insert City to State (c)");
        System.out.println("Delete State (D)");
        System.out.println("Delete City of State (d)");
        System.out.print(">> ");

        choice = input.next().charAt(0);
        input.nextLine();

        switch (choice) {
        case 's':
            System.out.print("Enter Name of State to Add: ");
            addState(input.nextLine());
            break;
        case 'c':
            System.out.print("Enter State of City You Wish to Add: ");
            state = input.nextLine();
            System.out.print("Enter the City you Wish to Add: ");
            addCity(state, input.nextLine());
            break;
        case 'D':
            System.out.print("Enter Name of State to Remove: ");
            rmState(input.nextLine());
            break;
        case 'd':
            System.out.print("Enter State of City You Wish to Remove: ");
            state = input.nextLine();
            System.out.print("Enter Name of City to Remove: ");
            rmCity(state, input.nextLine());
            break;
        }
    }

    private void rmCity(String state, String city) {
        
        if (atlas.get(state).contains(city)) {
            atlas.get(state).remove(city);

        }
    }

    private void rmState(String state) {

        if (atlas.containsKey(state)) {
            atlas.remove(state);
        } else {
            System.out.println("The Given State Does Not Exist");
        }
    }

    private void addCity(String cityState, String city) {

        if (atlas.containsKey(cityState)) {
            atlas.get(cityState).add(city);
        } else {
            System.out.print("\nThat State does not exist" + 
                             "\nWould you like to add it (y/n): ");
            char choice = input.next().charAt(0);
            input.nextLine();

            switch (choice) {
            case 'y':
                addState(cityState);
                addCity(cityState, city);
                break;
            default:
                break;
            }
        }

    }

    private void addState(String state) {

        atlas.put(state, new TreeSet<String>());

    }

    /**
     * @param atlas
     * @param input
     */
    public Atlas() {
        
    }
}