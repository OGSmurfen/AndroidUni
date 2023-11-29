package com.papasmurfie.upr7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    List<Vegetable> shopData;
    RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView2);
        FloatingActionButton button = findViewById(R.id.floatingActionButton);
        button.setOnClickListener(this);

        shopData = DataGenerator.generateList(50);

        adapter = new RecyclerAdapter(shopData);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onClick(View view) {
        for(Vegetable v : shopData){
            v.setPrice(new Random().nextInt()%99);
        }
        adapter.notifyDataSetChanged();
    }
}