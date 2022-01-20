package com.doranco.models;

import java.io.Serializable;

public class Pays implements Serializable {
    private int id;
    private String continent;
    private String nom;

    public Pays(int id, String continent, String nom) {
        this.id = id;
        this.continent = continent;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
