package com.example.projetrecette.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.projetrecette.R;
import com.example.projetrecette.database.FormationDataBase;
import com.example.projetrecette.entities.Recette;

public class RecetteAddFragment extends Fragment {

    public RecetteAddFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recette_add, container, false);

        TextView nom = view.findViewById(R.id.editTextTextLibelleName);
        TextView prenom = view.findViewById(R.id.editTextTextLibelleName2);

        Button button = view.findViewById(R.id.addrecettebutton);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Recette recette = new Recette(String.valueOf(nom.getText()), String.valueOf(prenom.getText()));
                FormationDataBase dataBase = FormationDataBase.getInstance(getContext());
                dataBase.recetteDao().createRecette(recette);
                Toast.makeText(getContext(), "ajout efectué", Toast.LENGTH_SHORT).show();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, new RecettesFragment())
                        .commit();
            }
        });
        return view;
    }
}