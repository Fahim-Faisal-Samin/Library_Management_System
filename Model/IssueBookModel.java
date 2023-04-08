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
import com.toedter.calendar.JDateChooser;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class IssueBookModel {
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
    public void issueTheBook(JTextField shelfNo, JTextField stLibID, JTextField bookTitle, JTextField stdName, JDateChooser issueDate){
        try{
            connectDB connect = new connectDB();
            String sql = "insert into issuedBooks(shelfNo, stLibID, bookTitle, stdName, Issue_date) values(?, ?, ?, ?, ?)";
            PreparedStatement st = connect.conn.prepareStatement(sql);
            st.setString(1, shelfNo.getText());
            st.setString(2, stLibID.getText());
            st.setString(3, bookTitle.getText());
            st.setString(4, stdName.getText());
            java.util.Date d = issueDate.getDate();
            java.sql.Date sqldate = null;
            if (d == null) {
                System.out.println("No date specified!");
            } else {
                sqldate = new java.sql.Date(d.getTime());
            }
            st.setString(5, sqldate.toString());
            int rs = st.executeUpdate();
            if (rs > 0)
                    JOptionPane.showMessageDialog(null, "Successfully Book Issued..!");
		else
                    JOptionPane.showMessageDialog(null, "error");
            
            
            sql = "select Issue_date from issuedBooks where shelfNo= ?";
            st = connect.conn.prepareStatement(sql);
            st.setString(1, shelfNo.getText());
            ResultSet rs2 = st.executeQuery();
            sql = "SELECT DATE_ADD(?, INTERVAL 7 DAY) into @due";
            st = connect.conn.prepareStatement(sql);
            while(rs2.next()){
                st.setString(1, rs2.getString("Issue_date"));
            }
            rs2 = st.executeQuery();
            sql = "select @due";
            st = connect.conn.prepareStatement(sql);
            rs2 = st.executeQuery();
            sql = "update issuedBooks set Due_Date=? where shelfNo= ?";
            st = connect.conn.prepareStatement(sql);
            while(rs2.next()){
                st.setString(1,rs2.getString("@due"));
            }
            st.setString(2,shelfNo.getText());
            System.out.println(rs2.toString());
            rs = st.executeUpdate();
            if (rs > 0)
                    JOptionPane.showMessageDialog(null, "Successfully set Due Date..!");
		else
                    JOptionPane.showMessageDialog(null, "error");
            sql = "select quantity from bookdetails where shelfNo=?";
            st = connect.conn.prepareStatement(sql);
            st.setString(1, shelfNo.getText());
            rs2 = st.executeQuery();
            int updateQuantity = 0;
            while(rs2.next()){
                updateQuantity = Integer.parseInt(rs2.getString("quantity")) - 1;
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
