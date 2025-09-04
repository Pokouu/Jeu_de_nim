package modele;

import vue.Ihm;

import java.util.Random;

public class IA implements IJoueur {

    private String nom;
    private int nbPartieGagne;
    private Ihm ihm;
    private IStrategie strategie;

    public IA(String nom, Ihm ihm) {
        this.nom = nom;
        this.ihm = ihm;
        this.strategie = strategie;
    }

    public String getNom() {
        return this.nom;
    }

    public Coup jouer(Tas tas) {
        return this.strategie.appliquerStrategie(tas);
    }

    public void incrementePartieGagne() {
        this.nbPartieGagne++;
    }

    public void initStrategie() {
        Random rand = new Random();
        if(rand.nextBoolean()){
            this.strategie = new StrategieNaive();
        }
        else{
            this.strategie = new StratégieIntelligente();
        }
    }


}
