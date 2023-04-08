/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.system.Model;

/**
 *
 * @author Md. Fahim Faisal
 */
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class ReturnBookModel {
    public ResultSet getBookRecord(PreparedStatement st, String shelfNo){
        try{
            connectDB connect = new connectDB();
            String sql = "select * from bookdetails where shelfNo = ?";
            st = connect.conn.prepareStatement(sql);
            st.setString(1, shelfNo);
            ResultSet rs = st.executeQuery();
            return rs;
             }catch (Exception e) {
                 System.out.println(e);
                 return null;
            }
    }
    public ResultSet getStudentRecord(String libCardNo){
        try{
            connectDB connect = new connectDB();
            String sql = "select * from account where libCardNo = ?";
            PreparedStatement st = connect.conn.prepareStatement(sql);
            st.setString(1, libCardNo);
            ResultSet rs = st.executeQuery();
            return rs;
             }catch (Exception e) {
                 System.out.println(e);
                 return null;
            }
    }
    public void returnTheBook(JTextField shelfNo, JTextField stLibID, JTextField bookTitle, JTextField stdName){
        try{
            connectDB connect = new connectDB();
            String sql = "delete from issuedBooks where shelfNo= ? and stLibID= ?";
            PreparedStatement st = connect.conn.prepareStatement(sql);
            st.setString(1, shelfNo.getText());
            st.setString(2, stLibID.getText());
            int rs = st.executeUpdate();
            if (rs > 0)
                    JOptionPane.showMessageDialog(null, "Successfully Returned Book..!");
		else
                    JOptionPane.showMessageDialog(null, "error");
            sql = "select quantity from bookdetails where shelfNo=?";
            st = connect.conn.prepareStatement(sql);
            st.setString(1, shelfNo.getText());
            ResultSet rs2 = st.executeQuery();
            int updateQuantity = 0;
            while(rs2.next()){
                updateQuantity = Integer.parseInt(rs2.getString("quantity")) + 1;
            }
            
            sql = "update bookdetails set quantity=? where shelfNo=?";
            st = connect.conn.prepareStatement(sql);
            st.setString(1, ""+updateQuantity);
            st.setString(2, shelfNo.getText());
            st.executeUpdate();
            st.close();
            rs2.close();
            connect.conn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Invalid data");
        }
    }
}
