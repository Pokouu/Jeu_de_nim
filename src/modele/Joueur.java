package modele;

public class Joueur {

    private String nom;
    private int nbPartieGagne = 0;

    public Joueur(String nom){
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {this.nom = nom;}


    public int getNbPartieGagne() {return this.nbPartieGagne;}

    public void incrementePartieGagne() { this.nbPartieGagne++;}

}
