package com.doranco.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listViewNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Creation d'une liste de noms
        List<String> listNames = Arrays.asList("Corentin", "Wills", "Ali","Samuel", "Agnieszka");
        //Initialisation du list view
        listViewNames = findViewById(R.id.listViewNames);
        //Creation d'un tableau adaptateur
        ArrayAdapter<String> arrayAdapterNames = new ArrayAdapter<>(this,
            android.R.layout.simple_list_item_1, listNames);
        //definition de l'adaptateur dans le list view
        listViewNames.setAdapter(arrayAdapterNames);
        //Ecoute d'un item de la liste
        listViewNames.setOnItemClickListener((adapterView, view, i, l) -> {
                Toast.makeText(view.getContext(),
                        "nom : " + adapterView.getItemAtPosition(i),
        Toast.LENGTH_LONG).show();
        });
    }
}