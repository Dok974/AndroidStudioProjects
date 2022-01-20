package com.doranco.adapters;

import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doranco.MainActivity2;
import com.doranco.R;
import com.doranco.models.Pays;

import java.util.List;

public class PaysAdapter extends RecyclerView.Adapter<PaysAdapter.PaysViewHolder> {
private final List<Pays> paysList;

    public PaysAdapter(List<Pays> paysList) {
        this.paysList = paysList;
    }

    @NonNull
    @Override
    public PaysViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_pays,parent,false);

        return new PaysViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaysViewHolder holder, int position) {
        Pays pays =paysList.get(position);

        holder.country.setText(pays.getNom());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity2.class);
                intent.putExtra("pays", pays);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return paysList.size();
    }

    public class PaysViewHolder extends RecyclerView.ViewHolder{
        private TextView country;

        public TextView getCountry() {
            return country;
        }

        public void setCountry(TextView country) {
            this.country = country;
        }

        public PaysViewHolder(@NonNull View itemView) {
            super(itemView);
        country = itemView.findViewById(R.id.textViewAllPays);
        }
    }
}
