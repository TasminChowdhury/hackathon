package org.example.shopperguide;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SpinnerActivity extends Activity implements OnItemSelectedListener{
        private Spinner spinner;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.spinner);
			
			spinner = (Spinner) findViewById(R.id.spinner);
		        DataBaseHelper helper = new DataBaseHelper(this);
		        try {
					helper.createDataBase();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        helper.openDataBase();
		        helper.close();
		        
		        Set<String> set = new HashSet<String>();
		        helper.openDataBase();
		        Cursor myCursor = helper.getAllStudents();
		        
		        if (myCursor.moveToFirst()) {
		        	do {
		        	set.add(myCursor.getString(1));
		        	} while (myCursor.moveToNext());
		        }
		        myCursor.close();
		        helper.close();
		        List<String> list = new ArrayList<String>(set);
				// Creating adapter for spinner
				ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, list);

				// Drop down layout style - list view with radio button
				dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

				// attaching data adapter to spinner
				spinner.setAdapter(dataAdapter);
		        
		       /* TextView textview = (TextView)findViewById(R.id.MyShopPage);
		        textview.setText(str);*/
		    }

		@Override
		public void onItemSelected(AdapterView<?> parent, View V, int position,
				long id) {
			// TODO Auto-generated method stub
			String name = parent.getItemAtPosition(position).toString();
			Toast.makeText(getApplicationContext(), "You have selected "+name, 
				      Toast.LENGTH_SHORT).show();
           
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
		}
