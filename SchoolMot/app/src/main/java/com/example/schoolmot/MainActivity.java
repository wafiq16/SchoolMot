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
        getSupportActionBar().hide();

    }

    public void buttonRegister(View view) {
        Intent intent = new Intent(this, registerActivity.class);
        startActivity(intent);
    }

    public void buttonMonitoring(View view) {
        Intent intent = new Intent(this, monitoringActivity.class);
        startActivity(intent);
    }

    public void buttonTutorial(View view) {
        Intent intent = new Intent(this, TutorialActivity.class);
        startActivity(intent);
    }

    public void buttonRules(View view) {
        Intent intent = new Intent(this, ruleActivity.class);
        startActivity(intent);
    }

}