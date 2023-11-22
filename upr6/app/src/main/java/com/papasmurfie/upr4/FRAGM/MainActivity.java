package com.papasmurfie.upr4.FRAGM;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.papasmurfie.upr4.R;

public class MainActivity extends AppCompatActivity implements AddCardListener{

    private static final String FRAGMENT = "fragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addCard = findViewById(R.id.button2);
        addCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                BirthdayDialogFragment dialogFragment = BirthdayDialogFragment.newInstance();
                dialogFragment.show(fragmentManager, "dialog_fragment");
            }
        });

        Button removeCard = findViewById(R.id.button);
        removeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                BirthdayCardFragment birthdayCardFragment =
                        (BirthdayCardFragment)getSupportFragmentManager().findFragmentByTag(FRAGMENT);
                if(birthdayCardFragment != null)
                {
                    fragmentTransaction.remove(birthdayCardFragment);
                    fragmentTransaction.commit();
                }
            }
        });

    }

    @Override
    public void onFinishAddCard(BirthdayCard card) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.frameLayout, BirthdayCardFragment.newInstance(card), FRAGMENT);
        ft.commit();
    }
}