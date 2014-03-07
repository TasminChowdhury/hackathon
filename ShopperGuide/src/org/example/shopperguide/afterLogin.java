package org.example.shopperguide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class afterLogin extends Activity implements OnClickListener{
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afterlogin);
         
        Button buttonshop = (Button)findViewById(R.id.btshop);       
        buttonshop.setOnClickListener(new OnClickListener() {
        	   @Override
        	   public void onClick(View v) {
        	      // button 1 was clicked!
        		   Toast.makeText(getApplicationContext(), "u pressed button shop", 
        				      Toast.LENGTH_SHORT).show();
        		   Intent i=new Intent(
       	                afterLogin.this,
       	                SpinnerActivity.class);
       	         startActivity(i);
       		
        		  
        			
        	   }
        	  });
       
     Button buttonService = (Button)findViewById(R.id.btservice); 
     buttonService.setOnClickListener(new OnClickListener() {
    	   @Override
    	   public void onClick(View v) {
    	      // button 2 was clicked!
    		   Intent i=new Intent(
   	                afterLogin.this,
   	                SpinnerActivity.class);
   	         startActivity(i);
    		  
    	   }
    	  });
   
    }

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		
	}
	

}
