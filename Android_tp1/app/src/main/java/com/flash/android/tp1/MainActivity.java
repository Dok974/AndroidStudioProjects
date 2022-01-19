package com.flash.android.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView1 = findViewById(R.id.textView1);
        textView1.setText("YOOOOOOOO");

        Log.i("activity started","onCreate appellee");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("activity started","onStart appellee");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("activity Paused","onPause appellee");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("activity Stoped","onStop appellee");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("activity Resumed","onResume appellee");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("activity Restarted","onRestart appellee");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("activity Destroyed","onDestroy appellee");

    }
}