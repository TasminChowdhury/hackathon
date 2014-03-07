package org.example.shopperguide;





import java.io.IOException;
import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.widget.TextView;


	        
	       
   import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

	        public class ListActivity extends Activity {

	            ListView listView;
	            public ArrayList<Item> Items;
	            public DataBaseHelper helper;

	            @Override
	            public void onCreate(Bundle savedInstanceState) {

	                super.onCreate(savedInstanceState);
	                setContentView(R.layout.listmain);
	                
	                
	                helper= new DataBaseHelper(this);
	      	      try {
	      				helper.createDataBase();
	      			} catch (IOException e) {
	      				// TODO Auto-generated catch block
	      				e.printStackTrace();
	      			}
	      	       helper.openDataBase();
	      	       helper.close();
	      	       
	      	       

			        helper.openDataBase();
			        Cursor myCursor = helper.getAllStudents();
			        int i= 1;
			        myCursor.moveToFirst();
			        while (!myCursor.isAfterLast()){
			        	String str = "" ;
			        	str=str.concat( myCursor.getString(1)  + "\n");
			        	Items.add(new Item(i, "ic_action_location_2.png",str));
			        	myCursor.moveToNext();
			        	i++;
			        }
			        myCursor.close();
			        helper.close();
			        
			        

	               // Model.LoadModel();
	                listView = (ListView) findViewById(R.id.listView);
	                String[] ids = new String[Model.Items.size()];
	                for (int j= 0; j < ids.length; j++){

	                    ids[j] = Integer.toString(j+1);
	                }

	                ItemAdapter adapter = new ItemAdapter(this,R.layout.adapter, ids);
	                listView.setAdapter(adapter);

	            
	    }
	}




