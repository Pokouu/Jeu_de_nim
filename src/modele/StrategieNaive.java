package modele;

import java.util.Random;

public class StrategieNaive implements IStrategie{


    @Override
    public Coup appliquerStrategie(Tas tas) {
        Random rand = new Random();
        int indice = 0;
        boolean trouve = false;

        while(!trouve){
            indice = rand.nextInt(tas.getTas().length);
            trouve = tas.getTas()[indice] > 0;
        }

        return new Coup(rand.nextInt(tas.getTas()[indice]), indice+1);
    }
}
