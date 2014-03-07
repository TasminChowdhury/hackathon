package org.example.shopperguide;



import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DataBaseHelper extends SQLiteOpenHelper{
	  private static final int DATABASE_ID = 1;
      private String DB_PATH;
      private static String DB_NAME = "test.sqlite";
      private Context context;
      private SQLiteDatabase dataBase = null;

      public DataBaseHelper(Context context) {
              super(context, DB_NAME, null, DATABASE_ID);
              this.context = context;
              DB_PATH = "/data/data/" + context.getPackageName() + "/" + "databases/";
              Log.v("log_tag", "DBPath: " + DB_PATH);
             
              try {
                      createDataBase();
              } catch (IOException e) {
                      Log.e("log_tag", "Database Creation Error");
              }
      }

      public void createDataBase() throws IOException {
              boolean dbExist = checkDataBase();
              if (dbExist) {
                      Log.v("log_tag", "database does exist");
              } else {
                      Log.v("log_tag", "database does not exist");
                      this.getReadableDatabase();
                      copyDataBase();
              }
      }
      


      private void copyDataBase() {
              try {
                      Log.v("DB", "Copying database");
                     
                      InputStream myInput = context.getAssets().open(DB_NAME);
                      String outFileName = DB_PATH + DB_NAME;
                      OutputStream myOutput = new FileOutputStream(outFileName);
                      byte[] buffer = new byte[1024];
                      int length;
                      while ((length = myInput.read(buffer)) > 0) {
                              myOutput.write(buffer, 0, length);
                              myOutput.flush();
                      }
                      myOutput.flush();
                      myOutput.close();
                      myInput.close();
              }
              catch (IOException exception) {
                      Log.e("DB", "dtabase copy failed", exception);
              }
      }
      private boolean checkDataBase() {
  		SQLiteDatabase checkDB = null;
  		try {
  			String myPath = DB_PATH + DB_NAME;
  			checkDB = SQLiteDatabase.openDatabase(myPath, null,
  					SQLiteDatabase.NO_LOCALIZED_COLLATORS);
  		} catch (SQLiteException e) {
  			Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT)
  					.show();
  			Log.d("Check DB", e.getMessage());
  		}

  		if (checkDB != null) {
  			checkDB.close();
  		}
  		return checkDB != null ? true : false;
  	}
      public void openDataBase() throws SQLException {
  		String myPath = DB_PATH + DB_NAME;
  		dataBase = SQLiteDatabase.openDatabase(myPath, null,
  				SQLiteDatabase.NO_LOCALIZED_COLLATORS);
  	}

      @Override
      public synchronized void close() {
              if (dataBase != null)
                      dataBase.close();
              super.close();
      }

      @Override
      public void onCreate(SQLiteDatabase db) {

      }

      @Override
      public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
              Log.v("update", oldVersion + " -> " + newVersion);
             
             
              copyDataBase();
      }
      public Cursor getAllStudents () {
  		String SQL = "SELECT * FROM Shop;" ;
  		Cursor cursor =dataBase.rawQuery(SQL, null) ;
  		return cursor ;
  	}
      public Cursor getAllusers () {
    		String SQL = "SELECT * FROM User;" ;
    		Cursor cursor =dataBase.rawQuery(SQL, null) ;
    		return cursor ;
    	}
      

}
