import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.ResourceBundle;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * AES-Crypt
 */
public class AES_Crypt extends Application {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField keyField;

    @FXML
    private TextField messageField;

    @FXML
    private RadioButton aes;

    @FXML
    private ToggleGroup cipherRadio;

    @FXML
    private TextArea outputField;

    @FXML
    private RadioButton des;

    public static SecretKeySpec secretKey;
    public static byte[] key;
    public static String cipherPadding;
    public static String keySpec;
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    private static final String UNICODE_FORMAT = "UTF8";
    static byte[] arrayBytes;

    @Override
    public void init() throws Exception {

    }

    @FXML
    void getDecrypt(ActionEvent event)
            throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException {
        outputField.setText("");
        String key = keyField.getText();
        String message = messageField.getText();
        RadioButton selectedRadioButton = (RadioButton) cipherRadio.getSelectedToggle();
        String cipher = selectedRadioButton.getText();
        System.out.println(cipher);
        String clearText = decrypt(key, message, cipher);
        outputField.setText(clearText);
    }

    @FXML
    void getEncrypt(ActionEvent event) throws NoSuchPaddingException {
        outputField.setText("");
        String key = keyField.getText();
        String message = messageField.getText();
        RadioButton selectedRadioButton = (RadioButton) cipherRadio.getSelectedToggle();
        String cipher = selectedRadioButton.getText();
        System.out.println(cipher);
        String clearText = encrypt(key, message, cipher);
        outputField.setText(clearText);
    }

    public static void setKey(String myKey) {

        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, keySpec);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private static void setCipher(String cipherType) {
        switch (cipherType) {
        case "AES": {
            keySpec = "AES";
            cipherPadding = "AES/ECB/PKCS5Padding";
            break;
        }
        case "3DES": {
            keySpec = "DESede";
            cipherPadding = "DESede/CBC/NoPadding";

            break;
        }
        }
    }

    public static String encrypt(String strToEncrypt, String secret, String cipherType) throws NoSuchPaddingException {
        setCipher(cipherType);
        switch (cipherType) {
        case "AES": {
            try {
                setKey(secret);
                Cipher cipher = Cipher.getInstance(cipherPadding);
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
                return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
            } catch (Exception e) {
                System.out.println("Error while encrypting: " + e.toString());
            }
            return null;
        }
        case "3DES": {
            String encryptedString = null;
            try {
                arrayBytes = secret.getBytes(UNICODE_FORMAT);
                KeySpec ks = new DESedeKeySpec(arrayBytes);
                SecretKeyFactory skf = SecretKeyFactory.getInstance("DESede");
                Cipher cipher = Cipher.getInstance("DESede");
                SecretKey key = skf.generateSecret(ks);
                cipher.init(Cipher.ENCRYPT_MODE, key);
                byte[] plainText = strToEncrypt.getBytes(UNICODE_FORMAT);
                byte[] encryptedText = cipher.doFinal(plainText);
                return Base64.getEncoder().encodeToString(encryptedText);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return encryptedString;
        }
        }
        return null;
    }

    public static String decrypt(String strToDecrypt, String secret, String cipherType)
            throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException {
        setCipher(cipherType);
        switch (cipherType) {
        case "AES": {
            try {
                setKey(secret);
                Cipher cipher = Cipher.getInstance(cipherPadding);
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
                return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
            } catch (Exception e) {
                System.out.println("Error while decrypting: " + e.toString());
            }
            break;
        }
        case "3DES": {
            arrayBytes = secret.getBytes(UNICODE_FORMAT);
            KeySpec ks = new DESedeKeySpec(arrayBytes);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            SecretKey key = skf.generateSecret(ks);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] encryptedText = Base64.getDecoder().decode(strToDecrypt);
            byte[] plainText = cipher.doFinal(encryptedText);
            return new String(plainText);
        }
        }
        return null;
    }

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("AES_Crypt.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cipher Crypt");
        primaryStage.show();
        primaryStage.sizeToScene();
    }

    public static void main(String[] args) {
        launch(args);
    }

}