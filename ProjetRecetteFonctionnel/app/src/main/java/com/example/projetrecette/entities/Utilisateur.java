package com.example.projetrecette.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

//NB : le renommage a une incidence sur le reste (notamment au niveau des requetes)
@Entity(tableName = "utilisateurs")
public class Utilisateur implements Serializable {

    /**
     * Idem @Id, autoGenerate permet de générer la clé primaire en auto increment)
     */
    @PrimaryKey(autoGenerate = true)
    private int id;

    //Complément d'info en BD
    // @ColumnInfo(name = "nom_utilisateur")
    private String nom;

    //Idem ci dessus
    //@ColumnInfo(name = "prenom_utilisateur")
    private String prenom;

    /**
     * Constructeur sans param
     */
    public Utilisateur() {
    }
    /**
     * Constructeur sans param
     */
    public Utilisateur(int id) {
        this.id = id;
    }

    /**
     * Constructeur sans id
     *
     * @param nom
     * @param prenom
     */
    public Utilisateur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Override de la méthode toString
     *
     * @return
     */
    @NonNull
    @Override
    public String toString() {
        return "\nID : " + this.id
                + "\nNOM : " + this.nom
                + "\nPRENOM : " + this.prenom
                + "\n";
    }
}
