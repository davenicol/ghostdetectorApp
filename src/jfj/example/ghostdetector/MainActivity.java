package jfj.example.ghostdetector;
//bacon

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Go to Accelerometer		
		Button accelButton = (Button) findViewById(R.id.btnAcc);
		accelButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				Intent gallery = new Intent(MainActivity.this, Accell.class);
				startActivity(gallery);	
			}
			
		});
		
		//Go to to MF Sensor
		Button magnetButton = (Button) findViewById(R.id.btnMagnet);
		magnetButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				Intent gallery = new Intent(MainActivity.this, MagneticField.class);
				startActivity(gallery);	
			}
			
		});
		
		//Go to GhostTalk
		Button talkButton = (Button) findViewById(R.id.btnSearch);
		talkButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				Intent gallery = new Intent(MainActivity.this, GhostTalk.class);
				startActivity(gallery);	
			}
			
		});
		
		//Go to Map
		Button mapButton = (Button) findViewById(R.id.btnMap);
		mapButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				Intent gallery = new Intent(MainActivity.this, Map.class);
				startActivity(gallery);	
			}
			
		});
		
		//Go to About details
		Button aboutButton = (Button) findViewById(R.id.btnAbout);
		aboutButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				Intent gallery = new Intent(MainActivity.this, About.class);
				startActivity(gallery);	
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