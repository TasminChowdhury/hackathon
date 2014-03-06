package org.example.shopperguide;

import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.widget.TextView;

public class shopActivity extends Activity {


		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.shoppage);
			
		        
		        DataBaseHelper helper = new DataBaseHelper(this);
		        try {
					helper.createDataBase();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        helper.openDataBase();
		        helper.close();
		        
		        String str = "" ;
		        helper.openDataBase();
		        Cursor myCursor = helper.getAllStudents();
		        
		        myCursor.moveToFirst();
		        while (!myCursor.isAfterLast()){
		        	
		        	str=str.concat( myCursor.getString(1)  + "\n");
		        	
		        	myCursor.moveToNext();
		        }
		        myCursor.close();
		        helper.close();
		        
		        TextView textview = (TextView)findViewById(R.id.MyShopPage);
		        textview.setText(str);
		    }
		}



