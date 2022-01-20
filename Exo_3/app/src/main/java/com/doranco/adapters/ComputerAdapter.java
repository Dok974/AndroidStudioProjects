package com.doranco.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.doranco.MainActivity2;
import com.doranco.R;
import com.doranco.models.Ordinateur;

import java.util.List;

public class ComputerAdapter extends RecyclerView.Adapter<ComputerAdapter.ComputerViewHolder>{

private final List<Ordinateur> ordinateurList;

    public ComputerAdapter(List<Ordinateur> ordinateurList) {
        this.ordinateurList = ordinateurList;
    }

    @NonNull
    @Override
    public ComputerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_ordinateur, parent, false);

        return new ComputerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComputerViewHolder holder, int position) {
        Ordinateur ordinateur = ordinateurList.get(position);
        holder.marque.setText(ordinateur.getMarque());
        holder.anneeDeFabrication.setText(String.valueOf(ordinateur.getAnneeDeFabrication()));
        holder.publicViser.setText(ordinateur.getPublicViser());
        holder.typeClavier.setText(ordinateur.getTypeClavier());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity2.class);
                intent.putExtra("ordinateur",ordinateur);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() { return ordinateurList.size(); }

    public class ComputerViewHolder extends RecyclerView.ViewHolder {
        public TextView marque;
        public TextView anneeDeFabrication;
        public TextView publicViser;
        public TextView typeClavier;

        public ComputerViewHolder(@NonNull View itemView) {
            super(itemView);
            marque = itemView.findViewById(R.id.textViewID);
            anneeDeFabrication = itemView.findViewById(R.id.textViewAnneeFabrication);
            publicViser = itemView.findViewById(R.id.textViewPublicViser);
            typeClavier = itemView.findViewById(R.id.textViewTypeClavier);
        }
    }
}
