package org.example.shopperguide;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	Button bAddShop;
	Button bSearch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		bAddShop=(Button)findViewById(R.id.AddShop);
		bSearch=(Button)findViewById(R.id.Search);
		bAddShop.setOnClickListener((OnClickListener) this);
		bSearch.setOnClickListener((OnClickListener) this);

		
		
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
	    if (id == R.id.AddShop){
	        
	    } 
	    else if (id == R.id.Search){
	    	 Log.i("clicks","You Cljkfhhccbuysdicked B1");
             Intent i=new Intent(MainActivity.this,Search.class);
             startActivity(i);
           }

	        
	        
	    } 
		
	

}
