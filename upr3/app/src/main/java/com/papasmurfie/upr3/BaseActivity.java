package com.papasmurfie.upr3;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    protected String ActivityName;
    public String getActivityName(){
        return ActivityName;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("TAG:", "This is onStart() from activity: " + getActivityName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TAG:", "This is onResume() from activity: " + getActivityName());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TAG:", "This is onPause() from activity: " + getActivityName());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("TAG:", "This is onRestart() from activity: " + getActivityName());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TAG:", "This is onStop() from activity: " + getActivityName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TAG:", "This is onDestroy() from activity: " + getActivityName());
    }
}
