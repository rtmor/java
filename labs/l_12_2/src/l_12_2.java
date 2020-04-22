import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * l_12_2
 */
public class l_12_2 extends Application {

    @FXML
    private TextField usernameInp;

    @FXML
    private TextField passwordInp;

    @FXML
    private Label noticeLabel;

    private String path = System.getProperty("user.dir");
    private String outputDir = path + "/src/users/";

    @Override
    public void init() throws Exception {

    }

    private Login queryUser(String user) {

        String filename = user;

        FileInputStream fis = null;
        ObjectInputStream in = null;

        try {
            fis = new FileInputStream(outputDir + filename);
            in = new ObjectInputStream(fis);
            Login u = (Login) in.readObject();
            in.close();
            return u;
        } catch (Exception ex) {
            noticeLabel.setText("Username or password invalid");
        }
        return null;
    }

    @FXML
    void login(ActionEvent event) throws NoSuchAlgorithmException {

        String username = usernameInp.getText();
        String password = passwordInp.getText();

        noticeLabel.setText("");

        Login user = queryUser(username);

        try {
        if (user.pwCheck(password)) {
            noticeLabel.setText("User Authenticated");
        } else {
            noticeLabel.setText("Username or password invalid");
        }
        } catch (NullPointerException np) {
        noticeLabel.setText("Username or password invalid");
    }

    }

    @FXML
    void register(ActionEvent event) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        String username = usernameInp.getText();
        String password = passwordInp.getText();

        noticeLabel.setText("");

        if (!username.isEmpty() && !password.isEmpty()) {

            Login q = new Login();
            q.setUsername(username);
            q.setPassword(password);
            q.write(q);

        } else {
            noticeLabel.setText("Please provide a valid username and password");
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("l_12_2.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Boring App Login");
        primaryStage.show();
        primaryStage.sizeToScene();
    }

    public static void main(String[] args) {
        launch(args);
    }

}