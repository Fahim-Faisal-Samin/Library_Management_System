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
//import com.toedter.calendar.JDateChooser;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class RenewBookModel {
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
    public void renewTheBook(JTextField shelfNo, JTextField stLibID, JTextField bookTitle, JTextField stdName){
        try{
            connectDB connect = new connectDB();
            String sql = "select Due_Date from issuedBooks where shelfNo= ? and stLibID= ?";
            PreparedStatement st = connect.conn.prepareStatement(sql);
            st.setString(1, shelfNo.getText());
            st.setString(2, stLibID.getText());
            ResultSet rs2 = st.executeQuery();
            sql = "SELECT DATE_ADD(?, INTERVAL 7 DAY) into @due";
            st = connect.conn.prepareStatement(sql);
            while(rs2.next()){
                st.setString(1, rs2.getString("Due_Date"));
            }
            rs2 = st.executeQuery();
            sql = "select @due";
            st = connect.conn.prepareStatement(sql);
            rs2 = st.executeQuery();
            sql = "update issuedBooks set Due_Date=? where shelfNo= ? and stLibID=?";
            st = connect.conn.prepareStatement(sql);
            while(rs2.next()){
                st.setString(1,rs2.getString("@due"));
            }
            st.setString(2,shelfNo.getText());
            st.setString(3,stLibID.getText());
            System.out.println(rs2.toString());
            int rs = st.executeUpdate();
            if (rs > 0)
                    JOptionPane.showMessageDialog(null, "Successfully Renewed Book..!");
		else
                    JOptionPane.showMessageDialog(null, "error");
            
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
