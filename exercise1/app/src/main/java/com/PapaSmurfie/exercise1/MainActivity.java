package com.PapaSmurfie.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);
        Picasso.get().load("https://scontent-sof1-1.xx.fbcdn.net/v/t1.6435-9/119525906_3591048937595937_473643826064740252_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=e8hLKGRG4C4AX9zLq3B&_nc_ht=scontent-sof1-1.xx&oh=00_AfCubv3EJ0ZUJF4YwqNMm_16m-BTQVjlh0lcbZ2ZVonx7Q&oe=65447657").into(imageView);
    }


}