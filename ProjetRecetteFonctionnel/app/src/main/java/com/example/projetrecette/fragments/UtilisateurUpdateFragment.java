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


public class UtilisateurUpdateFragment extends Fragment {


    public UtilisateurUpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_utilisateur_update, container, false);

        Toast.makeText(getContext(), "Bundle : " + getArguments().getString("nom") + getArguments().getString("prenom"), Toast.LENGTH_LONG).show();

        String nomAModifier = getArguments().getString("nom");
        String prenomAModifier = getArguments().getString("prenom");
        Integer id = getArguments().getInt("id");



        TextView textViewUpdateNom = view.findViewById(R.id.editTextTextUtilisateurNomUpdate);
        TextView textViewUpdatePrenom = view.findViewById(R.id.editTextTextUtilisateurPrenomUpdate);

        textViewUpdateNom.setText(nomAModifier);
        textViewUpdatePrenom.setText(prenomAModifier);

        //Ici, récupérer les données de l'utilisateur envoyées depuis UtilisateursFragment
        //Les afficher dans des textView (plaintext) pour pouvoir les modifier
        //faire appel à la fonction updateUtilisate
//Création d'un bouton
        Button button = view.findViewById(R.id.btnUtilisateurUpdate);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utilisateur utilisateur = new Utilisateur(String.valueOf(textViewUpdateNom.getText()), String.valueOf(textViewUpdatePrenom.getText()));

                String userfname = (String.valueOf(textViewUpdateNom.getText()));
                String username = (String.valueOf(textViewUpdatePrenom.getText()));
                //instanciation de la BD
                FormationDataBase formationDataBase = FormationDataBase.getInstance(getContext());

                //Création de l'utilisateur
                formationDataBase.utilisateurDao().updateUser(username, userfname, id);

                //Message de confirmation
                Toast.makeText(getContext(), "Utilisateur ajouté avec succès", Toast.LENGTH_SHORT).show();

                //Retour au fragment qui affiche la liste des utilisateurs
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, new UtilisateursFragment())
                        .commit();
            }
        });

        //Ici, récupérer les données de l'utilisateur envoyées depuis UtilisateursFragment
        //Les afficher dans des textView (plaintext) pour pouvoir les modifier
        //faire appel à la fonction updateUtilisateur()

        //instanciation de la BD
        //FormationDataBase formationDataBase = FormationDataBase.getInstance(getContext());

        //Création de l'utilisateur
        //formationDataBase.utilisateurDao().updateUtilisateur(utilisateur);


        return view;

    }
}