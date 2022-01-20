package com.doranco;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.doranco.models.Specialite;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Specialite specialite = (Specialite)getIntent().getSerializableExtra("specialite");
        updateSpeciliateView(specialite);

    }

    private void updateSpeciliateView(Specialite specialite){
        TextView textViewID =findViewById(R.id.textViewDetailsID);
        TextView textViewSpeciliate =findViewById(R.id.textViewDetailsSpecialite);
        TextView textViewDescription =findViewById(R.id.textViewDetailsDescription);

        textViewID.setText(String.valueOf(specialite.getId()));
        textViewSpeciliate.setText(specialite.getSpecialite());
        textViewDescription.setText(specialite.getDescription());
    }
}
