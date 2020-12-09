package com.example.schoolmot;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.gesture.GestureOverlayView;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class monitoringActivity extends AppCompatActivity implements ListView.OnItemClickListener{
    Button buttonCall;// = findViewById(R.id.buttonSubmit);
    Button buttonCancel; // = findViewById(R.id.buttonCancel);

    private ListView listView;

    private String JSON_STRING;

    @RequiresApi(api = Build.VERSION_CODES.O)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monitoring);

        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        getJSON();

        buttonCall = findViewById(R.id.buttonCall);
        buttonCancel = findViewById(R.id.buttonCancel);

        String[] items = new String[]{"1","2","3","4","5","6","7"};
        Clock offsetClock = Clock.offset(Clock.systemUTC(), Duration.ofHours(+7));
        Instant now = Instant.now(offsetClock);
        for(int i=0; i<7; i++) {
            Instant myDate = now.minus(  3-i , ChronoUnit.DAYS);
            items [i] = myDate.toString().replaceAll("[TZ]", " ");
        }

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(activityMain);
            }
        });

        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent activityRegister = new Intent(getApplicationContext(), registerActivity.class);
//                startActivity(activityRegister);
            }
        });

    }
    private  void tampilkanData(){
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try{
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);

            for(int i=0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String id = jo.getString(konfigurasi.TAG_ID);
                String nama = jo.getString(konfigurasi.TAG_NAMA);
                String nrp = jo.getString(konfigurasi.TAG_NRP);
                String idAlat = jo.getString(konfigurasi.TAG_IDALAT);

                HashMap<String,String> myStudentData = new HashMap<>();
                myStudentData.put(konfigurasi.TAG_ID,id);
                myStudentData.put(konfigurasi.TAG_NAMA,nama);
                myStudentData.put(konfigurasi.TAG_NRP,nrp);
                myStudentData.put(konfigurasi.TAG_IDALAT,idAlat);
                list.add(myStudentData);
            }
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        ListAdapter adapter = new SimpleAdapter(
                monitoringActivity.this, list,R.layout.list,
                new String[]{konfigurasi.TAG_ID,konfigurasi.TAG_NAMA,
                konfigurasi.TAG_NRP,konfigurasi.TAG_IDALAT},
                new int[]{R.id.idSiswa,R.id.nama,R.id.nrp,R.id.idAlatSiswa}
        );
        listView.setAdapter(adapter);
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(monitoringActivity.this,"Mengambil Data","Mohon Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                tampilkanData();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}