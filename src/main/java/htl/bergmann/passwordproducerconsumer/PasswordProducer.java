package htl.bergmann.passwordproducerconsumer;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PasswordProducer {

    private static int maxPasswords = 5;
    private ArrayList<Password> passwords = new ArrayList<>();

    public PasswordProducer(ArrayList<Password> passwords) {
        this.passwords = passwords;
    }

    public void addPassword(String password) {
        synchronized (passwords) {
            passwords.add(new Password(password));
            passwords.notifyAll();
        }
    }
}
