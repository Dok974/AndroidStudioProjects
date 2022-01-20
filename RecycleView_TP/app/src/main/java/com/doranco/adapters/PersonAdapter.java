package com.doranco.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.doranco.R;
import com.doranco.models.Personne;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder>{
    private final List<Personne> listPeople;

    public PersonAdapter(List<Personne> listPeople) {
        this.listPeople = listPeople;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_personne, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Personne person = this.listPeople.get(position);

        holder.textViewNom.setText(person.getNom());
        holder.textViewPrenom.setText(person.getPrenom());
        holder.textViewDateNaissance.setText(person.getDateNaissance());
    }

    @Override
    public int getItemCount() {
        return this.listPeople.size();
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewNom;
        public TextView textViewPrenom;
        public TextView textViewDateNaissance;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewNom = itemView.findViewById(R.id.textView1);
            this.textViewPrenom = itemView.findViewById(R.id.textView2);
            this.textViewDateNaissance = itemView.findViewById(R.id.textView3);

        }
    }

}
