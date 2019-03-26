package htl.bergmann.passwordproducerconsumer;

import java.awt.GridLayout;
import java.util.ArrayList;

public class PasswordGUI extends javax.swing.JFrame {

    private static int numConsumers = 5;
    private ArrayList<Password> passwords = new ArrayList<>();
    private PasswordProducer passwordProducer;

    public PasswordGUI() {
        initComponents();
        pnConsumers.setLayout(new GridLayout(numConsumers, 1));
        passwordProducer = new PasswordProducer(passwords);
        for (int i = 0; i < numConsumers; i++) {
            pnConsumers.add(new ConsumerGUI(passwords, this));
        }
    }

    public void updateQueue() {
        synchronized (passwords) {
            taQueue.setText("");
            for (Password p : passwords) {
                taQueue.append(p.getHash() + " -> Queued\n");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnProducer = new javax.swing.JPanel();
        lbPassword = new javax.swing.JLabel();
        tfPassword = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taQueue = new javax.swing.JTextArea();
        pnConsumers = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 800));

        pnProducer.setLayout(new java.awt.GridBagLayout());

        lbPassword.setText("Password:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 1.0;
        pnProducer.add(lbPassword, gridBagConstraints);

        tfPassword.setText("password123");
        tfPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPasswordActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        pnProducer.add(tfPassword, gridBagConstraints);

        taQueue.setColumns(20);
        taQueue.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        taQueue.setRows(5);
        jScrollPane1.setViewportView(taQueue);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 5.0;
        pnProducer.add(jScrollPane1, gridBagConstraints);

        getContentPane().add(pnProducer, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(pnConsumers, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPasswordActionPerformed
        String password = tfPassword.getText();
        if (password.isEmpty()) {
            return;
        }

        tfPassword.setText("");
        passwordProducer.addPassword(password);
        updateQueue();
    }//GEN-LAST:event_tfPasswordActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PasswordGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PasswordGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PasswordGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PasswordGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PasswordGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JPanel pnConsumers;
    private javax.swing.JPanel pnProducer;
    private javax.swing.JTextArea taQueue;
    private javax.swing.JTextField tfPassword;
    // End of variables declaration//GEN-END:variables

}
