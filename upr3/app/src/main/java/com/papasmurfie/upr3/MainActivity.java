package com.papasmurfie.upr3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText etName = findViewById(R.id.editNameText);
        etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() < 5)
                {
                    etName.setError(getText(R.string.errorNumberSymbols));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        Button btnGoTo2 = findViewById(R.id.actMainButton);
        btnGoTo2.setOnClickListener(view -> {
            if(etName.getError() == null)
            {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("key_name",etName.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}