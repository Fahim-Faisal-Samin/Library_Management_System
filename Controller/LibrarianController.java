/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.system.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.ABORT;
import library.management.system.Model.BookDetailsModel;
import library.management.system.Model.LoginModel;
import library.management.system.Model.RegisterModel;
import library.management.system.View.BookDetailsView;
import library.management.system.View.LibrarianView;
import library.management.system.View.LoginView;
import library.management.system.View.Register;

/**
 *
 * @author Md. Fahim Faisal
 */
public class LibrarianController {
    private String name;
    private int id;
    private String searchString;
    private LibrarianView libView;
    public BookDetailsView bkView;
    public BookDetailsModel bkModel;
    private RegisterController regCont;
    public boolean verifyLibrarian(){
        return false;
    }
    public String search(String searchString){
        return "";
    }
    public LibrarianController(){
        this.libView = new LibrarianView();
        libView.setVisible(true);
        libView.addButtonListener(new buttonListener());
        
    }
    class buttonListener implements ActionListener{

        public void actionPerformed(ActionEvent ae){
            String msg = ae.getActionCommand();
            if(ae.getSource() == libView.getButton(1)){
                new AddBookController();
            }
            
            if(ae.getSource() == libView.getButton(3)){
                regCont = new RegisterController(new Register(), new RegisterModel());

            }
            
            if(ae.getSource() == libView.getButton(4)){
                new IssueBookController();
            }
            if(ae.getSource() == libView.getButton(5)){
                new ReturnBookController();
            }
            if(msg.equals("Logout")){
                libView.setVisible(false);
                new LibraryManagementSystem();

            }else if(msg.equals("Exit")){
                System.exit(ABORT);
            
            }else if(msg.equals("Book Details")){
                bkModel = new BookDetailsModel();
                bkView = new BookDetailsView(bkModel);
                bkView.setVisible(true);

            }else if(msg.equals("Student Details")){
                libView.setVisible(false);
			
            }
            
           /* if(ae.getSource() == b1){
                libView.setVisible(false);

            }
            if(ae.getSource() == b2){
                libView.setVisible(false);

            }
            
            if(ae.getSource() == 4)){
                libView.setVisible(false);

            }
            if(ae.getSource() == b5){
                libView.setVisible(false);

            
            }
            if(ae.getSource() == b6){
                libView.setVisible(false);

            
            }*/
            
        }
    }
}
