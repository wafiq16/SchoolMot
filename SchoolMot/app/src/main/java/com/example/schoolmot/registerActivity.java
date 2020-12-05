package com.example.schoolmot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.text.BreakIterator;

public class registerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        Button toSubmit = findViewById(R.id.buttonSubmit);
        toSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText namaSiswa =  (EditText) findViewById(R.id.namaSiswa);
                String nama = (String) namaSiswa.getText().toString();

                EditText nrpSiswa =  (EditText) findViewById(R.id.nrpSiswa);
                String nrp = (String) nrpSiswa.getText().toString();

                EditText idAlat =  (EditText) findViewById(R.id.idAlat);
                String alat = (String) idAlat.getText().toString();
                submit(nama,nrp,alat);
            }
        });

        Button toCancel = findViewById(R.id.buttonCancel);
        toCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(backToMain);
            }
        });
    }
    void submit(String nama, String nrp, String id){

    }
}

