/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.system.Model;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.*;

/**
 *
 * @author Md. Fahim Faisal
 */
public class BookDetailsModel {
    private JTable table;
    private JScrollPane scrollPane;
    public BookDetailsModel(){
        this.table = table;
        this.scrollPane = scrollPane;
    }
    public ResultSet Book(ResultSet rs) {
	try {
            connectDB connect = new connectDB();
            String sql = "select * from bookdetails";
            PreparedStatement st = connect.conn.prepareStatement(sql);
            rs = st.executeQuery();
            return rs;
           
//            rs.close();
//            st.close();
            
	} catch (Exception e) {
	
	}
    return null;
    }
}
