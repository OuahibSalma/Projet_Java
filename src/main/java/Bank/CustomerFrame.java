/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Bank;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Original Shop
 */
public class CustomerFrame extends javax.swing.JFrame {

    /**
     * Creates new form CustomerFrame
     */
    public CustomerFrame() {
        initComponents();
    }
    String newAccountType ;
	private JPanel contentPane;
	private JTextField numberTextField;
	private JTextField amountTextField;
	private JTextArea detailsArea ;
	private JPanel PanelInterne ; 


	/**
	 * Create the frame.
	 */
	public CustomerFrame(Bank bank) {
		bank.setName(bank.getName());

		detailsArea = new JTextArea();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel newPanel = new JPanel();
		newPanel.setBorder(new TitledBorder(null, "Account", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		newPanel.setBounds(10, 43, 277, 277);
		contentPane.add(newPanel);
		newPanel.setLayout(null);
		
		numberTextField = new JTextField();
		numberTextField.setBounds(150, 27, 81, 20);
		newPanel.add(numberTextField);
		numberTextField.setColumns(10);

		JLabel numberLabel = new JLabel("Enter your account No");
		numberLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		numberLabel.setBounds(10, 27, 120, 20);
		numberLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		newPanel.add(numberLabel);

		JButton details = new JButton("Details");
		details.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		details.setBounds(150, 60, 100, 20);
		newPanel.add(details);
		details.addActionListener((evt) -> {
			numberTextField.requestFocus();
			String nb = numberTextField.getText();
			refresh(bank.lookFor(nb),detailsArea);
		});
		
		JPanel PanelInterne = new JPanel();
		PanelInterne.setBorder(new TitledBorder(null, "Make an operation : ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		PanelInterne.setBounds(10, 90, 250, 140);
		newPanel.add(PanelInterne);
		PanelInterne.setLayout(null);

		JLabel amountLabel = new JLabel("Enter an amount please");
		amountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		amountLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		amountLabel.setBounds(5, 20, 163, 23);
		PanelInterne.add(amountLabel);
		
		amountTextField = new JTextField();
		amountTextField.setColumns(10);
		amountTextField.setBounds(5, 50, 91, 20);
		PanelInterne.add(amountTextField);
		
		
		JLabel selectop = new JLabel("Select an operation please");
		selectop.setHorizontalAlignment(SwingConstants.RIGHT);
		selectop.setFont(new Font("Tahoma", Font.PLAIN, 11));
		selectop.setBounds(40, 78, 100, 22);
		PanelInterne.add(selectop);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] {"Withdraw", "Deposit","Transfer"})
				);
		comboBox.setBounds(120, 78, 81, 22);
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				newAccountType = (String) comboBox.getSelectedItem();			
			}
			
		});
		PanelInterne.add(comboBox);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener((e)->this.setVisible(false));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExit.setBounds(155, 242, 78, 23);
		newPanel.add(btnExit);
		
		
		JLabel banknumberLabel = new JLabel(bank.getName()+" (Customer)");

		banknumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		banknumberLabel.setBounds(173, 11, 396, 31);
		banknumberLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(banknumberLabel);
		
		JPanel statementPanel = new JPanel();
		statementPanel.setLayout(null);
		statementPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Statement", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		statementPanel.setBounds(300, 43, 498, 277);
		contentPane.add(statementPanel);
		
		detailsArea.setFont(new Font("Verdana", Font.PLAIN, 12));
		detailsArea.setBounds(10, 23, 478, 243);
		statementPanel.add(detailsArea);
	}
/**
 * 
 * @param accounts
 * @param textArea
 */
	private void refresh(Account account, JTextArea textArea) {
		detailsArea.setText("");
		account.getOperations().forEach((operation) -> {
			detailsArea.append(operation+"\n");
		});
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
