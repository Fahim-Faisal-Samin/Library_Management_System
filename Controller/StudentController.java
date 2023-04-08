/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.system.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.ABORT;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import library.management.system.Model.BookDetailsModel;
import library.management.system.View.BookDetailsView;
import library.management.system.View.StudentView;

/**
 *
 * @author Md. Fahim Faisal
 */
public class StudentController {
    private String name;
    private String libCardID;
    private int clss;
    private StudentView stdView;
    public BookDetailsView bkView;
    public BookDetailsModel bkModel;
    public boolean verify(){
        return false;
    }
    public String checkAccount(){
        return "";
    }
    public String getBookInfor(){
        return "";
    }
    
    public StudentController(String libCardID){
        this.libCardID = libCardID;
        this.stdView = new StudentView();
        stdView.addButtonListener(new buttonListener());
        stdView.setVisible(true);
        
    }
    class buttonListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            String msg = ae.getActionCommand();
            if(ae.getSource() == stdView.getButton(1)){
                //stdView.setVisible(false);
                new RenewBookController(libCardID);
            }
            
            if(ae.getSource() == stdView.getButton(3)){
                //stdView.setVisible(false);
                
                bkModel = new BookDetailsModel();
                bkView = new BookDetailsView(bkModel);
                bkView.setVisible(true);
            }
            
            if(msg.equals("Logout")){
                stdView.setVisible(false);
                new LibraryManagementSystem();
                

            }else if(msg.equals("Exit")){
                System.exit(ABORT);
            
            }else if(msg.equals("Book Details")){
                stdView.setVisible(false);

            }
        }
    }
}
