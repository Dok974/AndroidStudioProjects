package com.flash.intent_tp;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
private TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //Je récupére les infos de main activity par clef (salutation)
        String salutation =  getIntent().getStringExtra("resultat");

        textView = (TextView) findViewById(R.id.textView2);
        textView.setText(salutation);
    }
}
