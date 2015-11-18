package PizzaAndroidClient.views;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainView extends Activity
{
    //ViewController vc;
    Button loginButton;
    Button orderButton;
    Button createAccountButton;
    Button viewOrdersButton;
    Button changeMenuButton;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        loginButton = (Button) findViewById(R.id.loginButton);
        orderButton = (Button) findViewById(R.id.orderButton);
        createAccountButton = (Button) findViewById(R.id.CreateAccountButton);
        viewOrdersButton = (Button) findViewById(R.id.viewOrdersButton);
        changeMenuButton = (Button) findViewById(R.id.changeMenuButton);
        
        loginButton.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               //System.out.println("place order button pressed!");
           }
        });
        orderButton.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               //System.out.println("place order button pressed!");
           }
        });
        createAccountButton.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               //System.out.println("place order button pressed!");
           }
        });
        viewOrdersButton.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               //System.out.println("place order button pressed!");
           }
        });
        changeMenuButton.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               //System.out.println("place order button pressed!");
           }
        });
        
    }
   
}
