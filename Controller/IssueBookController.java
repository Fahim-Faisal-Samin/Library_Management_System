/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.system.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import library.management.system.Model.IssueBookModel;
import library.management.system.View.IssueBookView;

/**
 *
 * @author Md. Fahim Faisal
 */
public class IssueBookController {
    private IssueBookView issueView;
    private IssueBookModel issueModel;
    private PreparedStatement st;
    public IssueBookController(){
        this.issueModel = new IssueBookModel();
        this.issueView = new IssueBookView();
        issueView.addButtonListener(new buttonListener());
        issueView.setVisible(true);
    }
    class buttonListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource() == issueView.getButton(1)){
                ResultSet rs = issueModel.getBookRecord(st, issueView.getTextField(1).getText());
                while (rs.next()) {
                    issueView.getTextField(2).setText(rs.getString("title"));
                    issueView.getTextField(3).setText(rs.getString("isbn"));
                    issueView.getTextField(4).setText(rs.getString("author"));
//                    t5.setText(rs.getString("edition"));
//                    t6.setText(rs.getString("price"));
//                    t7.setText(rs.getString("pages"));
		}
                st.close();
		rs.close();
		
            }
            if(ae.getSource() == issueView.getButton(2)){
                ResultSet rs = issueModel.getStudentRecord(issueView.getTextField(8).getText());
		
                while (rs.next()) {
                    issueView.getTextField(9).setText(rs.getString("name"));
                    issueView.getTextField(10).setText(rs.getString("username"));
		}
                st.close();
		rs.close();
		
            }
            if(ae.getSource() == issueView.getButton(3)){
              try{
                  issueModel.issueTheBook(issueView.getTextField(1),issueView.getTextField(8),issueView.getTextField(2),issueView.getTextField(9), issueView.getDateField());
		
                    }catch(Exception e){
                        e.printStackTrace();
                    }
            }
            if(ae.getSource() == issueView.getButton(4)){
                issueView.setVisible(false);
		//new LibrarianView().setVisible(true);
			
            }
         
        }catch(Exception e){
            
        }
    }
    }
}
