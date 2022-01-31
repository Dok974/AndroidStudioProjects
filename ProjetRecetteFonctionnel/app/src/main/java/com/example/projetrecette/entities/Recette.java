package com.example.projetrecette.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Recette")
public class Recette implements Serializable {

        @PrimaryKey(autoGenerate = true)
        private int id;

        @ColumnInfo(name = "libelle_recette")
        private String libelle;

        @ColumnInfo(name = "description_recette")
        private String description;

        public String Utilisateur;

        public Recette(){}

        public Recette(String libelle, String description) {
            this.libelle = libelle;
            this.description = description;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLibelle() {
            return libelle;
        }

        public void setLibelle(String libelle) {
            this.libelle = libelle;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return "Recette{" +
                    "id=" + id +
                    ", libelle='" + libelle + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
}
