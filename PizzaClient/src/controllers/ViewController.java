/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import data.IDataSource;
import data.PizzaServiceClient;
import exceptions.StorageException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import models.IModel;
import models.ItemModel;
import models.OrderModel;
import models.UserModel;
import views.*;

public class ViewController extends AbstractController{
	
	JFrame frame;
	
        private IDataSource source;
        
        private IModel orderModel;

        private  DefaultListModel<String> menu;
        
        
        
        public ViewController()
        {
            super();
            model = new UserModel();
            frame = MainWindow.getFrame();
            try
            {
                source = new PizzaServiceClient();
            }
            catch (Exception e)
            {
                //Show alert box!
            }
            menu = new DefaultListModel();
        }
	public ViewController(DefaultListModel<String> menuListModel){
            super();
            model = new UserModel();
            frame = MainWindow.getFrame();
            try
            {
                source = new PizzaServiceClient();
            }
            catch (Exception e)
            {
                //Show alert box!
            }
            menu = menuListModel;
            displayMenu();
	}
        public  DefaultListModel getMenu()
        {
            return menu;
        }
                
        public void setOrderModel(IModel model)
        {
            orderModel = model;
        }
        public IModel getOrderModel()
        {
           return orderModel;
        }
	public void showMainView(){
            frame.setContentPane(new MainView(this));
            refreshView(frame);
	}
	
	public void showloginView(){
            frame.setContentPane(new LoginView(this));
            refreshView(frame);
	}
        
        public void showCreateAccountView(){
            frame.setContentPane(new CreateAccountView(this));
            refreshView(frame);
	}
        
        public void showPaymentView(){
            frame.setContentPane(new PaymentView(this, source));
            refreshView(frame);
        }
        
        public void showOrderView(){
            OrderView ov = new OrderView(source,this);
            
            frame.setContentPane(ov);
            refreshView(frame);
        }
        
        public void showChefView(){
            frame.setContentPane(new ChefView(this));
            refreshView(frame);
        }
        
        public void showChangeMenuView(){
            frame.setContentPane(new ChangeMenuView(source, this));
            refreshView(frame);
        }
        
        public void displayMenu(){
            ArrayList<IModel> items = null;
            try {
                 items = source.getItems();
            } catch (StorageException ex) {
                Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            items.stream().forEach((x) -> { menu.addElement(((ItemModel)x).getName());});
        }
        
        public void displayOrder(){
            ArrayList<IModel> items = null;
            try {
                 items = source.getItems();
            } catch (StorageException ex) {
                Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            items.stream().forEach((x) -> { menu.addElement(((ItemModel)x).getName());});
            MainView mv = new MainView(this);
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

    @Override
    public void submit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onClose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void runCommand(String command, Object input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}

