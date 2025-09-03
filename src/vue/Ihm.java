package vue;

import modele.Coup;
import modele.Joueur;
import modele.Tas;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class Ihm {


    private Scanner sc;

    public Ihm(){
         sc = new Scanner(System.in);
    }

    public Joueur demandeJoueurNom(int nbjoueur){
        System.out.println("Veuillez donner le nom du joueur " + nbjoueur + " :");
        return new Joueur(sc.next());
    }

    public Tas demandeNbTas(){
        int tasnb = 0;

        while(tasnb < 1) {
            System.out.println("Veuillez donner le nom du tas :");
            tasnb = sc.nextInt();
        }
        return new Tas(tasnb);
    }

    public void sendTasString(Tas tas){
        System.out.println("Etat du jeu :");
        System.out.println(tas.tasString());
    }

    public Coup demandeCoup(String nameJoueur){
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

    public void coupInvalideNotif(){
        System.out.println("Coup invalide");
    }



}
