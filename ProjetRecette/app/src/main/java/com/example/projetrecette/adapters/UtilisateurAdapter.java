package com.example.projetrecette.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetrecette.R;
import com.example.projetrecette.entities.Utilisateur;

import java.util.List;

public class UtilisateurAdapter extends RecyclerView.Adapter<UtilisateurAdapter.UtilisateurViewHolder> {
    private final List<Utilisateur> listUtilisateurs;

    public UtilisateurAdapter(List<Utilisateur> listUtilisateurs) {
        this.listUtilisateurs = listUtilisateurs;
    }

    @NonNull
    @Override
    public UtilisateurViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_recycler_view_utilisateur, parent, false);
        return  new UtilisateurViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UtilisateurViewHolder holder, int position) {
        Utilisateur utilisateur = this.listUtilisateurs.get(position);
        String data = utilisateur.getNom() + " " + utilisateur.getPrenom();
        holder.textViewNomPrenom.setText(data);

    }

    @Override
    public int getItemCount() {
        return this.listUtilisateurs.size();
    }

    public static class UtilisateurViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewNomPrenom;
        public UtilisateurViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewNomPrenom = itemView.findViewById(R.id.itemRecyclerViewUser);
        }
    }
}