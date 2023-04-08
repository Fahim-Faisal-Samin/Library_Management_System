/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.system.Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Md. Fahim Faisal
 */
public class LoginModel {
   private String userType;
   private String libID;
   public String getUserType(){
       return userType;
   }
   public String getLibID(){
       return libID;
   }
    public boolean login(JTextField text, JPasswordField password){
         try {
                    connectDB connect = new connectDB();
                    String sql = "select * from account where username=? and password=?";
                    PreparedStatement st = connect.conn.prepareStatement(sql);

                    st.setString(1, text.getText());
                    st.setString(2, password.getText());

                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        userType = rs.getString(3);
                        libID = rs.getString(5);
                        return true;
                    } else{
                        
                        return false;
                    }
		} catch (Exception e2) {
                    e2.printStackTrace();
		}
         return false;
    }
}
