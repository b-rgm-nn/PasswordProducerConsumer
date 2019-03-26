package htl.bergmann.passwordproducerconsumer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PasswordConsumer implements Runnable {

    private ArrayList<Password> passwords = new ArrayList<>();
    private ArrayList<String> passwordList = new ArrayList<>();

    public PasswordConsumer(ArrayList<Password> passwords) {
        this.passwords = passwords;
        loadPasswords();
    }
    
    public void loadPasswords() {
        try(BufferedReader br = new BufferedReader(new FileReader(new File("passwords.txt")))) {
            String line = "";
            while((line = br.readLine()) != null) {
                passwordList.add(line);
            }
        } catch(Exception e) {
            
        }
    }
    
    @Override
    public void run() {
        while(true) {
            synchronized(passwords) {
                if(passwords.size() > 0) {
                    Password password = passwords.remove(0); 
                    boolean cracked = false;
                    for (String string : passwordList) {
                        if(password.check(string)) {
                            System.out.println("The Password has been cracked: " + string);
                            cracked = true;
                            break;
                        }
                    }
                    if(!cracked) {
                        System.out.println("The password has not been cracked");
                    }
                } else {
                    try {
                        passwords.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PasswordConsumer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

}
