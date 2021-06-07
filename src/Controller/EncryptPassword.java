package Controller;
import org.apache.commons.codec.binary.Base64;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

public class EncryptPassword {
    String Key = "LlaveEncriptada";
    public EncryptPassword() {
        //Encrypted(key);
        //Decrypted(key);
    }
    public SecretKeySpec CreateKey(String key) {
        try{
            byte[] _string = key.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            _string = md.digest(_string);
            _string = Arrays.copyOf(_string, 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(_string, "AES");
            return secretKeySpec;
        }catch (Exception e) {
            return null;
        }
    }
    // Encriptar
    public String Encrypted(String encrypt) {     
        try {
            SecretKeySpec secretKeySpec = CreateKey(Key);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            
            byte [] _string = encrypt.getBytes("UTF-8");
            byte [] encrypted = cipher.doFinal(_string);
            String encryptedString = Base64.encodeBase64String(encrypted);
            //byte[] encryptedString = Base64.getEncoder().encode(encrypted);
            return encryptedString;
        } catch (Exception e) {
            return "";
        }
    }

    // Des-encriptación
     public String Decrypted(String encrypted) {
        try {
            SecretKeySpec secretKeySpec = CreateKey(Key);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            
            byte [] _string = Base64.decodeBase64(encrypted);            
            byte [] decrypted = cipher.doFinal(_string);
            String decryptedString = new String(decrypted);
            return decryptedString;
        } catch (Exception e) {
            return "";
        }
    }
}
