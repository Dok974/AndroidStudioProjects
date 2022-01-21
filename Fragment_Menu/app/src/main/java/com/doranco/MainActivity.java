package com.doranco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.doranco.frag.Fragment1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment1 fragment1 = new Fragment1();

        if(savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragmentContainerView, null)
                    .commit();
        }
    }
}