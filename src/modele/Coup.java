package modele;

public class Coup {

    private int tas;
    private int nballumette;

    public Coup(int nballumette, int tas) {
        this.tas = tas;
        this.nballumette = nballumette;
    }

    public int getTas() {
        return tas;
    }
    public void setTas(int tas) {this.tas = tas;}

    public int getNballumette() {return nballumette;}



}
