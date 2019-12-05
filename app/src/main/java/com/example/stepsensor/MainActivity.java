package com.example.stepsensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text;
    SensorManager sensorManager;
    Sensor sensor;
    public int steps = 0;
    String stepsFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        sensorManager.registerListener(sense, sensor, SensorManager.SENSOR_DELAY_FASTEST);


    }

    SensorEventListener sense = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {

            Sensor sensor = event.sensor;
            float[] values = event.values;
            Integer value = -1;

            if (values.length > 0) {
                value = (int)values[0];
            }
            if (sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
                steps++;
                stepsFinal= Integer.toString(steps);
                text.setText(stepsFinal);

                Toast.makeText(MainActivity.this,"Hello",Toast.LENGTH_SHORT).show();

            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }


    };
}





