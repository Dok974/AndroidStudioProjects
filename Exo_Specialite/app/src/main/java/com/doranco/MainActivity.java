package com.doranco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.doranco.adapters.SpecialiteAdapter;
import com.doranco.models.Specialite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Specialite> specialiteList = new ArrayList<>();
    private Button addspecialite;
    private EditText specialite;
    private EditText description;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Specialite specialite1 = new Specialite(1, "Europe","France");
        Specialite specialite2 = new Specialite(2, "Asie","Japon");
        Specialite specialite3 = new Specialite(3, "Afrique", "Ethiopie");

        specialite=(EditText) findViewById(R.id.editTextSpecialite);
        description=(EditText) findViewById(R.id.editTextDescription);
        addspecialite=(Button) findViewById(R.id.button);

        addspecialite.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                 addSpecialiteToList();
                 return true;
            }
        });
            specialiteList = Arrays.asList(specialite1, specialite2, specialite3);
        /*specialiteList.addAll(Arrays.asList(specialite1, specialite2, specialite3));*/
        //Creation et initialisation du recyclerView
        RecyclerView recyclerViewSpecialite = findViewById(R.id.recyclerViewSpecialite);

        recyclerViewSpecialite.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewSpecialite.setHasFixedSize(true);

        SpecialiteAdapter adapter =new SpecialiteAdapter(specialiteList);

        recyclerViewSpecialite.setAdapter(adapter);
    }
    /**
     *
     */
    private void addSpecialiteToList(){

        specialite.getText();
        description.getText();
        try {

            specialiteList.add(new Specialite(specialite, description));
        }catch(Exception ex){
            Log.d("Erreur : ", "Impossible : " + ex);
        }


    }
}