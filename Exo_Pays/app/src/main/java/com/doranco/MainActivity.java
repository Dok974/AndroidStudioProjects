package com.doranco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.doranco.adapters.PaysAdapter;
import com.doranco.models.Pays;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Pays pays1 = new Pays(1, "Europe","France");
        Pays pays2 = new Pays(2, "Asie","Japon");
        Pays pays3 = new Pays(3, "Afrique", "Ethiopie");

        List<Pays> paysList = Arrays.asList(pays1, pays2, pays3);
        //Creation et initialisation du recyclerView
        RecyclerView recyclerViewPays = findViewById(R.id.recyclerViewPays);

        recyclerViewPays.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewPays.setHasFixedSize(true);

        PaysAdapter adapter =new PaysAdapter(paysList);

        recyclerViewPays.setAdapter(adapter);

    }
}