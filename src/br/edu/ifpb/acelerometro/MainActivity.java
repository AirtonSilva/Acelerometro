package br.edu.ifpb.acelerometro;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.hardware.*;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {

	private TextView xText, yText, zText;
	private Sensor sensor;
	private SensorManager sensorManager;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, sensor,SensorManager.SENSOR_DELAY_NORMAL);
        
        xText = (TextView)findViewById(R.id.xText);
        yText = (TextView)findViewById(R.id.yText);
        zText = (TextView)findViewById(R.id.zText);
    }

	@Override
	public void onSensorChanged(SensorEvent event) {
		
		xText.setText("X: "+ event.values[0]);
		yText.setText("Y: "+ event.values[1]);
		zText.setText("Z: "+ event.values[2]);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		
	}
}
