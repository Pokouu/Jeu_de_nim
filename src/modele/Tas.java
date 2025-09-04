package modele;

public class Tas {

    private int[] tas;


    public Tas(int nbtas) {
        this.tas = new int[nbtas];
        this.tas[0] = 1; //premier tas = 1

        for (int i = 1; i < nbtas; i++) {
            this.tas[i] = this.tas[i - 1] + 2; //2ème tas == 1 + 2 etc...
        }
        //calcul nb alumette dans un tas
    }

    public int[] getTas() {
        return this.tas.clone();
    }

    public int getAllumetteSurLigne(int ligne) {
        return this.tas[ligne];
    }

    public boolean existTas(int ligne) {
        return ligne > 0 && ligne <= this.tas.length;
    }

    public String toString() {
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < tas.length; i++) {
            for (int k = 0; k < (tas.length - i) * 2; k++) {
                s.append(" ");
            }
            for (int j = 0; j < tas[i]; j++) {
                s.append("|" + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public boolean resteAlumette() {
        boolean res = false;

        for (int i = 0; i < tas.length; i++) {
            if (tas[i] != 0) {
                res = true;
            }
        }

        return res;
    }

    public void enleverAllumette(int ligne, int nb) {
        this.tas[ligne - 1] = this.tas[ligne - 1] - nb;
    }


}
