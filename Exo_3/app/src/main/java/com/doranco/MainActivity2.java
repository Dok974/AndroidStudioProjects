package com.doranco;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.doranco.models.Ordinateur;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_ordinateur2);

        Ordinateur ordinateur = (Ordinateur) getIntent().getSerializableExtra("ordinateur");
        updateOrdinateurView(ordinateur);

    }
    private void updateOrdinateurView(Ordinateur ordinateur){
        TextView textViewID = findViewById(R.id.textViewID2);
        TextView textViewMarque = findViewById(R.id.textViewMarque);
        TextView textViewAnnee = findViewById(R.id.textViewAnneedeFabrication);
        TextView textViewNum = findViewById(R.id.textViewNumeroSerie);
        TextView textViewPublic = findViewById(R.id.textViewPublic);
        TextView textViewClavier = findViewById(R.id.textViewPublicClavier);

        textViewID.setText(String.valueOf(ordinateur.getId()));
        textViewMarque.setText(ordinateur.getMarque());
        textViewAnnee.setText(String.valueOf(ordinateur.getAnneeDeFabrication()));
        textViewNum.setText(ordinateur.getNumSerie());
        textViewPublic.setText(ordinateur.getPublicViser());
        textViewClavier.setText(ordinateur.getTypeClavier());

    }
}
