package controleur;

import modele.*;
import vue.Ihm;

import java.util.Random;
import java.util.concurrent.ScheduledFuture;

public class ControleurJeu {

    private Ihm ihm;
    private IJoueur j1;
    private IJoueur j2;
    private IJoueur[] IJoueurs = new IJoueur[2];
    int indiceJoueur = 0;
    private Tas tas;



    private IJoueur dernierIJoueurAyantJoue;

    public ControleurJeu(Ihm ihm) {
        Random rand = new Random();

        this.ihm = ihm;
        boolean jouerContreIA = this.ihm.choixJouerContreIA();


        this.IJoueurs[0] = this.ihm.demandeJoueurNom(1, ihm);

        if(jouerContreIA) {
            this.IJoueurs[1] = new IA("IA", ihm);
        }
        else {
            this.IJoueurs[1] = this.ihm.demandeJoueurNom(2, ihm);
        }

        this.tas = this.ihm.demandeNbTas();
    }

    public void jouer() {
        indiceJoueur = 1;

        for(IJoueur joueur : IJoueurs){
            joueur.initStrategie();
        }

        while (this.tas.resteAlumette()) {
            indiceJoueur = indiceJoueur == 0 ? 1:0;
            this.ihm.sendTasString(this.tas);

                while (!coupProcess(IJoueurs[indiceJoueur].jouer(tas))) {
                    this.ihm.coupInvalideNotif();
                }
        }

        this.ihm.printGagnant(IJoueurs[indiceJoueur]);
        IJoueurs[indiceJoueur].incrementePartieGagne();

        if (this.ihm.rejouer()) {
            this.tas = this.ihm.demandeNbTas();
            this.jouer();
        }
    }


    public boolean coupProcess(Coup coup) {
        boolean validite = false;

        if (this.tas.existTas(coup.getTas()) && this.tas.getAllumetteSurLigne(coup.getTas() - 1) >= coup.getNballumette() && coup.getNballumette() > 0 && coup.getNballumette() <= 3) {
            validite = true;
            this.tas.enleverAllumette(coup.getTas(), coup.getNballumette());
            this.ihm.printCoup(coup, IJoueurs[indiceJoueur].getNom());
        }
        return validite;
    }

}
