package com.doranco.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doranco.MainActivity2;
import com.doranco.R;
import com.doranco.models.Specialite;

import java.util.List;

public class SpecialiteAdapter extends RecyclerView.Adapter<SpecialiteAdapter.SpecialiteViewHolder> {
private final List<Specialite> specialiteList;

    public SpecialiteAdapter(List<Specialite> specialiteList) {
        this.specialiteList = specialiteList;
    }

    @NonNull
    @Override
    public SpecialiteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_specialite,parent,false);

        return new SpecialiteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpecialiteViewHolder holder, int position) {
        Specialite specialite =specialiteList.get(position);

        holder.country.setText(specialite.getSpecialite());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity2.class);
                intent.putExtra("specialite", specialite);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return specialiteList.size();
    }

    public class SpecialiteViewHolder extends RecyclerView.ViewHolder{
        private TextView country;

        public TextView getCountry() {
            return country;
        }

        public void setCountry(TextView country) {
            this.country = country;
        }

        public SpecialiteViewHolder(@NonNull View itemView) {
            super(itemView);
        country = itemView.findViewById(R.id.textViewAllSpecialite);
        }
    }
}
