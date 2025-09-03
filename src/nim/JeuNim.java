package nim;

import controleur.ControleurJeu;
import vue.Ihm;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class JeuNim {
    public static void main(String[] args) {

        Ihm ihm = new Ihm();
        ControleurJeu controleurJeu=new ControleurJeu(ihm);
        controleurJeu.jouer();
    }
}