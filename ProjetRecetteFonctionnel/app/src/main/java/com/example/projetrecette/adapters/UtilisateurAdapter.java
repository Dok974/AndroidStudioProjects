package com.example.projetrecette.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetrecette.R;
import com.example.projetrecette.entities.Utilisateur;

import java.util.List;

public class UtilisateurAdapter extends RecyclerView.Adapter<UtilisateurAdapter.UtilisateurViewHolder> {
    private final List<Utilisateur> listUtilisateurs;
    private final Context context;
    private final UtilisateurAdapterCallBack utilisateurAdapterCallBack;


    public UtilisateurAdapter(List<Utilisateur> listUtilisateurs, Context context, UtilisateurAdapterCallBack utilisateurAdapterCallBack) {
        this.listUtilisateurs = listUtilisateurs;
        this.context = context;
        this.utilisateurAdapterCallBack = utilisateurAdapterCallBack;
    }

    @NonNull
    @Override
    public UtilisateurViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_recycler_view_utilisateur, parent, false);
        return new UtilisateurViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UtilisateurViewHolder holder, int position) {
        Utilisateur utilisateur = this.listUtilisateurs.get(position);
        String data = utilisateur.getNom() + " " + utilisateur.getPrenom();
        holder.textViewNomPrenom.setText(data);

        holder.textViewOptionMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, utilisateur.toString(), Toast.LENGTH_LONG).show();

                //Création d'un menu popup associé au bouton
                PopupMenu popupMenu = new PopupMenu(context, holder.textViewOptionMenu);
                //Association au layout
                popupMenu.inflate(R.menu.option_menu_utilisateur);

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        //Test pour voir quelle option du menu a été choisie
                        if (menuItem.getItemId() == R.id.optionMenuItemUtilisateurModifier) {
                            Toast.makeText(context, "Modifier", Toast.LENGTH_SHORT).show();
                            utilisateurAdapterCallBack.onItemClickedModifier(utilisateur);
                        } else {
                            Toast.makeText(context, "Supprimer", Toast.LENGTH_SHORT).show();
                            utilisateurAdapterCallBack.onItemClickedSupprimer(utilisateur);
                        }

                        return false;
                    }
                });
                popupMenu.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.listUtilisateurs.size();
    }

    public static class UtilisateurViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewNomPrenom;
        public TextView textViewOptionMenu;

        public UtilisateurViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewNomPrenom = itemView.findViewById(R.id.itemRecyclerViewUser);
            this.textViewOptionMenu = itemView.findViewById(R.id.itemRecyclerViewOptionMenu);
        }
    }

    /**
     * Interface pour les callbacks
     * (Tour de passe-passe en Java
     * Ne cherchez pas, c'est magique !)
     */
    public interface UtilisateurAdapterCallBack {
        void onItemClickedModifier(Utilisateur utilisateur);
        void onItemClickedSupprimer(Utilisateur utilisateur);
    }


}

