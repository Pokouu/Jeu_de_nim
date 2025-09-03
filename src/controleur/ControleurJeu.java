package controleur;

import modele.Coup;
import modele.Joueur;
import modele.Tas;
import vue.Ihm;

public class ControleurJeu {

    private Ihm ihm;
    private Joueur j1;
    private Joueur j2;
    private Tas tas;


    private Joueur dernierJoueurAyantJoue;

    public ControleurJeu(Ihm ihm) {
        this.ihm = ihm;
        this.j1 = this.ihm.demandeJoueurNom(1);
        this.j2 = this.ihm.demandeJoueurNom(2);
        this.tas = this.ihm.demandeNbTas();
    }

    public Ihm getIhm() {
        return this.ihm;
    }

    public void jouer() {
        this.dernierJoueurAyantJoue = j1;
        int alumetteenlever;
        int ligne;

        while (this.tas.resteAlumette()) {
            this.ihm.sendTasString(this.tas);
            while(!coupProcess(this.ihm.demandeCoup(getNextJoueurToPlay()))){
                this.ihm.coupInvalideNotif();
                getNextJoueurToPlay(); //reset au joueur qui vient de jouer car sinon ça va sur le suivant
            }

        }

        System.out.println("Le gagnant est : " + dernierJoueurAyantJoue.getNom());
    }

    public String getNextJoueurToPlay() {
        String retour = this.dernierJoueurAyantJoue.equals(j2) ? j1.getNom() : j2.getNom() ;
        this.dernierJoueurAyantJoue = this.dernierJoueurAyantJoue.equals(j2) ? j1 : j2;
        return retour;
    }

    public boolean coupProcess(Coup coup){
        boolean validite = false;

        if(this.tas.existTas(coup.getTas()) && this.tas.getAllumetteSurLigne(coup.getTas()-1) >= coup.getNballumette() && coup.getNballumette() > 0 && coup.getNballumette() <= 3){
            validite = true;
            this.tas.enleverAllumette(coup.getTas(),  coup.getNballumette());
        }

        return validite;
    }

}
