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
import library.management.system.Model.ReturnBookModel;
import library.management.system.View.ReturnBookView;
public class ReturnBookController {
    private ReturnBookView retView;
    private ReturnBookModel retModel;
    private PreparedStatement st;
    public ReturnBookController(){ 
        this.retModel = new ReturnBookModel();
        this.retView = new ReturnBookView();
        retView.addButtonListener(new buttonListener());
        retView.setVisible(true);
        
    }
    class buttonListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource() == retView.getButton(1)){
                ResultSet rs = retModel.getBookRecord(st, retView.getTextField(1).getText());
                while (rs.next()) {
                    retView.getTextField(2).setText(rs.getString("title"));
                    retView.getTextField(3).setText(rs.getString("isbn"));
                    retView.getTextField(4).setText(rs.getString("author"));
//                    t5.setText(rs.getString("edition"));
//                    t6.setText(rs.getString("price"));
//                    t7.setText(rs.getString("pages"));
		}
                st.close();
		rs.close();
		
            }
            if(ae.getSource() == retView.getButton(2)){
                ResultSet rs = retModel.getStudentRecord(retView.getTextField(8).getText());
		
                while (rs.next()) {
                    retView.getTextField(9).setText(rs.getString("name"));
                    retView.getTextField(10).setText(rs.getString("username"));
		}
                st.close();
		rs.close();
		
            }
            if(ae.getSource() == retView.getButton(3)){
              try{
                  retModel.returnTheBook(retView.getTextField(1),retView.getTextField(8),retView.getTextField(2),retView.getTextField(9));
		
                    }catch(Exception e){
                        e.printStackTrace();
                    }
            }
            if(ae.getSource() == retView.getButton(4)){
                retView.setVisible(false);
		//new StudentView().setVisible(true);
			
            }
//            
        }catch(Exception e){
            
        }
    }
    }
}
