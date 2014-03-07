package org.example.shopperguide;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
//import android.graphics.Color;
//import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	   private EditText  username=null;
	   private EditText  password=null;
	  // private TextView attempts;
	   private Button login;
	   int counter = 3;
	   @Override
	   protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.main);
	      username = (EditText)findViewById(R.id.etuser);
	      password = (EditText)findViewById(R.id.etpass);
	      login = (Button)findViewById(R.id.blogin);
	      
	      login.setOnClickListener(this);
	      
	      TextView registerScreen = (TextView) findViewById(R.id.link_to_register);
	        
	        // Listening to register new account link
	      registerScreen.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					// Switching to Register screen
					Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
					startActivity(i);
				}
			});
	     
	   }

	   public void login(View view){
	      if(username.getText().toString().equals("admin") && 
	      password.getText().toString().equals("admin")){
	      Toast.makeText(getApplicationContext(), "Redirecting...", 
	      Toast.LENGTH_SHORT).show();
	   }	
	   else{
	      Toast.makeText(getApplicationContext(), "Wrong Credentials",
	      Toast.LENGTH_SHORT).show();
	     /* attempts.setBackgroundColor(Color.RED);	
	      counter--;
	      attempts.setText(Integer.toString(counter));
	      if(counter==0){
	         login.setEnabled(false);*/
	      }

	   }

	
	 

	
		
		


	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent i=new Intent(
                MainActivity.this,
                afterLogin.class);
         startActivity(i);
		
	}

	        
	        
} 
		
