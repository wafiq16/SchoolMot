package com.example.schoolmot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton toRegister = findViewById(R.id.buttonRegister);
        toRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityRegister = new Intent(getApplicationContext(), registerActivity.class);
                startActivity(activityRegister);
            }
        });
        ImageButton toMonitoring = findViewById(R.id.buttonMonitoring);
        toMonitoring.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view){
                Intent activityMonitoring = new Intent(getApplicationContext(), monitoringActivity.class);
                startActivity(activityMonitoring);
            }
        });

    }
}