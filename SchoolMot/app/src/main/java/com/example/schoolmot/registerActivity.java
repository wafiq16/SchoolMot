package com.example.schoolmot;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.text.BreakIterator;
import java.util.HashMap;

public class registerActivity extends AppCompatActivity implements View.OnClickListener{
    Button toSubmit;// = findViewById(R.id.buttonSubmit);
    Button toCancel; // = findViewById(R.id.buttonCancel);
    EditText idAlat; // =  (EditText) findViewById(R.id.idAlat);
    EditText namaSiswa; // =  (EditText) findViewById(R.id.namaSiswa);
    EditText nrpSiswa; // =  (EditText) findViewById(R.id.nrpSiswa);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        toSubmit = findViewById(R.id.buttonSubmit);
        toCancel = findViewById(R.id.buttonCancel);
        idAlat =  (EditText) findViewById(R.id.idAlat);
        namaSiswa =  (EditText) findViewById(R.id.namaSiswa);
        nrpSiswa =  (EditText) findViewById(R.id.nrpSiswa);
        toSubmit.setOnClickListener(this);
        toCancel.setOnClickListener(this);
    }

    private void submit() {
        final String nama = namaSiswa.getText().toString().trim();
        final String nrp = nrpSiswa.getText().toString().trim();
        final String alat = idAlat.getText().toString().trim();

        class Tambah extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(registerActivity.this,"Menambahkan ...", "Tunggu ... ",false,false);
            }

            @Override
            protected void onPostExecute(String s){
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(registerActivity.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... voids) {
                HashMap<String,String> params = new HashMap<>();
                params.put(konfigurasi.KEY_NAMA,nama);
                params.put(konfigurasi.KEY_NRP,nrp);
                params.put(konfigurasi.KEY_IDALAT,alat);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(konfigurasi.URL_ADD,params);
                return res;
            }
        }
        Tambah myTambah = new Tambah();
        myTambah.execute();
    }

    @Override
    public void onClick(View view) {
        if(view == toSubmit){
            submit();
        }
        if(view == toCancel){
            startActivity(new Intent(this,MainActivity.class));
        }
    }
}

