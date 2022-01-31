package com.example.projetrecette.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetrecette.R;
import com.example.projetrecette.entities.Recette;

import java.util.List;

public class RecetteAdapter extends RecyclerView.Adapter<RecetteAdapter.RecetteViewHolder> {
    private final List<Recette> listRecettes;

    public RecetteAdapter(List<Recette> listRecettes) {
        this.listRecettes = listRecettes;
    }

    @NonNull
    @Override
    public RecetteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_recycler_view_recette, parent, false);
        return  new RecetteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecetteViewHolder holder, int position) {
        Recette recette = this.listRecettes.get(position);
        String data = recette.getLibelle() + " " + recette.getDescription();
        holder.textViewLibelleDescription.setText(data);

    }

    @Override
    public int getItemCount() {
        return this.listRecettes.size();
    }

    public static class RecetteViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewLibelleDescription;
        public RecetteViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewLibelleDescription = itemView.findViewById(R.id.itemRecyclerViewRecette);
        }
    }
}