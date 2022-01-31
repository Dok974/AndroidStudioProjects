package com.example.projetrecette.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetrecette.R;
import com.example.projetrecette.adapters.RecetteAdapter;
import com.example.projetrecette.database.FormationDataBase;
import com.example.projetrecette.entities.Recette;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecettesFragment} factory method to
 * create an instance of this fragment.
 */
public class RecettesFragment extends Fragment {

    public RecettesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recettes, container, false);

        FormationDataBase formationDatabase = FormationDataBase.getInstance(getContext());

        List<Recette> recettes = formationDatabase.recetteDao().getAllRecettes();

        RecyclerView recyclerViewRecettes = view.findViewById(R.id.recyclerViewRecette);
        FloatingActionButton floatingActionButton = view.findViewById(R.id.addRecetteActionButton);

        recyclerViewRecettes.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewRecettes.setHasFixedSize(true);

        RecetteAdapter recetteAdapter = new RecetteAdapter(recettes);

        recyclerViewRecettes.setAdapter(recetteAdapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, new RecetteAddFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }

}