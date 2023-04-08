/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.system.Model;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.PreparedStatement;

/**
 *
 * @author Md. Fahim Faisal
 */
public class AddBookModel {
    public boolean addBookRecord(JTextField title, JTextField isbn, JTextField author, JTextField shelfNo, JTextField quantity){
        try{
        connectDB connect = new connectDB();
        String sql = "insert into bookdetails(title, isbn, author, shelfNo, quantity) values(?, ?, ?, ?, ?)";
		PreparedStatement st = connect.conn.prepareStatement(sql);
                // st.setInt(1, Integer.parseInt(textField.getText()));
		st.setString(1, title.getText());
		st.setString(2, isbn.getText());
		st.setString(3, author.getText());
		st.setString(4, shelfNo.getText());
		st.setString(5, quantity.getText());

		int rs = st.executeUpdate();
                st.close();
		if (rs > 0){
                    return true;
                }
                else{
                    st.close();
                    connect.conn.close();
                    return false;
                }
                
        }catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Invalid data");
        }
        return false;
    }
}
