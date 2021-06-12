package com.amna.assignment2_lab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import Adapter.RecyclerViewAdapter;
import Model.ContactInfo;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    LinearLayoutManager layoutManager;
    List<ContactInfo> infoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        recyclerView=findViewById(R.id.rv_names);
        infoList.add(new ContactInfo(R.drawable.l1, "Lina", "Lol Okay", "6:20 pm"));
        infoList.add(new ContactInfo(R.drawable.f1, "Fatima", "Kindly connect", "Yesterday"));
        infoList.add(new ContactInfo(R.drawable.m1, "Mohid", "Have a wonderful day", "4:52 pm"));
        infoList.add(new ContactInfo(R.drawable.ab1, "Abirah", "Okaay", "4:23 pm"));
        infoList.add(new ContactInfo(R.drawable.s1, "Salman", "Check Mail?", "6/9/21"));
        infoList.add(new ContactInfo(R.drawable.a1, "Ahmed", "No problem", "Yesterday"));

        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, infoList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);
    }

}
