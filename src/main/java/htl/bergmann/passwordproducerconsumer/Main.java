
package htl.bergmann.passwordproducerconsumer;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Password> passwords = new ArrayList<>();
        PasswordProducer passwordProducer = new PasswordProducer(passwords);
        PasswordConsumer passwordConsumer = new PasswordConsumer(passwords);
        
        new Thread(passwordConsumer).start();
        new Thread(passwordProducer).start();
    }
}
hi