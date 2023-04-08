/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.system.Model;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Md. Fahim Faisal
 */
public class RegisterModel {
    public void signup(JTextField name, JTextField username, JPasswordField pass){
        try {
            connectDB connect = new connectDB();
            String newSql = "insert into account (username, password, userType, name) values (?, ?, 'student', ?)";
            PreparedStatement stmt = connect.conn.prepareStatement(newSql);
            stmt.setString(1, username.getText());
            stmt.setString(2, pass.getText());
            stmt.setString(3, name.getText());
            
            int i = stmt.executeUpdate();
            newSql = "select libCardNo from account where username=? and password=?";
            stmt = connect.conn.prepareStatement(newSql);
            stmt.setString(1, username.getText());
            stmt.setString(2, pass.getText());
            ResultSet rs =stmt.executeQuery();
            String libID = null;
            while(rs.next()){
                libID = rs.getString("libCardNo");
            }
            if (i > 0){
                    JOptionPane.showMessageDialog(null, "Successfully Created! Library Card No: "+libID);
            }
            name.setText("");
            username.setText("");
            pass.setText("");
                    
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Invalid data");
        }
    }
}
