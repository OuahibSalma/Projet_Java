/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Bank;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.Color;
import java.awt.event.*;


/**
 *
 * @author Original Shop
 */
public class AuthFrame extends javax.swing.JFrame {
    private JPanel contentPane;
    private JTextField loginTextField;
    private JPasswordField passwordField;
    private JLabel statusLabel ; 
    /**
     * Creates new form AuthFrame
     */
    public AuthFrame() {
        initComponents();
    }
    /**
    * Create the frame.
    * @param bank
    */
    public AuthFrame(Bank bank) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 346, 270);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);	
        JPanel authPanel = new JPanel();
        authPanel.setBorder(new TitledBorder(null, "Authentification", TitledBorder.LEFT, TitledBorder.TOP, null, null));
        authPanel.setBounds(5, 5, 302, 164);
        contentPane.add(authPanel);
        authPanel.setLayout(null);	
        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setBounds(27, 26, 46, 14);
        authPanel.add(lblNewLabel);		
        loginTextField = new JTextField();
        loginTextField.setBounds(124, 26, 157, 20);
        authPanel.add(loginTextField);
        loginTextField.setColumns(10);	
        passwordField = new JPasswordField();
        passwordField.setBounds(124, 64, 157, 20);
        authPanel.add(passwordField);	
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(27, 64, 87, 14);
        authPanel.add(lblPassword);	
        JButton btnNewButton = new JButton("OK");
        btnNewButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String login = loginTextField.getText();
            String password = new String(passwordField.getPassword());
            if 	(login.equals("a") && password.equals("")) {
                System.out.println("Admin authentication successful. Access granted.\n");
                statusLabel.setText("Admin authentication successful. Access granted.\n");
                var adminFrame = new AdminFrame(bank);
                adminFrame.setVisible(true);
            }
            else if 	(login.equals("c") && password.equals("")) {
                System.out.println("Customer authentication successful. Access granted.\n");
                statusLabel.setText("Customer authentication successful. Access granted.\n");
                var customerFrame = new CustomerFrame(bank);
                customerFrame.setVisible(true);
            }
            else {
                System.out.println("Authentication failed. Access denied.");
                System.out.println("Hacker alert. ");
                System.exit(0);			
            }
            //loginTextField.setText("");
            //passwordField.setText("");
            }
            });
            btnNewButton.setBounds(124, 109, 59, 23);
            authPanel.add(btnNewButton);	
            JButton btnCancel = new JButton("Cancel");
            btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginTextField.setText("");
                passwordField.setText("");
                statusLabel.setText("");
            }
        });
        btnCancel.setBounds(210, 109, 77, 23);
        authPanel.add(btnCancel);	
	JPanel statusPanel = new JPanel();
	statusPanel.setLayout(null);
        statusPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Status", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
        statusPanel.setBounds(5, 180, 302, 41);
        contentPane.add(statusPanel);	
        statusLabel = new JLabel("");
        statusLabel.setBounds(10, 11, 292, 19);
        statusPanel.add(statusLabel);
	}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
