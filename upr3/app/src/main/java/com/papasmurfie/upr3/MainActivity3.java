package com.papasmurfie.upr3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        Intent intent = getIntent();

        People people = intent.getParcelableExtra("key_people" , People.class);
        TextView tvDisplay = findViewById(R.id.a3_TextView);
        tvDisplay.setText(people.toString());

        Button btnFinish = findViewById(R.id.a3_finishBtn);
        btnFinish.setOnClickListener(view -> finishAndRemoveTask());
    }
}