/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.swing.JFrame;
import views.*;

public class ViewController {
	
	JFrame frame;
	
	public ViewController(){
		frame = MainWindow.getFrame();
	}

	public void showMainView(){
		frame.setContentPane(new MainView());
		refreshView(frame);
	}
	
	public void showloginView(){
		frame.setContentPane(new LoginView());
		refreshView(frame);
	}
	
	private void refreshView(JFrame f){
		f.pack();
		f.validate();
        f.setVisible(true);
	}
}
