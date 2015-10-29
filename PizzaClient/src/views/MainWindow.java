/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javax.swing.JFrame;
import controllers.ViewController;

public class MainWindow {
	
	private static JFrame f;
	private static ViewController vc;

	public static void main(String args[]){
                
		f = new JFrame();
		vc = new ViewController();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        vc.showMainView();
        
	}
	
	public static JFrame getFrame(){
		return f;
	}
        
        public static void setViewController(ViewController VC){
            vc = VC;
            vc.showMainView();
        }
}