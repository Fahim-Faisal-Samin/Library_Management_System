/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.system.View;

/**
 *
 * @author Md. Fahim Faisal
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddBookView extends JFrame{
    private JPanel contentPane;
    private JTextField shelfNo,title,isbn,author,quantity;
    private JButton b1,b2;
    public static void main(String[] args) {
	new AddBookView().setVisible(true);
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
                return this.shelfNo;
            }else if(fieldNum == 2){
                return this.title;
            }else if(fieldNum == 3){
                return this.isbn;
            }else if(fieldNum == 4){
                return this.author;
            }else{
                return this.quantity;
            }
        }
    public void random() {
        Random rd = new Random();
	shelfNo.setText((char)(rd.nextInt(26) + 'a')+""+ rd.nextInt(1000 + 1));
    }
    public void addButtonListener(ActionListener act){
            b1.addActionListener(act);
            b2.addActionListener(act);
        }
     public AddBookView() {
        setBounds(600, 200, 518, 442);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JLabel l1 = new JLabel("Title");
	l1.setForeground(new Color(47, 79, 79));
	l1.setFont(new Font("Tahoma", Font.BOLD, 14));
	l1.setBounds(73, 84, 90, 22);
	contentPane.add(l1);

	JLabel l2 = new JLabel("ISBN");
	l2.setForeground(new Color(47, 79, 79));
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(73, 117, 90, 22);
	contentPane.add(l2);

	JLabel l3 = new JLabel("Author");
	l3.setForeground(new Color(47, 79, 79));
	l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	l3.setBounds(73, 150, 90, 22);
	contentPane.add(l3);

	JLabel l6 = new JLabel("Shelf No.");
	l6.setForeground(new Color(47, 79, 79));
	l6.setFont(new Font("Tahoma", Font.BOLD, 14));
	l6.setBounds(73, 51, 90, 22);
	contentPane.add(l6);

	JLabel l4 = new JLabel("Quantity");
	l4.setForeground(new Color(47, 79, 79));
	l4.setFont(new Font("Tahoma", Font.BOLD, 14));
	l4.setBounds(73, 183, 90, 22);
	contentPane.add(l4);

	shelfNo = new JTextField();
	shelfNo.setForeground(new Color(47, 79, 79));
	shelfNo.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	shelfNo.setBounds(169, 54, 198, 20);
	contentPane.add(shelfNo);
	shelfNo.setColumns(10);

	title = new JTextField();
	title.setForeground(new Color(47, 79, 79));
	title.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	title.setColumns(10);
	title.setBounds(169, 87, 198, 20);
	contentPane.add(title);

	isbn = new JTextField();
	isbn.setForeground(new Color(47, 79, 79));
	isbn.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	isbn.setColumns(10);
	isbn.setBounds(169, 120, 198, 20);
	contentPane.add(isbn);

	author = new JTextField();
	author.setForeground(new Color(47, 79, 79));
	author.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	author.setColumns(10);
	author.setBounds(169, 153, 198, 20);
	contentPane.add(author);

        quantity = new JTextField();
	quantity.setForeground(new Color(47, 79, 79));
	quantity.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	quantity.setColumns(10);
	quantity.setBounds(173, 186, 194, 20);
	contentPane.add(quantity);


	/*comboBox = new JComboBox();
	comboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
	comboBox.setBounds(173, 186, 194, 20);
	contentPane.add(comboBox); */

        b1 = new JButton("Add");
	//b1.addActionListener(this);
	b1.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	b1.setBounds(102, 300, 100, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Back");
	//b2.addActionListener(this);
	b2.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), null));
	b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	b2.setBounds(212, 300, 108, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	
	contentPane.add(b2);

	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(138, 43, 226), 2), "Add Books", TitledBorder.LEADING,
			TitledBorder.TOP, null, new Color(0, 0, 255)));
	panel.setBounds(10, 29, 398, 344);
	contentPane.add(panel);
        
        panel.setBackground(Color.WHITE);
        contentPane.setBackground(Color.WHITE);
	random();

    }
}
