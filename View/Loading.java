package library.management.system.View;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import library.management.system.Controller.LibrarianController;
import library.management.system.Controller.StudentController;

public class Loading extends JFrame implements Runnable {

	private JPanel contentPane;
	private JProgressBar progressBar;
        private String userType, libCardID;
        public Boolean loaded=false;
	Connection conn;
	int s;
	Thread th;

	public void setUploading() {
            setVisible(false);
            th.start();
	}
        
	public void run() {
            try {
                this.setVisible(true);
                for (int i = 0; i < 200; i++) {
                    s = s + 1;
                    int m = progressBar.getMaximum();
                    int v = progressBar.getValue();
                    if (v < m) {
                        progressBar.setValue(progressBar.getValue() + 1);
                    } else {
                        setVisible(false);
                        break;
                        
                        
                    }
                    Thread.sleep(2);
                    
                }
                
            } catch (Exception e) {
		e.printStackTrace();
            }
	}

	public Loading(String userType, String libCardID) {
           
            super("Loading");
            th = new Thread((Runnable) this);
            this.userType = userType;
            this.libCardID = libCardID;
            setBounds(600, 300, 600, 400);
            contentPane = new JPanel();
            setContentPane(contentPane);
            contentPane.setLayout(null);

            JLabel lbllibraryManagement = new JLabel("LMS v0.0.1");
            lbllibraryManagement.setForeground(new Color(137, 191, 54)); 
            lbllibraryManagement.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
            lbllibraryManagement.setBounds(130, 46, 500, 35);
            contentPane.add(lbllibraryManagement);
	
            progressBar = new JProgressBar();
            progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
            progressBar.setStringPainted(true);
            progressBar.setBounds(130, 135, 300, 25);
            contentPane.add(progressBar);

            JLabel lblNewLabel_2 = new JLabel("Please Wait...");
            lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
            lblNewLabel_2.setForeground(new Color(160, 82, 45));
            lblNewLabel_2.setBounds(200, 165, 150, 20);
            contentPane.add(lblNewLabel_2);

            JPanel panel = new JPanel();
            panel.setBackground(Color.WHITE);
            panel.setBounds(0, 0, 590, 390);
            contentPane.add(panel);
                
            setUploading();
            this.loaded = true;
            while(true){
                        if(this.loaded){
                            if(this.userType.equalsIgnoreCase("Librarian")){
                                new LibrarianController();
                            }else if(this.userType.equalsIgnoreCase("Student")){
                                new StudentController(this.libCardID);
                            }
                            break;
                        }
                    }
	}
}
