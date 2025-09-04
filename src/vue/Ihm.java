package vue;

import modele.Coup;
import modele.Humain;
import modele.IJoueur;
import modele.Tas;

import java.util.Scanner;

public class Ihm {

    private Scanner sc;

    public Ihm() {
        sc = new Scanner(System.in);
    }

    public IJoueur demandeJoueurNom(int nbjoueur, Ihm ihm) {
        System.out.println("Veuillez donner le nom du joueur " + nbjoueur + " :");
        return new Humain(sc.next(), this);
    }

    public Tas demandeNbTas() {
        int tasnb = 0;

        while (tasnb < 1) {
            System.out.println("Veuillez donner le nom du tas :");
            tasnb = sc.nextInt();
        }
        return new Tas(tasnb);
    }

    public void sendTasString(Tas tas) {
        System.out.println("Etat du jeu :");
        System.out.println(tas);
    }

    public Coup demandeCoup(String nameJoueur) {
        Coup coup = null;
        int alumetteEnlever;
        int ligneOuEnlever;

        System.out.println(nameJoueur + " à vous de joueur : ");
        System.out.println("Veuillez indiquer un nombre d'alumette à enlever :");
        alumetteEnlever = sc.nextInt();
        System.out.println("Veuillez indiquer une ligne où enlever les alumettes :");
        ligneOuEnlever = sc.nextInt();

        return new Coup(alumetteEnlever, ligneOuEnlever);
    }

    public void coupInvalideNotif() {
        System.out.println("Coup invalide");
    }

    public void printGagnant(IJoueur IJoueur) {
        System.out.println("Le gagnant est : " + IJoueur.getNom());
    }

    public boolean rejouer() {
        boolean replay = false;
        String input = "";

        do {
            System.out.println("Voulez-vous rejouer? [Oui/Non]");
            input = sc.next().toUpperCase();
        } while ((!(input.equalsIgnoreCase("OUI") || input.equalsIgnoreCase("NON"))));

        if (input.equalsIgnoreCase("OUI")) {
            replay = true;
        } else {
            replay = false;
        }

        return replay;
    }

    public boolean choixJouerContreIA(){
        System.out.println("Souhaitez vous jouer contre l'ordinateur ?");
        return sc.next().toUpperCase().equalsIgnoreCase("OUI");
    }

    public void printCoup(Coup coup, String jName){
        System.out.println(jName + " à  joué allumette(s) : " + coup.getNballumette() + " tas : " + coup.getTas());
    }


}
