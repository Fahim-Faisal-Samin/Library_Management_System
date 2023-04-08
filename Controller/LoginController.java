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
import javax.swing.JPasswordField;

import library.management.system.View.Loading;
import library.management.system.Model.LoginModel;
import library.management.system.Model.RegisterModel;
import library.management.system.View.LibrarianView;

import library.management.system.View.LoginView;
import library.management.system.View.Register;

/**
 *
 * @author Md. Fahim Faisal
 */
public class LoginController {
    private LoginView loginView;
    private LoginModel loginModel;
    private RegisterController regCont;
    public LoginController(LoginView loginView, LoginModel loginModel) {
        this.loginView = loginView;
        this.loginModel = loginModel;
        this.loginView.setVisible(true);
        this.loginView.addLoginListener(new buttonListener());
        this.loginView.addSignUpListener(new buttonListener());
    }

    LoginController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    class buttonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            Boolean authorized = false;
            if(ae.getSource() == loginView.getButton(1)){
                authorized = loginModel.login(loginView.getTextField(1), (JPasswordField) loginView.getTextField(0));
                if(authorized){
                    loginView.setVisible(false);
                    new Loading(loginModel.getUserType(), loginModel.getLibID()).setVisible(true);
                    
                    
                }else
                    JOptionPane.showMessageDialog(null, "Invalid Login...!.");
            }
            if(ae.getSource() == loginView.getButton(2)){
		regCont = new RegisterController(new Register(), new RegisterModel());
                
            }   
            
        }
        
    }

}
