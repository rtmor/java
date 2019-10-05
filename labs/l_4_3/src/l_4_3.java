import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

/**
 * L.4.3: Complete L.3.4 (employee contact information) by creating an Employee
 * class. Each employee should be stored in its own file with the employee ID as
 * the filename. All data members should have appropriate getters and setters.
 * There should be an appropriate toString method to create a string of all
 * employee information suitable for printing. Create a main to thoroughly test
 * the functionality of your class.
 * 
 */

public class l_4_3 {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            getMenu();
        }

    }

    static void getMenu() {

        String idNumber;

        System.out.println("\nEmployee Contact Database");
        System.out.println("-------------------------");
        System.out.printf("Enter 'i' to insert" + 
                          "\nEnter 'u' to update existing" + 
                          "\nEnter 'd' to delete existing" + 
                          "\nEnter 'r' to read existing user" + "\n\n>>> ");

        char choice = input.next().charAt(0);

        switch (choice) {
        case 'i':
            System.out.print("\nEnter ID of User to Create: ");
            idNumber = input.next();
            insertUser(idNumber);
            break;
        case 'u':
            System.out.print("\nEnter ID Number to Update: ");
            idNumber = input.next();
            try {
                deleteUser(idNumber);
                insertUser(idNumber);
                break;
            } catch (Exception ex) {
                System.out.println("\nEmployee Not Found");
                break;
            }
        case 'd':
            System.out.print("\nEnter ID Number to Delete: ");
            idNumber = input.next();
            deleteUser(idNumber);
            break;
        case 'r':
            System.out.print("\nEnter ID Number to Read: ");
            idNumber = input.next();
            readUser(idNumber);
            break;
        default:
            System.out.println("\nInvalid Choice");
            break;
        }

    }

    private static void readUser(String idNumber) {

        String filename = idNumber;

        FileInputStream fis = null;
        ObjectInputStream in = null;

        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            Employee e = (Employee) in.readObject();
            System.out.println(e.toString());
        } catch (Exception ex) {
            System.out.println("Employee Not Found");
            ex.printStackTrace();

        }
    }

    private static void deleteUser(String idNumber) {

        File file = new File(idNumber);

        try {
            if (file.delete()) {
                System.out.println("\nUser Successfully Deleted");
            } else {
                System.out.println("\nEmployee Not Found");
            }
        } catch (Exception ex) {
            System.out.println("\nEmployee Not Found");
            ex.printStackTrace();
        }
    }

    private static void insertUser(String idNumber) {

        String id = idNumber;
        System.out.print("Please provide user firstname: ");
        String first = input.next();
        System.out.print("Please provide user lastname: ");
        String last = input.next();
        System.out.print("Please provide employee phone number: ");
        String phone = input.next();
        Employee e = new Employee(id, first, last, phone);
        e.write(e);
    }
}