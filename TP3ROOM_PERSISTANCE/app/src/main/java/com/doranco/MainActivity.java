package com.doranco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.doranco.database.UtilisateurDatabase;
import com.doranco.models.Utilisateur;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Utilisateur user = new Utilisateur("Prenom", "Nom");

        UtilisateurDatabase utilisateurDatabase = UtilisateurDatabase.getInstance(this);

        utilisateurDatabase.utilisateurDao().createUtilisateur(user);

        List<Utilisateur> utilisateurs = utilisateurDatabase.utilisateurDao().getAllUtilisateurs();

        Log.v("room database", utilisateurs.toString());
    }
}