package com.doranco;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.doranco.models.Utilisateur;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Utilisateur utilisateur = (Utilisateur) getIntent().getSerializableExtra("utilisateur");
        updateUtilisateurView(utilisateur);

        TextView textViewClick = findViewById(R.id.textViewDetailsNom);
        textViewClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(view.getContext())
                        .setTitle("Infos sur vous")
                        .setMessage("Salut :" + utilisateur.getPrenom() + "Ceci est un AlertBox")
                        .show();
            }

        });

    }

    private void updateUtilisateurView(Utilisateur utilisateur) {
        TextView textViewID = findViewById(R.id.textViewDetailsID);
        TextView textViewNom = findViewById(R.id.textViewDetailsNom);
        TextView textViewPrenom = findViewById(R.id.textViewDetailsPrenom);
        TextView textViewPays = findViewById(R.id.textViewDetailsPays);
        TextView textViewTelephone = findViewById(R.id.textViewDetailsTelephone);
        TextView textViewDate = findViewById(R.id.textViewDetailsDate);
        TextView textViewSexe = findViewById(R.id.ttextViewDetailsSexe);


        textViewID.setText(String.valueOf(utilisateur.getId()));
        textViewNom.setText(utilisateur.getNom());
        textViewPrenom.setText(utilisateur.getPrenom());
        textViewPays.setText(utilisateur.getPays());
        textViewTelephone.setText(String.valueOf(utilisateur.getTelephone()));
        textViewDate.setText(utilisateur.getDateDeNaissance());
        textViewSexe.setText(utilisateur.getSexe());


    }
}

