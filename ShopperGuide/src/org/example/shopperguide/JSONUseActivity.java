package org.example.shopperguide;

import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import org.example.shopperguide.CustomHttpClient;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class JSONUseActivity extends Activity {
 EditText rating;   // To take birthyear as input from user
 Button submit;    
 TextView tv;      // TextView to show the result of MySQL query 
 
 String returnString;   // to store the result of MySQL query after decoding JSON
 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
     StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
  .detectDiskReads().detectDiskWrites().detectNetwork() // StrictMode is most commonly used to catch accidental disk or network access on the application's main thread
  .penaltyLog().build());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        
        rating = (EditText) findViewById(R.id.editText1);
        submit = (Button) findViewById(R.id.submitbutton);
        tv = (TextView) findViewById(R.id.showresult);
                
        // define the action when user clicks on submit button
        submit.setOnClickListener(new View.OnClickListener(){        
         public void onClick(View v) {
          // declare parameters that are passed to PHP script i.e. rating submitted by user   
          ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
          
          // define the parameter
          postParameters.add(new BasicNameValuePair("rating",
      rating.getText().toString()));
          String response = null;
          
          // call executeHttpPost method passing necessary parameters 
          try {
     response = CustomHttpClient.executeHttpPost(
       //"http://129.107.187.135/CSE5324/jsonscript.php", // your ip address if using localhost server
       "http://shoppersguide.comyr.com",  // in case of a remote server
       postParameters);
     
     // store the result returned by PHP script that runs MySQL query
     String result = response.toString();  
              
      //parse json data
         try{
                 returnString = "";
           JSONArray jArray = new JSONArray(result);
                 for(int i=0;i<jArray.length();i++){
                         JSONObject json_data = jArray.getJSONObject(i);
                         Log.i("log_tag","ID: "+json_data.getInt("id")+
                                 ", name: "+json_data.getString("name")+
                                 ", LOACATION: "+json_data.getInt("location")+
                                 ", rating: "+json_data.getInt("rating")
                         );
                         //Get an output to the screen
                         returnString += "\n" +  json_data.getInt("rating");
                 }
         }
         catch(JSONException e){
                 Log.e("log_tag", "Error parsing data "+e.toString());
         }
     
         try{
          tv.setText(returnString);
         }
         catch(Exception e){
          Log.e("log_tag","Error in Display!" + e.toString());;          
         }   
    }
          catch (Exception e) {
     Log.e("log_tag","Error in http connection!!" + e.toString());     
    }
         }         
        });
    }
}
