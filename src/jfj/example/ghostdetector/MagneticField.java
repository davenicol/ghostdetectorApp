package jfj.example.ghostdetector;

//CODE TAKEN FROM - http://developer.samsung.com/android/technical-docs/Sensors-in-Android

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;

public class MagneticField extends Activity implements
		SensorEventListener {

	//Create vars - geoMagnetic Float requires initial numbers on first draw. If null system may crash - Could add a try later instead
	private float azimut;
	private float[] gravity;
	private float[] geoMagnetic = {1,1,1};
	private CompassView drawableView;
	private SensorManager mSensorManager;
	private Sensor accSensor;
	private Sensor magnetSensor;
	

	public class CompassView extends View {
		Paint paint = new Paint();

		public CompassView(Context context) {
			super(context);
			paint.setColor(Color.BLACK);
			/* Set Anitalias */
			paint.setAntiAlias(true);
			paint.setTextSize(60f);
		};

		protected void onDraw(Canvas canvas) {
			/* Get Width and Height of the canvas */
			int width = getWidth();
			int height = getHeight();
			/* Get center point of the canvas */
			int centerx = width / 2;
			int centery = height / 2;
			
			//New Vars to look through the geoMag Array
			float geoMagx = geoMagnetic[0];
			float geoMagz = geoMagnetic[1];
			float geoMagY = geoMagnetic[2];
			double magAbsVal;
			
			paint.setColor(Color.rgb(47, 0, 13));
			canvas.drawRect(0, 0, width, height, paint);
			
			paint.setColor(Color.BLACK);
			canvas.drawCircle(centerx-210,centery-130,40,paint);
			canvas.drawCircle(centerx-150,centery-200,40,paint);
			canvas.drawCircle(centerx-50,centery-250,40,paint);
			canvas.drawCircle(centerx+50,centery-250,40,paint);
			canvas.drawCircle(centerx+150,centery-200,40,paint);
			canvas.drawCircle(centerx+210,centery-130,40,paint);
			
			
			//Calculate total magnetic field
			magAbsVal = Math.sqrt(geoMagx*geoMagx + geoMagz*geoMagz + geoMagY*geoMagY);
			
			int i = (int) magAbsVal;
			
			//Build and draw colors if fields increase and decrease to alert user
			if(i >= 10)
			{
				paint.setColor(Color.GREEN);
				canvas.drawCircle(centerx-210,centery-130,40,paint);
			}
			
			if(i >= 70)
			{
				paint.setColor(Color.GREEN);
				canvas.drawCircle(centerx-150,centery-200,40,paint);
			}
			
			if(i >= 100)
			{
				paint.setColor(Color.YELLOW);
				canvas.drawCircle(centerx-50,centery-250,40,paint);
			}
			
			if(i >= 140)
			{
				paint.setColor(Color.YELLOW);
				canvas.drawCircle(centerx+50,centery-250,40,paint);
			}
			
			if(i >= 190)
			{
				paint.setColor(Color.RED);
				canvas.drawCircle(centerx+150,centery-200,40,paint);
			}
			
			if(i >= 230)
			{
				paint.setColor(Color.RED);
				canvas.drawCircle(centerx+210,centery-130,40,paint);
			}
			
			//Samsungs Compass - Left in as it can be helfpul. If North changes it could point to spirits
			paint.setColor(Color.rgb(0,123,14));
			canvas.drawRect(centerx-40,centery-410,centerx+85,centery-345,paint);
			paint.setColor(Color.rgb(149,78,60));
			canvas.drawText(Integer.toString(i), centerx-30, centery-350, paint);
			/* Rotate the canvas based on the angle using azimuth */
			canvas.rotate(-azimut * 360 / (2 * 3.14159f), centerx, centery);
			// draw north - south line
			canvas.drawLine(centerx, centery - 40, centerx, centery + 40,
					paint);
			// draw east - west line
			canvas.drawLine(centerx - 40, centery, centerx + 40, centery,
					paint);
			// draw names
			canvas.drawText("N", centerx + 10, centery - 100, paint);
			canvas.drawText("S", centerx + 10, centery + 100, paint);
			canvas.drawText("E", centerx + 100, centery - 15, paint);
			canvas.drawText("W", centerx - 150, centery - 15, paint);
		}
	}

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		drawableView = new CompassView(this);
		setContentView(drawableView); // Register the sensor listeners
		mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		accSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		magnetSensor = mSensorManager
				.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
	}

	protected void onResume() {
		super.onResume();
		mSensorManager.registerListener(this, accSensor,
				SensorManager.SENSOR_DELAY_UI);
		mSensorManager.registerListener(this, magnetSensor,
				SensorManager.SENSOR_DELAY_UI);
	}

	protected void onPause() {
		super.onPause();
		mSensorManager.unregisterListener(this);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
			gravity = event.values;
		if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD)
			geoMagnetic = event.values;
		if (gravity != null && geoMagnetic != null) {
			float R[] = new float[9];
			float I[] = new float[9];
			boolean success = SensorManager.getRotationMatrix(R, I, gravity,
					geoMagnetic);
			if (success) {
				/* Orientation has azimuth, pitch and roll */
				float orientation[] = new float[3];
				SensorManager.getOrientation(R, orientation);
				azimut = orientation[0];
			}
		}
		drawableView.invalidate();
	}

}

