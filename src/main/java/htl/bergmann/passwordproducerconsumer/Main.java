
package htl.bergmann.passwordproducerconsumer;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Password> passwords = new ArrayList<>();
        PasswordProducer passwordProducer = new PasswordProducer(passwords);
        PasswordConsumer passwordConsumer1 = new PasswordConsumer(passwords);
        PasswordConsumer passwordConsumer2 = new PasswordConsumer(passwords);
        PasswordConsumer passwordConsumer3 = new PasswordConsumer(passwords);
        PasswordConsumer passwordConsumer4 = new PasswordConsumer(passwords);
        
        new Thread(passwordConsumer1).start();
        new Thread(passwordConsumer2).start();
        new Thread(passwordConsumer3).start();
        new Thread(passwordConsumer4).start();
        new Thread(passwordProducer).start();
    }
}