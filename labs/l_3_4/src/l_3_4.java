import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * L.3.4: Write a program that stores employee contact information. Contact
 * information consists of employee ID (an integer), first name, last name, and
 * phone number. The program should store all information in a text file and
 * should allow you to insert, update, and delete employees.
 */
    

public class l_3_4 {

    private static Scanner input = new Scanner(System.in);
    private static Scanner input2 = new Scanner(System.in);

    public static void main(String[] args) {

        getMenu();
        //test
    }

    static void getMenu() {

        String idNumber;

        System.out.println("\nEmployee Contact Database");
        System.out.println("-------------------------");
        System.out.printf("Enter 'i' to insert"+
                          "\nEnter 'u' to update existing"+
                          "\nEnter 'd' to delete existing"+
                          "\nEnter 'r' to read existing user"+
                          "\n\n>>> ");

        char choice = input2.next().charAt(0);

        switch(choice) {
            case 'i':
                System.out.print("\nEnter ID of User to Create: ");
                idNumber = input2.next();
                insertUser(idNumber);
                break;
            case 'u':
                System.out.print("\nEnter ID Number to Update: ");
                idNumber = input2.next();
                deleteUser(idNumber);
                insertUser(idNumber);
                break;
            case 'd':
                System.out.print("\nEnter ID Number to Delete: ");
                idNumber = input2.next();
                deleteUser(idNumber);
                getMenu();
                break;
            case 'r':
                System.out.print("\nEnter ID Number to Read: ");
                idNumber = input2.next();
                readUser(idNumber);
                break;
            default:
                System.out.println("\nInvalid Choice");
                getMenu();
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
        getMenu();
    }

    private static void deleteUser(String idNumber) {

        File file = new File(idNumber);

        try {
            if(file.delete()){
                System.out.println("\nUser Successfully Deleted");
            } else {
                System.out.println("\nEmployee Not Found");
            }
        } catch(Exception ex) {
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
        write(e);
        getMenu();
        
    }

    private static void write(Employee e) {

        String filename = e.getIdNumber();

        FileOutputStream fos = null;
        ObjectOutputStream out = null;

        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(e);
            System.out.println("\nObject Successfully Writen to File");
            out.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}