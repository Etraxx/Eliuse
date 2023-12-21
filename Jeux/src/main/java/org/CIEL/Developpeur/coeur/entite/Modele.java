package org.CIEL.Developpeur.coeur.entite;

public class Modele {

    private int id;
    private int nombreDeSommets;

    public Modele(int id, int nombreDeSommets){
        this.id = id;
        this.nombreDeSommets = nombreDeSommets;
    }

    public int getId() {
        return id;
    }

    public int getNombreDeSommets() {
        return nombreDeSommets;
    }
}
