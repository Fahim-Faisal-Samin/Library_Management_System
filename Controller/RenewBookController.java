/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.system.Controller;

/**
 *
 * @author Md. Fahim Faisal
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import library.management.system.Model.RenewBookModel;
import library.management.system.View.RenewBookView;
import library.management.system.View.StudentView;
public class RenewBookController {
    private String libCardID;
    private RenewBookView rnwView;
    private RenewBookModel rnwModel;
    private PreparedStatement st;
    public RenewBookController(String libCardID){
        this.libCardID = libCardID; 
        this.rnwModel = new RenewBookModel();
        this.rnwView = new RenewBookView();
        rnwView.addButtonListener(new buttonListener());
        rnwView.getTextField(8).setText(libCardID);
        rnwView.setVisible(true);
        
    }
    class buttonListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource() == rnwView.getButton(1)){
                ResultSet rs = rnwModel.getBookRecord(st, rnwView.getTextField(1).getText());
                while (rs.next()) {
                    rnwView.getTextField(2).setText(rs.getString("title"));
                    rnwView.getTextField(3).setText(rs.getString("isbn"));
                    rnwView.getTextField(4).setText(rs.getString("author"));
//                    t5.setText(rs.getString("edition"));
//                    t6.setText(rs.getString("price"));
//                    t7.setText(rs.getString("pages"));
		}
                st.close();
		rs.close();
		
            }
            if(ae.getSource() == rnwView.getButton(2)){
                ResultSet rs = rnwModel.getStudentRecord(rnwView.getTextField(8).getText());
		
                while (rs.next()) {
                    rnwView.getTextField(9).setText(rs.getString("name"));
                    rnwView.getTextField(10).setText(rs.getString("username"));
		}
                st.close();
		rs.close();
		
            }
            if(ae.getSource() == rnwView.getButton(3)){
              try{
                  rnwModel.renewTheBook(rnwView.getTextField(1),rnwView.getTextField(8),rnwView.getTextField(2),rnwView.getTextField(9));
		
                    }catch(Exception e){
                        e.printStackTrace();
                    }
            }
            if(ae.getSource() == rnwView.getButton(4)){
                rnwView.setVisible(false);
		//new StudentView().setVisible(true);
			
            }
//            
        }catch(Exception e){
            
        }
    }
    }
}
