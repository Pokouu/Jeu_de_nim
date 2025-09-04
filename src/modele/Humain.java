package modele;

import vue.Ihm;

public class Humain implements IJoueur {

    private String nom;
    private int nbPartieGagne = 0;
    private Ihm ihm;

    public Humain(String nom, Ihm ihm) {
        this.nom = nom;
        this.ihm = ihm;
    }

    public String getNom() {
        return nom;
    }

    public int getNbPartieGagne() {
        return this.nbPartieGagne;
    }

    public void incrementePartieGagne() {
        this.nbPartieGagne++;
    }

    public Coup jouer(Tas tas){
        return this.ihm.demandeCoup(this.nom);
    }

    public void initStrategie() {

    }
}
