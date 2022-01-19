package com.doranco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.doranco.adapters.PersonAdapter;
import com.doranco.models.Personne;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Personne person1 = new Personne("William", "Wills", "10/10/1990");
        Personne person2 = new Personne("James", "Roy", "10/12/1995");
        Personne person3 = new Personne("John", "Doe", "1/5/2001");
        Personne person4 = new Personne("Jane", "Doe", "22/03/1999");
        Personne person5 = new Personne("Marie", "Paul", "10/6/2017");

        List<Personne> listPeople = Arrays.asList(person1,person2,person3,person4,person5);
        ListView listViewPeople = findViewById(R.id.listViewPerson);

        PersonAdapter personAdapter = new PersonAdapter(this,R.layout.item_personne,listPeople);

        listViewPeople.setAdapter(personAdapter);
    }
}