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
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.*;
import library.management.system.Model.BookDetailsModel;
public class BookDetailsView extends JFrame {
    private JPanel contentPane;
    public static BookDetailsModel bkModel;
    private static JTable table;
    private JTextField search;
    private JButton b1,b2,b3;
    public static void main(String[] args) {
	new BookDetailsView().setVisible(true);
    }
    public BookDetailsView(){

    }
    public BookDetailsView(BookDetailsModel bkModel) {
        setBounds(350, 200, 890, 475);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
        this.table=table;
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(79, 133, 771, 282);
	contentPane.add(scrollPane);
        
        
        table = new JTable();
	table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int row = table.getSelectedRow();
		search.setText(table.getModel().getValueAt(row, 1).toString());
            }
	});
	table.setBackground(new Color(240, 248, 255));
	table.setForeground(Color.DARK_GRAY);
	table.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
	scrollPane.setViewportView(table);
        JLabel l1 = new JLabel("Book Details");
	l1.setForeground(new Color(107, 142, 35));
	l1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
	l1.setBounds(300, 15, 400, 47);
	contentPane.add(l1);
        JLabel l3 = new JLabel("Back");
	l3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
	l3.setForeground(Color.GRAY);
	l3.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
	ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/View/icons/back-arrow-10.png"));
        Image i8 = i7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        l3.setIcon(i9);
	l3.setBounds(97, 89, 72, 33);
	contentPane.add(l3);

	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 128), 3, true), "Book-Details",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
	panel.setBounds(67, 54, 793, 368);
	contentPane.add(panel);
        panel.setBackground(Color.WHITE);
        try{
            ResultSet rs = null;
            rs = bkModel.Book(rs);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
