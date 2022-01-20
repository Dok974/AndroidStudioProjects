package com.doranco.models;

import java.io.Serializable;

public class Ordinateur implements Serializable {

    private int id;
    private int anneeDeFabrication;
    private String marque;
    private String numSerie;
    private String publicViser;
    private String typeClavier;

    public Ordinateur(int id, int anneeDeFabrication, String marque, String numSerie, String publicViser, String typeClavier) {
        this.id = id;
        this.anneeDeFabrication = anneeDeFabrication;
        this.marque = marque;
        this.numSerie = numSerie;
        this.publicViser = publicViser;
        this.typeClavier = typeClavier;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnneeDeFabrication() {
        return anneeDeFabrication;
    }

    public void setAnneeDeFabrication(int anneeDeFabrication) {
        this.anneeDeFabrication = anneeDeFabrication;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getPublicViser() {
        return publicViser;
    }

    public void setPublicViser(String publicViser) {
        this.publicViser = publicViser;
    }

    public String getTypeClavier() {
        return typeClavier;
    }

    public void setTypeClavier(String typeClavier) {
        this.typeClavier = typeClavier;
    }
}
