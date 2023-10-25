package com.papasmurfie.upr3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String a1_name = intent.getStringExtra("key_name");

        TextView tvName = findViewById(R.id.a2_nameField);
        tvName.setText(a1_name);

    Button bntNext = findViewById(R.id.a2_nextBtn);
    bntNext.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText etYears = findViewById(R.id.a2_Years);
            EditText etAddress = findViewById(R.id.a2_address);
            EditText etCity = findViewById(R.id.a2_city);
            People people = new People(a1_name, Integer.parseInt(etYears.getText().toString()),
                    etCity.getText().toString(),
                    etAddress.getText().toString()
                    );
            Intent intentA3 = new Intent(MainActivity2.this, MainActivity3.class);
            intentA3.putExtra("key_people", people);

            startActivity(intentA3);
        }
    });

        Button btnBack = findViewById(R.id.a2_backBtn);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}