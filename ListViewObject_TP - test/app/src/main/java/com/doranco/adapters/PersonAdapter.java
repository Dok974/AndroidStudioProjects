package com.doranco.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.doranco.R;
import com.doranco.models.Personne;

import java.util.List;

public class PersonAdapter extends ArrayAdapter<Personne> {
    private Context context;
    private int ressource;

    public PersonAdapter(@NonNull Context context, int resource, @NonNull List<Personne> objects) {
        super(context, resource, objects);
        this.context = context;
        this.ressource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Personne person = getItem(position);
        LayoutInflater inflater = LayoutInflater.from(this.context);
        convertView = inflater.inflate(this.ressource, parent, false);

        TextView textView1 = convertView.findViewById(R.id.textView1);
        TextView textView2 = convertView.findViewById(R.id.textView2);
        TextView textView3 = convertView.findViewById(R.id.textView3);

        textView1.setText(person.getNom());
        textView2.setText(person.getPrenom());
        textView3.setText(person.getDateNaissance());

        return convertView;
    }
}
