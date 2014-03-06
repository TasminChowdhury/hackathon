package org.example.shopperguide;





import java.io.IOException;

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

	            @Override
	            public void onCreate(Bundle savedInstanceState) {

	                super.onCreate(savedInstanceState);
	                setContentView(R.layout.listmain);

	                Model.LoadModel();
	                listView = (ListView) findViewById(R.id.listView);
	                String[] ids = new String[Model.Items.size()];
	                for (int i= 0; i < ids.length; i++){

	                    ids[i] = Integer.toString(i+1);
	                }

	                ItemAdapter adapter = new ItemAdapter(this,R.layout.adapter, ids);
	                listView.setAdapter(adapter);

	            
	    }
	}




