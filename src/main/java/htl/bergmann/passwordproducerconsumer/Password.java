
package htl.bergmann.passwordproducerconsumer;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.digest.DigestUtils;

public class Password {
    private String password;

    public Password(String password) {
        this.password = DigestUtils.sha256Hex(password);
    }
    
    public boolean check(String password) {
        if(new Random().nextFloat() < 0.01) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Password.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.password.equals(DigestUtils.sha256Hex(password));
    }

    public String getPassword() {
        return password;
    }
    
    
}
