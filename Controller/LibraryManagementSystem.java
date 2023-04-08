package library.management.system.Controller;

import library.management.system.View.LoginView;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import library.management.system.Controller.LoginController;
import library.management.system.Model.LoginModel;

public class LibraryManagementSystem extends JFrame{

        
        public LibraryManagementSystem() {
		LoginView loginView = new LoginView();
                LoginModel loginModel =  new LoginModel();
                LoginController logCont = new LoginController(loginView, loginModel);
            
                
	}
        
       
        
        public static void main(String[] args) {
                LibraryManagementSystem window = new LibraryManagementSystem();	
                
                
	}
}
