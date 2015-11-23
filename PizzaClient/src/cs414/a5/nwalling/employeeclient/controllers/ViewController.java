/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a5.nwalling.employeeclient.controllers;

import cs414.a5.nwalling.employeeclient.views.LoginView;
import cs414.a5.nwalling.employeeclient.views.ChangeMenuView;
import cs414.a5.nwalling.employeeclient.views.MainWindow;
import cs414.a5.nwalling.employeeclient.views.CreateAccountView;
import cs414.a5.nwalling.employeeclient.views.ChefView;
import cs414.a5.nwalling.employeeclient.views.MainView;
import cs414.a5.nwalling.common.data.IDataSource;
import cs414.a5.nwalling.common.data.PizzaServiceClient;
import cs414.a5.nwalling.common.exceptions.StorageException;
import cs414.a5.nwalling.common.models.IItemModel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import cs414.a5.nwalling.common.models.IModel;
import cs414.a5.nwalling.common.models.ItemModel;
import cs414.a5.nwalling.common.models.OrderModel;
import cs414.a5.nwalling.common.models.UserModel;

public class ViewController extends AbstractController{
	
	JFrame frame;
	
        private IDataSource source;
        
        private IModel orderModel;

        private  DefaultListModel<String> menu;
        
        public ViewController()
        {
            super();
            user = new UserModel();
            ((UserModel)user).setUsername("Guest");
            ((UserModel)user).setAuthLevel(5);
            frame = MainWindow.getFrame();
            try
            {
                source = new PizzaServiceClient("http://localhost:8080");
            }
            catch (Exception e)
            {
                String cat = "meow";
                //Show alert box!
            }
            menu = new DefaultListModel();
            displayMenu();
        }
	public ViewController(DefaultListModel<String> menuListModel){
            super();
            user = new UserModel();
            frame = MainWindow.getFrame();
            try
            {
                source = new PizzaServiceClient("http://localhost:8080");
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
                
        public UserModel getUser(){
            return ((UserModel)user);
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
            displayMenu();
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
//            frame.setContentPane(new PaymentView(this, source));
            refreshView(frame);
        }
        
        public void showOrderView(){
//            OrderView ov = new OrderView(source,this);
            
//            frame.setContentPane(ov);
            refreshView(frame);
        }
        
        public void showChefView(){
            frame.setContentPane(new ChefView(this, source));
            refreshView(frame);
        }
        
        public void showChangeMenuView(){
            frame.setContentPane(new ChangeMenuView(source, this));
            refreshView(frame);
        }
        
        public void displayMenu(){
            ArrayList<IItemModel> items = null;
            try {
                items = source.getItems();
            } catch (StorageException ex) {
                Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
            for(IItemModel m : items)
            {
                String menuItem = m.getName();
                if(m.getIsSpecial())
                    menuItem = menuItem + "SPECIAL: $" + m.getSpecialPrice();
                else
                    menuItem = menuItem + " $" + m.getPrice();
                menu.addElement(menuItem);
            }
//            items.stream().forEach((x) -> { menu.addElement(((ItemModel)x).getName());});
        }
        
        public void displayOrder(){
//            ArrayList<IModel> items = null;
//            try {
//                 items = source.getItems();
//            } catch (StorageException ex) {
//                Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//            items.stream().forEach((x) -> { menu.addElement(((ItemModel)x).getName());});
//            MainView mv = new MainView(this);
//            String menu = "Your Current Order:\n\nPizza\nSoda\nBreadsticks";
//            mv.changeDisplayMessage(menu);
//            frame.setContentPane(mv);
//            refreshView(frame);
        }
	
	private void refreshView(JFrame f){
            f.pack();
            f.validate();
            f.setVisible(true);
        }

        public void updateUser(UserModel newUser){
            user = newUser;
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

