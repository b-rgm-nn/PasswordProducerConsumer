
package htl.bergmann.passwordproducerconsumer;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PasswordProducer implements Runnable {

    private static int maxPasswords = 5;
    private ArrayList<Password> passwords = new ArrayList<>();

    public PasswordProducer(ArrayList<Password> passwords) {
        this.passwords = passwords;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String str = JOptionPane.showInputDialog("Wähle ein Passwort");// sc.nextLine();
            if(str == null) {
                break;
            }
            synchronized(passwords) {
                if(passwords.size() < maxPasswords){
                    passwords.add(new Password(str));
                    System.out.println("pushing " + str);
                    passwords.notifyAll();
                } else {
                    try {
                        System.out.println("password list full");
                        passwords.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PasswordProducer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
    
    
}

