/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.system.View;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;
//import library.management.system.Controller.LoginController;
//import library.management.system.Model.LoginModel;
//import library.management.system.connectDB;
//import library.management.system.Controller.loginController;

/**
 *
 * @author Md. Fahim Faisal
 */
public class Register extends JFrame{

    private JPanel contentPane;
    private JTextField username;
    private JTextField name;
    private JTextField pass;
    private JTextField textField_3;
    private JButton b1, b2;
    private JComboBox comboBox;


    public static void main(String[] args) {
        new Register().setVisible(true);
    }
    public void addCreateListener(ActionListener act){
        b1.addActionListener(act);
    }
    public void addBackListener(ActionListener act){
        b2.addActionListener(act);
    }
    public JButton getButton(int bNum){
        if(bNum==1){
            return b1;
        }else{
            return b2;
        }
    }
    public JTextField getTextField(int fieldNum){
            if(fieldNum == 1){
                return this.name;
            }else if(fieldNum == 2){
                return this.username;
            }else{
                return this.pass;
            }
        }
    public Register() {
        setBounds(600, 250, 606, 406);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
	contentPane.setLayout(null);

	JLabel lblUsername = new JLabel("Name :");
	lblUsername.setForeground(Color.DARK_GRAY);
	lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblUsername.setBounds(99, 86, 92, 26);
	contentPane.add(lblUsername);

	JLabel lblName = new JLabel("Username :");
	lblName.setForeground(Color.DARK_GRAY);
	lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblName.setBounds(99, 123, 92, 26);
	contentPane.add(lblName);

	JLabel lblPassword = new JLabel("Password :");
	lblPassword.setForeground(Color.DARK_GRAY);
	lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblPassword.setBounds(99, 160, 92, 26);
	contentPane.add(lblPassword);

	

        name = new JTextField();
	name.setBounds(265, 91, 148, 20);
	contentPane.add(name);
	name.setColumns(10);

	username = new JTextField();
	username.setColumns(10);
	username.setBounds(265, 128, 148, 20);
	contentPane.add(username);

        pass = new JPasswordField();
	pass.setColumns(10);
	pass.setBounds(265, 165, 148, 20);
	contentPane.add(pass);

	

	b1 = new JButton("Create");

	b1.setFont(new Font("Tahoma", Font.BOLD, 13));
	b1.setBounds(140, 289, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Back");

	b2.setFont(new Font("Tahoma", Font.BOLD, 13));
	b2.setBounds(300, 289, 100, 30);
	b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);

	JPanel panel = new JPanel();
	panel.setForeground(new Color(34, 139, 34));
	panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Create-Account",
			TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
	panel.setBounds(31, 46, 476, 296);
        panel.setBackground(Color.WHITE);
	contentPane.add(panel);
    }
    
    
}

