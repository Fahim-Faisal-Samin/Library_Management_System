package library.management.system.Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Md. Fahim Faisal
 */
import java.sql.*;
public class connectDB {
    public Connection conn;
    Statement stmt;
    public connectDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///LMS","root","");
            stmt = conn.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
