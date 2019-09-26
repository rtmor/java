import java.io.Serializable;

public class Employee implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String idNumber;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    transient private Thread myThread;

    public Employee(String idNumber, String firstName, String lastName, String phoneNumber) {

        this.idNumber = idNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.myThread = new Thread();
    }

    public Employee() {
	}

	public String getIdNumber() {
        return idNumber;
    }
    
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override 
    public String toString() {
        try {
        return "\nEmployee: [ID=" + idNumber + ", First Name=" + firstName
              + ", Last Name=" + lastName + ", Phone Number=" + phoneNumber
              + "]";
        } catch(Exception e) {
            return "\nEmployee Not Found";
        }
    }
}
