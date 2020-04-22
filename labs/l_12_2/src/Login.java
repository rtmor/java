import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * L.12.2: Create a simple GUI program which allows a user to login and register
 * for a "system". The program should use a simple text file database that
 * stores usernames and the hash (algorithm is your choice) of the password. The
 * GUI should check to see that the hash of the password entered by the user
 * matches the hash of the password in your text file. A user can click register
 * instead in which case his username and hashed password will be added to the
 * database.
 */
public class Login implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -5297960677845729680L;
    private String username;
    private String password;
    private String path = System.getProperty("user.dir");
    private String outputDir = path + "/src/users/";

    /**
     * @param username
     * @param password
     */
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Login() {

    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     * @throws NoSuchAlgorithmException
     */
    public void setPassword(String password) throws NoSuchAlgorithmException {

        String cipher = getHash(password); 
        this.password = cipher;
    }

    private String getHash(String pass) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] bytesOfMessage = md.digest(pass.getBytes());
        BigInteger no = new BigInteger(1, bytesOfMessage); 
        String cipher = no.toString(16);

        while (cipher.length() < 32) { 
                cipher = "0" + cipher; 
            }
        return cipher;
    }

    public void write(Login u) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        String filename = getUsername();
        FileOutputStream fos = null;
        ObjectOutputStream out = null;

        try {
            fos = new FileOutputStream(outputDir + filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(u);
            System.out.println("\nObject Successfully Writen to File");
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean pwCheck(String pw) throws NoSuchAlgorithmException {

        System.out.println(String.format("PW: %s   PW-Store %s", getHash(pw), this.password));

        return getHash(pw).equals(this.password);

    }

}