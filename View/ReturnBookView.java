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
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;
public class ReturnBookView extends JFrame {
    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t8,t9,t10;
    private JButton searchBook,searchStudent,returnBook,back;
    public static void main(String[] args) {
	new ReturnBookView().setVisible(true);
    }
    public void addButtonListener(ActionListener act){
            searchBook.addActionListener(act);
            searchStudent.addActionListener(act);
            returnBook.addActionListener(act);
            back.addActionListener(act);
    }
    public JButton getButton(int bNum){
        if(bNum==1){
            return searchBook;
        }else if(bNum==2){
            return searchStudent;
        }else if(bNum==3){
            return returnBook;
        }else{
            return back;
        }
    }
    public JTextField getTextField(int fieldNum){
        
            if(fieldNum == 1){
                return this.t1;
            }else if(fieldNum == 2){
                return this.t2;
            }
            else if(fieldNum == 3){
                return this.t3;
            }else if(fieldNum == 4){
                return this.t4;
            }else if(fieldNum == 8){
                return this.t8;
            }else if(fieldNum == 9){
                return this.t9;
            }else if(fieldNum == 10){
                return this.t10;
            }
            return null;
        }
    public ReturnBookView() {
        setBounds(300, 200, 900, 500);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
	contentPane.setLayout(null);

	JLabel l1 = new JLabel("Shelf No.");
	l1.setFont(new Font("Tahoma", Font.BOLD, 14));
	l1.setForeground(new Color(47, 79, 79));
	l1.setBounds(47, 63, 100, 23);
	contentPane.add(l1);

	JLabel l2 = new JLabel("Title");
	l2.setForeground(new Color(47, 79, 79));
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(47, 97, 100, 23);
	contentPane.add(l2);

	JLabel l3 = new JLabel("ISBN");
	l3.setForeground(new Color(47, 79, 79));
	l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	l3.setBounds(47, 131, 100, 23);
	contentPane.add(l3);

	JLabel l4 = new JLabel("Author");
	l4.setForeground(new Color(47, 79, 79));
	l4.setFont(new Font("Tahoma", Font.BOLD, 14));
	l4.setBounds(47, 165, 100, 23);
	contentPane.add(l4);

	t1 = new JTextField();
	t1.setForeground(new Color(47, 79, 79));
	t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t1.setBounds(126, 66, 86, 20);
	contentPane.add(t1);
	
	searchBook = new JButton("Search");
	searchBook.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
        searchBook.setBackground(Color.BLACK);
        searchBook.setForeground(Color.WHITE);
	searchBook.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	searchBook.setBounds(234, 59, 100, 30);
        
	contentPane.add(searchBook);

	t2 = new JTextField();
	t2.setEditable(false);
	t2.setForeground(new Color(47, 79, 79));
	t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t2.setBounds(126, 100, 208, 20);
	contentPane.add(t2);
	t2.setColumns(10);

	t3 = new JTextField();
	t3.setEditable(false);
	t3.setForeground(new Color(47, 79, 79));
	t3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t3.setColumns(10);
	t3.setBounds(126, 131, 208, 20);
	contentPane.add(t3);

	t4 = new JTextField();
	t4.setEditable(false);
	t4.setForeground(new Color(47, 79, 79));
	t4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t4.setColumns(10);
	t4.setBounds(126, 168, 208, 20);
	contentPane.add(t4);

	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(47, 79, 79), 2, true), "Issue-Book",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
	panel.setFont(new Font("Tahoma", Font.BOLD, 14));
	panel.setBounds(10, 38, 345, 288);
        panel.setBackground(Color.WHITE);
	contentPane.add(panel);

	JLabel l8 = new JLabel("LibCardNo.");
	l8.setForeground(new Color(47, 79, 79));
	l8.setFont(new Font("Tahoma", Font.BOLD, 14));
	l8.setBounds(384, 63, 100, 23);
	contentPane.add(l8);

	JLabel l9 = new JLabel("Name");
	l9.setForeground(new Color(47, 79, 79));
	l9.setFont(new Font("Tahoma", Font.BOLD, 14));
	l9.setBounds(384, 103, 100, 23);
	contentPane.add(l9);

	JLabel l10 = new JLabel("Username");
	l10.setForeground(new Color(47, 79, 79));
	l10.setFont(new Font("Tahoma", Font.BOLD, 14));
	l10.setBounds(384, 147, 100, 23);
	contentPane.add(l10);
        
	t8 = new JTextField();
	t8.setForeground(new Color(47, 79, 79));
	t8.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t8.setColumns(10);
	t8.setBounds(508, 66, 86, 20);
        contentPane.add(t8);

	searchStudent = new JButton("Search");

	searchStudent.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	searchStudent.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
	searchStudent.setBounds(604, 59, 100, 30);
        searchStudent.setBackground(Color.BLACK);
        searchStudent.setForeground(Color.WHITE);
	contentPane.add(searchStudent);

	t9 = new JTextField();
	t9.setForeground(new Color(47, 79, 79));
	t9.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t9.setEditable(false);
	t9.setColumns(10);
	t9.setBounds(508, 106, 208, 20);
	contentPane.add(t9);

	t10 = new JTextField();
	t10.setForeground(new Color(47, 79, 79));
	t10.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t10.setEditable(false);
	t10.setColumns(10);
	t10.setBounds(508, 150, 208, 20);
	contentPane.add(t10);

	JPanel panel_1 = new JPanel();
	panel_1.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180), 2, true), "Student-Deatails",
			TitledBorder.LEADING, TitledBorder.TOP, null, new Color(100, 149, 237)));
	panel_1.setForeground(new Color(0, 100, 0));
	panel_1.setBounds(360, 38, 378, 372);
        panel_1.setBackground(Color.WHITE);
	contentPane.add(panel_1);
        


	returnBook = new JButton("Return");
	//returnBook.addActionListener(this);
	returnBook.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	returnBook.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
	returnBook.setBounds(47, 377, 118, 33);
	returnBook.setBackground(Color.BLACK);
        returnBook.setForeground(Color.WHITE);
        contentPane.add(returnBook);

	back = new JButton("Back");
	//back.addActionListener(this);
	back.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	back.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
	back.setBounds(199, 377, 100, 33);
	back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        contentPane.add(back);
    }
}
