package com.doranco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.doranco.adapters.UtilisateurAdapter;
import com.doranco.models.Utilisateur;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Creation des utilisateurs
        Utilisateur utilisateur1 = new Utilisateur(1, "Biggie","Corentin",0102030405,"France","25/09/98","Homme");
        Utilisateur utilisateur2 = new Utilisateur(2, "Rock","Corentin",0102030405, "Ethiopie", "02/62/12","Ornithorinque");
        Utilisateur utilisateur3 = new Utilisateur(3, "DD", "Corentin",0102030405,"USA", "19/02/01", "Binaire");
        //Implémente les utilisateurs dans la liste
        List<Utilisateur> utilisateurList = Arrays.asList(utilisateur1, utilisateur2, utilisateur3);

        RecyclerView recyclerViewUtilisateur = findViewById(R.id.recyclerViewUtilisateur);

        recyclerViewUtilisateur.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewUtilisateur.setHasFixedSize(true);

        UtilisateurAdapter adapter =new UtilisateurAdapter(utilisateurList);

        recyclerViewUtilisateur.setAdapter(adapter);
    }
}