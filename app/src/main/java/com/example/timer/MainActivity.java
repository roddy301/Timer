/*Mobile Computing lab-4 Banner ID: - B00826991 Name: - Rudra Makwana*/

package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    public static final String MESSAGE_MINUTES = "MINUTES";
    public static final String MESSAGE_SECONDS = "SECONDS";

    private Button btnTimerActivity;
    private Spinner spinnerMinutes, spinnerSeconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTimerActivity = findViewById(R.id.btnTimerActivity);
        spinnerMinutes = findViewById(R.id.spinnerMinutes);
        spinnerSeconds = findViewById(R.id.spinnerSeconds);

        ArrayAdapter<CharSequence> minuteAdapter =
                ArrayAdapter.createFromResource(this,R.array.minutes_array, R.layout.spinner_item);

        minuteAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

        spinnerMinutes.setAdapter(minuteAdapter);

        ArrayAdapter<CharSequence> secondAdapter =
                ArrayAdapter.createFromResource(this,R.array.seconds_array, R.layout.spinner_item);

        secondAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

        spinnerSeconds.setAdapter(secondAdapter);

        btnTimerActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),TimerActivity.class);
                intent.putExtra(MESSAGE_MINUTES,spinnerMinutes.getSelectedItem().toString());
                intent.putExtra(MESSAGE_SECONDS,spinnerSeconds.getSelectedItem().toString());

                startActivity(intent);
            }
        });
    }
}
