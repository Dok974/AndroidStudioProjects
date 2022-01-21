package com.doranco.models;

import android.widget.EditText;

import java.io.Serializable;
import java.util.Date;

public class Utilisateur implements Serializable {
    private int id;
    private String nom;
    private String prenom;
    private int telephone;
    private String pays;
    private String dateDeNaissance;
    private String sexe;

    public Utilisateur(int id, String nom, String prenom, int telephone, String pays, String dateDeNaissance, String sexe) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.pays = pays;
        this.dateDeNaissance = dateDeNaissance;
        this.sexe = sexe;
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

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
}
