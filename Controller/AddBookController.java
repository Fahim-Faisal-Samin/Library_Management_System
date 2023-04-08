/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.system.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import library.management.system.Model.AddBookModel;
import library.management.system.View.AddBookView;

/**
 *
 * @author Md. Fahim Faisal
 */
public class AddBookController {
    private AddBookView addBookView;
    private AddBookModel addBookModel;
    public AddBookController(){
        addBookView = new AddBookView();
        addBookModel = new AddBookModel();
        addBookView.setVisible(true);
        addBookView.addButtonListener(new buttonListener());
    }
    class buttonListener implements ActionListener{
    @Override
        public void actionPerformed(ActionEvent ae){
            try{

                if(ae.getSource() == addBookView.getButton(1)){
                    if(addBookModel.addBookRecord(addBookView.getTextField(2), addBookView.getTextField(3), addBookView.getTextField(4), addBookView.getTextField(1), addBookView.getTextField(5))){
                        JOptionPane.showMessageDialog(null, "Successfully Added");
                    }else{
                        JOptionPane.showMessageDialog(null, "Error");
                    }
                    addBookView.random();
                    addBookView.getTextField(2).setText("");
                    addBookView.getTextField(3).setText("");
                    addBookView.getTextField(4).setText("");
                    addBookView.getTextField(5).setText("");
		
                }
                if(ae.getSource() == addBookView.getButton(2)){
                    addBookView.setVisible(false);

                }
            }catch(Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Invalid data");
            }
        }
    }
}
