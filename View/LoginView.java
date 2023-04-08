package library.management.system.View;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.text.JTextComponent;

public class LoginView extends JFrame /*implements ActionListener*/{

	private JPanel panel;
	private JTextField textField;
	private JPasswordField passwordField;
        private JButton b1,b2/*,b3*/;
        
        public JButton getButton(int bNum){
            if(bNum == 1){
                return this.b1;
            }else if(bNum == 2){
                return this.b2;
            }
            else{
                return null;
            }
        }
        public JTextField getTextField(int fieldNum){
            if(fieldNum == 1){
                return this.textField;
            }else{
                return this.passwordField;
            }
        }
        public void addLoginListener(ActionListener act){
            b1.addActionListener(act);
        }
        
        public void addSignUpListener(ActionListener act){
            b2.addActionListener(act);
        }
        
	public LoginView() {
            
	setBackground(new Color(169, 169, 169));	
        setBounds(600, 300, 600, 400);
		
        panel = new JPanel();
	panel.setBackground(new Color(8, 166, 116));
	setContentPane(panel);
	panel.setLayout(null);
        
	JLabel l1 = new JLabel("Username : ");
	l1.setBounds(124, 89, 95, 24);
	panel.add(l1);

	JLabel l2 = new JLabel("Password : ");
	l2.setBounds(124, 124, 95, 24);
	panel.add(l2);

	textField = new JTextField();
	textField.setBounds(210, 93, 157, 20);
	panel.add(textField);
	
	passwordField = new JPasswordField();
	passwordField.setBounds(210, 128, 157, 20);
	panel.add(passwordField);

	JLabel l3 = new JLabel("");
	l3.setBounds(377, 79, 46, 34);
	panel.add(l3);

	JLabel l4 = new JLabel("");
	l4.setBounds(377, 124, 46, 34);
	panel.add(l3);
 
	b1 = new JButton("Login");

                
	b1.setForeground(new Color(46, 139, 87));
;
	b1.setBounds(149, 181, 113, 39);
	panel.add(b1);
		
        b2 = new JButton("Sign Up");

	
	b2.setForeground(new Color(139, 69, 19));
	b2.setBackground(new Color(255, 235, 205));
	b2.setBounds(289, 181, 113, 39);
	panel.add(b2);

	}
        

    

}
