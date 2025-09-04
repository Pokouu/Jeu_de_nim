package modele;

public interface IJoueur {

    Coup jouer(Tas tas);
    void incrementePartieGagne();
    String getNom();
    void initStrategie();

}
