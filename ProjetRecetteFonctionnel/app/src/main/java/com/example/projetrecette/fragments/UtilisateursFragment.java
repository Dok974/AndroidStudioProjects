package com.example.projetrecette.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.projetrecette.R;
import com.example.projetrecette.adapters.UtilisateurAdapter;
import com.example.projetrecette.database.FormationDataBase;
import com.example.projetrecette.entities.Utilisateur;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

/**
 * Interface : le truc est de faire que ce soit le fragment et non l'adapter
 * qui implemente l'interface, car l'adapter n'a pas les éléments pour cela,
 * alors que le fragment, si
 */
public class UtilisateursFragment extends Fragment implements UtilisateurAdapter.UtilisateurAdapterCallBack {


    public UtilisateursFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_utilisateurs, container, false);

        RecyclerView recyclerViewUtilisateurs = view.findViewById(R.id.recyclerViewUtilisateurs);
        FloatingActionButton floatingActionButton = view.findViewById(R.id.fabUtilisateurAdd);

        FormationDataBase formationDatabase = FormationDataBase.getInstance(getContext());

        //Génération de la liste
        List<Utilisateur> utilisateurs = formationDatabase.utilisateurDao().getAllUtilisateurs();

        //Affichage en log
        Log.v("Room database", utilisateurs.toString());

        recyclerViewUtilisateurs.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewUtilisateurs.setHasFixedSize(true);

        UtilisateurAdapter utilisateurAdapter = new UtilisateurAdapter(utilisateurs, getContext(), this);

        recyclerViewUtilisateurs.setAdapter(utilisateurAdapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Test
                //Toast.makeText(getContext(), "Clic du bouton", Toast.LENGTH_SHORT).show();

                //Permet de récupérer l'activité qui et en charge du fragment
                //Pour éviter de recourir deux fois à l'activité
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, new UtilisateurAddFragment())
                        .addToBackStack(null) //Permet d'ajouter le fragment dans la pile, ce qui permet de revenir en arrière à la liste
                        .commit();
            }
        });

        return view;
    }

    @Override
    public void onItemClickedModifier(Utilisateur utilisateur) {
        Toast.makeText(getContext(), "Modifier à partir du fragment Utilisateurs = " + utilisateur, Toast.LENGTH_LONG).show();

        UtilisateurUpdateFragment fragment = new UtilisateurUpdateFragment();
        Bundle bundle = new Bundle();
        bundle.putString("nom", String.valueOf(utilisateur.getNom()));
        bundle.putString("prenom", String.valueOf(utilisateur.getPrenom()));
        bundle.putInt("id", utilisateur.getId());

        fragment.setArguments(bundle);

            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout, fragment)
                    .addToBackStack(null)
                    .commit();

    }

    @Override
    public void onItemClickedSupprimer(Utilisateur utilisateur) {
        UtilisateurDeleteFragment fragment = new UtilisateurDeleteFragment();
        Bundle bundle = new Bundle();
        //instanciation de la BD
        FormationDataBase formationDataBase = FormationDataBase.getInstance(getContext());

        //Création de l'utilisateur
        formationDataBase.utilisateurDao().deleteUtilisateur(utilisateur);

        //Message de confirmation
        Toast.makeText(getContext(), "Utilisateur ajouté avec succès", Toast.LENGTH_SHORT).show();

        fragment.setArguments(bundle);
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, new UtilisateursFragment())
                .addToBackStack(null)
                .commit();
    }
}