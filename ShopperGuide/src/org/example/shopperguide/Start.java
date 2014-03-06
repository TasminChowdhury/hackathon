package org.example.shopperguide;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Start extends Activity{
    MediaPlayer ourSong;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.starting);
		ourSong = MediaPlayer.create(Start.this,R.raw.start_sound);
		SharedPreferences getpref= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean music= getpref.getBoolean("checkbox", true);
		if(music==true) ourSong.start();
		Thread timer=new Thread(){
			public void run(){
				try{
					sleep(8000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					
					Intent openStartingPoint = new Intent("org.example.shopperguide.MAINACTIVITY");
					startActivity(openStartingPoint);
				}
				
			}
		};
		timer.start();
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();
	}
    


}