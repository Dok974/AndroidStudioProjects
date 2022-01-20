package com.doranco.models;

import java.io.Serializable;

public class Specialite implements Serializable {
    private int id;
    private String specialite;
    private String description;

    public Specialite(int id, String specialite, String description) {
        this.id = id;
        this.specialite = specialite;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
