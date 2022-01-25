package com.example.projetrecette.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projetrecette.R;
import com.example.projetrecette.adapters.UtilisateurAdapter;
import com.example.projetrecette.database.FormationDataBase;
import com.example.projetrecette.entities.Utilisateur;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UtilisateursFragment} factory method to
 * create an instance of this fragment.
 */
public class UtilisateursFragment extends Fragment {

    public UtilisateursFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_utilisateurs, container, false);

        FormationDataBase formationDatabase = FormationDataBase.getInstance(getContext());

        List<Utilisateur> utilisateurs = formationDatabase.utilisateurDao().getAllUtilisateurs();

        RecyclerView recyclerViewUtilisateurs = view.findViewById(R.id.recyclerViewPeople);
        FloatingActionButton floatingActionButton = view.findViewById(R.id.floatingActionButton);

        recyclerViewUtilisateurs.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewUtilisateurs.setHasFixedSize(true);

        UtilisateurAdapter utilisateurAdapter = new UtilisateurAdapter(utilisateurs);

        recyclerViewUtilisateurs.setAdapter(utilisateurAdapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, new UtilisateurAddFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }
}