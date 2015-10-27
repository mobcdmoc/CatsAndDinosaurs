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
        
        public void showCreateAccountView(){
		frame.setContentPane(new CreateAccountView());
		refreshView(frame);
	}
        
        public void showPaymentView(){
            frame.setContentPane(new PaymentView());
            refreshView(frame);
        }
        
        public void showOrderView(){
            OrderView ov = new OrderView();
            String[] menArr = {"Pizza", "Soda", "Breadsticks"};
            String[] ordArr = {"Soda"};
            String menu = "", ord = "";
            
            for (int i = 0; i < menArr.length ;i++){
                menu += (i+1) + ": " + menArr[i];
                ov.addItemsToMenuSelect(Integer.toString(i+1));
                menu += "\n";
            }
            
            for (int i = 0; i < ordArr.length ;i++){
                ord += (i+1) + ": " + ordArr[i];
                ov.addItemsToOrderSelect(Integer.toString(i+1));
                ord += "\n";
            }
            
            ov.setMenu(menu);
            ov.setOrder(ord);
            frame.setContentPane(ov);
            refreshView(frame);
        }
        
        public void showChefView(){
            frame.setContentPane(new ChefView());
            refreshView(frame);
        }
        
        public void showChangeMenuView(){
            frame.setContentPane(new ChangeMenuView());
            refreshView(frame);
        }
        
        public void displayMenu(){
            MainView mv = new MainView();
            String menu = "Pizza\nSoda\nBreadsticks";
            mv.changeDisplayMessage(menu);
            frame.setContentPane(mv);
            refreshView(frame);
        }
        
        public void displayOrder(){
            MainView mv = new MainView();
            String menu = "Your Current Order:\n\nPizza\nSoda\nBreadsticks";
            mv.changeDisplayMessage(menu);
            frame.setContentPane(mv);
            refreshView(frame);
        }
	
	private void refreshView(JFrame f){
            f.pack();
            f.validate();
            f.setVisible(true);
	}
}
