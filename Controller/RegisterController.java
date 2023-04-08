/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.system.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;
import library.management.system.Model.RegisterModel;
import library.management.system.View.Register;

/**
 *
 * @author Md. Fahim Faisal
 */
public class RegisterController {
    private Register regView;
    private RegisterModel regMod;
    public RegisterController(Register regView, RegisterModel regMod){
        this.regView = regView;
        this.regMod = regMod;
        this.regView.setVisible(true);
        regView.addCreateListener(new buttonListener());
        regView.addBackListener(new buttonListener());
    }
    class buttonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() == regView.getButton(1)){
                regMod.signup(regView.getTextField(1), regView.getTextField(2), (JPasswordField) regView.getTextField(3));
            }
            if(ae.getSource() == regView.getButton(2)){
		regView.setVisible(false);
            }
        }
        
    }
}
