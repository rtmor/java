import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Employee implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String idNumber;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String smallImage = "./image/duck.png";

    public Employee(String idNumber, String firstName, String lastName, String phoneNumber) {

        this.idNumber = idNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
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

    public void write(Employee e) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] bytesOfMessage = md.digest(this.getIdNumber().getBytes());
        BigInteger no = new BigInteger(1, bytesOfMessage); 
        String filename = no.toString(16);

        while (filename.length() < 32) { 
                filename = "0" + filename; 
            } 

        FileOutputStream fos = null;
        ObjectOutputStream out = null;

        try {
            fos = new FileOutputStream("C:/Users/rtmor/java/homework/h_7_1/src/employees/" + filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(e);
            System.out.println("\nObject Successfully Writen to File");
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String toString() {
        try {
            return "\nEmployee: [ID=" + idNumber + ", First Name=" + firstName + ", Last Name=" + lastName
                    + ", Phone Number=" + phoneNumber + "]";
        } catch (Exception e) {
            return "\nEmployee Not Found";
        }
    }

    public String getLargeImage() {
        return smallImage;
    }

    public String getThumbImage() {
        // TODO Auto-generated method stub
        return smallImage;
    }
}
