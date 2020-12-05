package com.example.schoolmot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.gesture.GestureOverlayView;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class monitoringActivity extends AppCompatActivity {
    myRecycleViewAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monitoring);

        Spinner timeDropDown = findViewById(R.id.timeDropDown);
        String[] items = new String[]{"1","2","3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,items);
        timeDropDown.setAdapter(adapter);

        ArrayList<String> myData = new ArrayList<>();
        myData.add("1");
        myData.add("2");
        myData.add("3");
        myData.add("4");
        myData.add("5");

        RecyclerView recyclerView = findViewById(R.id.myRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        myAdapter = new myRecycleViewAdapter(this, myData);
//        myAdapter.setClickListener((myRecycleViewAdapter.ItemClickListener) this);
//        recyclerView.setAdapter(myAdapter);


//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), );
//        recyclerView.addItemDecoration(dividerItemDecoration);
    }
//    public void onItemClick(View view, int position){
//        Toast.makeText(this,"You have clicked" + myAdapter.getItem(position)+ " on row number " + position, Toast.LENGTH_SHORT).show();
//    }
}