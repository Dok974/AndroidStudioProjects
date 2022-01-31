package com.example.projetrecette.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetrecette.R;
import com.example.projetrecette.database.FormationDataBase;
import com.example.projetrecette.entities.Utilisateur;


public class UtilisateurAddFragment extends Fragment {


    public UtilisateurAddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_utilisateur_add, container, false);


        //Pour ajouter un utilisateur, on récup les infos, on créé un profil et on l'ajoute
        TextView textViewNom = view.findViewById(R.id.editTextTextUtilisateurNom);
        TextView textViewPrenom = view.findViewById(R.id.editTextTextUtilisateurPrenom);

        //Création d'un bouton
        Button button = view.findViewById(R.id.btnUtilisateurUpdate);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utilisateur utilisateur = new Utilisateur(String.valueOf(textViewNom.getText()), String.valueOf(textViewPrenom.getText()));

                //instanciation de la BD
                FormationDataBase formationDataBase = FormationDataBase.getInstance(getContext());

                //Création de l'utilisateur
                formationDataBase.utilisateurDao().createUtilisateur(utilisateur);

                //Message de confirmation
                Toast.makeText(getContext(), "Utilisateur ajouté avec succès", Toast.LENGTH_SHORT).show();

                //Retour au fragment qui affiche la liste des utilisateurs
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, new UtilisateursFragment())
                        .commit();
            }
        });

        return view;
    }
}