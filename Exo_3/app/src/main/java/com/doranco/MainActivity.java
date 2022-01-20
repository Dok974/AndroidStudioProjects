package com.doranco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.doranco.adapters.ComputerAdapter;
import com.doranco.models.Ordinateur;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Ordinateur cp1 = new Ordinateur(1, 1996,"Apple", "1234","25-45","qwerty");
        Ordinateur cp2 = new Ordinateur(2, 1998, "Microsoft","5678","25-45","azerty");
        Ordinateur cp3 = new Ordinateur(3, 2002, "Asus","9101","39-45","qwerty");
        Ordinateur cp4 = new Ordinateur(4, 2004,"Corsair","1212","14-18","azerty");
        Ordinateur cp5 = new Ordinateur(5, 2010, "HP","2323","3-99","zarbi");

    List<Ordinateur> ordinateurList = Arrays.asList(cp1, cp2, cp3, cp4, cp5);
        //Creation et initialisation du recyclerView
        RecyclerView recyclerViewOrdinateurs = findViewById(R.id.recyclerViewOrdi);

        recyclerViewOrdinateurs.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewOrdinateurs.setHasFixedSize(true);

        ComputerAdapter adapter = new ComputerAdapter(ordinateurList);

        recyclerViewOrdinateurs.setAdapter(adapter);
    }
}