package com.doranco;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.doranco.models.Pays;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Pays pays = (Pays)getIntent().getSerializableExtra("pays");
        updatePaysView(pays);

    }

private void updatePaysView(Pays pays){
    TextView textViewID =findViewById(R.id.textViewDetailsID);
    TextView textViewPays =findViewById(R.id.textViewDetailsPays);
    TextView textViewContinent =findViewById(R.id.textViewDetailsContinent);

    textViewID.setText(String.valueOf(pays.getId()));
    textViewPays.setText(pays.getNom());
    textViewContinent.setText(pays.getContinent());
    }
}

