package com.doranco.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.doranco.MainActivity2;
import com.doranco.MainActivity2;
import com.doranco.R;
import com.doranco.models.Utilisateur;

import java.util.List;

public class UtilisateurAdapter extends RecyclerView.Adapter<UtilisateurAdapter.UtilisateurViewHolder> {
private final List<Utilisateur> utilisateurList;

    public UtilisateurAdapter(List<Utilisateur> utilisateurList) {
        this.utilisateurList = utilisateurList;
    }

    @NonNull
    @Override
    public UtilisateurViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_utilisateur,parent,false);

        return new UtilisateurViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UtilisateurViewHolder holder, int position) {
        Utilisateur utilisateur =utilisateurList.get(position);

        holder.nom.setText(utilisateur.getNom());
        holder.prenom.setText(utilisateur.getPrenom());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity2.class);
                intent.putExtra("utilisateur", utilisateur);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return utilisateurList.size();
    }

    public class UtilisateurViewHolder extends RecyclerView.ViewHolder{
        public TextView nom;
        public TextView prenom;



        public UtilisateurViewHolder(@NonNull View itemView) {
            super(itemView);
        nom = itemView.findViewById(R.id.textViewNom);
        prenom = itemView.findViewById(R.id.textViewPrenom);
        }
    }
}
