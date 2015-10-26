package views;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controllers.ViewController;

public class MainView extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private static ViewController vc = new ViewController();
	
	public MainView() {
		
		JTextArea txtrPizza = new JTextArea();
		txtrPizza.setText("Welcome to Pizza Place!\r\n\r\nPlease choose an option on the right.");
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vc.showloginView();
			}
		});
		
		JButton createAccountButton = new JButton("Create Account");
		
		JButton btnMakeOrder = new JButton("Make Order");
		
		JButton btnCheckOrders = new JButton("Check Orders");
		
		JButton btnUpdateMenu = new JButton("Update Menu");
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtrPizza, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnExit, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(btnUpdateMenu, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(btnCheckOrders, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(loginButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(createAccountButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(btnMakeOrder, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
					.addGap(25))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addComponent(loginButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(createAccountButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnMakeOrder)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCheckOrders)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnUpdateMenu)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExit)
					.addContainerGap(20, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(20, Short.MAX_VALUE)
					.addComponent(txtrPizza, GroupLayout.PREFERRED_SIZE, 448, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		setLayout(groupLayout);

	}
}
