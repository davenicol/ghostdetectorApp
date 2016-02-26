package jfj.example.ghostdetector;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

@SuppressLint("NewApi")
public class Map extends Activity {
	String mapLocation = "Hello" ;
	String mapSnipper = "Some Details";
	float lat = -3;
	float lon = 55;

    @SuppressLint("NewApi")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_layout);
        
        //Add marker to Map button
        Button updateButton = (Button) findViewById(R.id.btnAddDetails);
        updateButton.setOnClickListener(new OnClickListener (){
        	public void onClick(View v){
        		//Validation so only Float numbers can be added to Lon and Lat
        		try {
    			EditText textLocation = (EditText)findViewById(R.id.edtLocation);
    			mapLocation = textLocation.getText().toString();
    			
    			EditText textDetails = (EditText)findViewById(R.id.edtDetails);
    			mapSnipper = textDetails.getText().toString();
    			
    			
    			EditText floatLongitude = (EditText)findViewById(R.id.edtLong);
    			lon = Float.valueOf(floatLongitude.getText().toString());
    			
    			EditText floatLatitude = (EditText)findViewById(R.id.edtLat);
    			lat = Float.valueOf(floatLatitude.getText().toString());
    			
    			//Only Lon and Lat between -90 and 90 are allowed
    			if (lat >=-90 && lat <=90 && lon >=-90 && lon <=90) {
    			final GoogleMap mMap;
    			mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
    			mMap.addMarker(new MarkerOptions()
    			        .position(new LatLng(lat,lon))
    			        .title(mapLocation)
    			        .snippet(mapSnipper));
    			}
    			else
    			{
    				Toast.makeText(getBaseContext(), "Lonitude and Latitude can only be numbers bewteen -90 to 90 e.g 3.148", Toast.LENGTH_LONG).show();
    			}
        	}
        	catch (Exception e)
        	{
        		Toast.makeText(getBaseContext(), "Lonitude and Latitude can only be numbers bewteen -90 to 90 e.g 3.148", Toast.LENGTH_LONG).show();
        	}
        	}
        	
        });
    }
}