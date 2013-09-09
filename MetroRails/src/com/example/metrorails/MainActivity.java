package com.example.metrorails;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	CurrentPosition currentPosition;
	String address;
	String city;
	String country;
	String postalCode;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button refresh;
		refresh = (Button)findViewById(R.id.refresh);
		refresh.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				currentPosition = new CurrentPosition(MainActivity.this);
				TextView showresults = (TextView) findViewById(R.id.show_results);
				showresults.setTextSize(20);
				
				if(currentPosition.canGetLocation()){

	                double latitude = currentPosition.getLatitude();
	                double longitude = currentPosition.getLongitude();
	                showresults.setText("current latitude: "+latitude +"\n current longitude: "+longitude); 
	                		

	                
	                    
	            }else{
	                // can't get location
	                // GPS or Network is not enabled
	                // Ask user to enable GPS/network in settings
	            	currentPosition.showSettingsAlert();	
	            }				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
