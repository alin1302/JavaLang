package calculator;

import java.io.*;
import java.net.Socket;
import javax.swing.*;

/**
 *
 * @author Admin
 */
public class WelcomeUI extends javax.swing.JFrame {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public WelcomeUI() {
        try {
            initComponents();
            socket = new Socket("localhost", 12345);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Login = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        SignIn = new javax.swing.JButton();
        Password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Login");

        jLabel2.setText("Password");
        jLabel2.setToolTipText("");

        SignIn.setText("Sign in");
        SignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Login, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(Password)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(SignIn)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(SignIn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Login.getAccessibleContext().setAccessibleName("log");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignInActionPerformed

        String login = Login.getText();
        String pass = Password.getText();
        try {
            out.writeUTF(login);
            out.writeUTF(pass);
            if (in.readBoolean()) {
                new calculatorUI(login, socket).setVisible(true);
                System.out.println("Welcome");
            } else {
                JOptionPane.showMessageDialog(null, "Incorrectly! Please try again.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_SignInActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Login;
    private javax.swing.JPasswordField Password;
    private javax.swing.JButton SignIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
