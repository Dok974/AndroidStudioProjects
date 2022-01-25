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
import com.example.projetrecette.database.FormationDataBase_Impl;
import com.example.projetrecette.entities.Utilisateur;

public class UtilisateurAddFragment extends Fragment {

    public UtilisateurAddFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_utilisateur_add, container, false);

        TextView nom = view.findViewById(R.id.editTextTextPersonName);
        TextView prenom = view.findViewById(R.id.editTextTextPersonName2);

        Button button = view.findViewById(R.id.adduserbutton);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utilisateur utilisateur = new Utilisateur(String.valueOf(nom.getText()), String.valueOf(prenom.getText()));
                FormationDataBase dataBase = FormationDataBase.getInstance(getContext());
                dataBase.utilisateurDao().createUtilisateur(utilisateur);
                Toast.makeText(getContext(), "ajout efectué", Toast.LENGTH_SHORT).show();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, new UtilisateursFragment())
                        .commit();
            }
        });


        return view;

    }
}
