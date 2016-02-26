package jfj.example.ghostdetector;

//CODE SOURCE FROM - http://www.vogella.com/articles/AndroidSensor/article.html

import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Accell extends Activity implements SensorEventListener {
  private SensorManager sensorManager;
  private boolean color = false;
  private View view;
  private long lastUpdate;
  double movement = 1.15;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);

    super.onCreate(savedInstanceState);
    setContentView(R.layout.accell_layout);
    view = findViewById(R.id.textView);
    view.setBackgroundColor(Color.rgb(47,0,13));

    sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    lastUpdate = System.currentTimeMillis();
    
	Button increaseSenseButton = (Button) findViewById(R.id.btnIncrease);
	increaseSenseButton.setOnClickListener(new OnClickListener()
	{

		@Override
		public void onClick(View v) {
			movement = movement - 0.005;
		}
		
	});
	
	
	Button decreaseSenseButton = (Button) findViewById(R.id.btnDecrease);
	decreaseSenseButton.setOnClickListener(new OnClickListener()
	{

		@Override
		public void onClick(View v) {
			movement = movement + 0.005;
		}
		
	});
	
    
  }

  @Override
  public void onSensorChanged(SensorEvent event) {
    if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
      getAccelerometer(event);
    }

  }

  private void getAccelerometer(SensorEvent event) {
    float[] values = event.values;
    // Movement
    float x = values[0];
    float y = values[1];
    float z = values[2];

    float accelationSquareRoot = (x * x + y * y + z * z)
        / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
    long actualTime = System.currentTimeMillis();
    if (accelationSquareRoot >= movement) //
    {
      if (actualTime - lastUpdate < 200) {
        return;
      }
      lastUpdate = actualTime;
      if (color) {
        view.setBackgroundColor(Color.GREEN);

      } else {
        view.setBackgroundColor(Color.RED);
      }
      color = !color;
    }
  }

  @Override
  public void onAccuracyChanged(Sensor sensor, int accuracy) {

  }

  @Override
  protected void onResume() {
    super.onResume();
    // register this class as a listener for the orientation and
    // accelerometer sensors
    sensorManager.registerListener(this,
        sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
        SensorManager.SENSOR_DELAY_NORMAL);
  }

  @Override
  protected void onPause() {
    // unregister listener
    super.onPause();
    sensorManager.unregisterListener(this);
  }
} 

