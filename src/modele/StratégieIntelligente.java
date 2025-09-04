package modele;

public class StratégieIntelligente implements IStrategie {


    public StratégieIntelligente(){

    }

    @Override
    public Coup appliquerStrategie(Tas tas) {
        int resultatXor = 0;
        Coup coup = null;


        for (int i = 0; i < tas.getTas().length; i++) {
            resultatXor ^= tas.getTas()[i];
        }

        if (resultatXor == 0) {
            coup = findDefaultCoup(tas);
        } else {
            for (int i = 0; i < tas.getTas().length; i++) {
                int res = tas.getTas()[i] ^ resultatXor;
                if ((res < tas.getTas()[i] && tas.getTas()[i] - res > 0 && tas.getTas()[i] - res <= 3)) {
                    coup = new Coup(tas.getTas()[i] - res, i + 1);
                }
            }
            if (coup == null) {
                coup = findDefaultCoup(tas);
            }
        }
        return coup;
    }

    public Coup findDefaultCoup(Tas tas) {
        Coup coup = null;
        for (int i = 0; i < tas.getTas().length; i++) {
            if ((tas.getTas()[i] > 0)) {
                coup = new Coup(1, i + 1);
            }
        }
        return coup;
    }
}
