
package tetris.domain;
import tetris.domain.*;
import java.util.Random;

public class KuvioBuilder {

    private Random random;
    
    public KuvioBuilder(){
        this.random = new Random();
    }
    
    public Kuvio uusiKuvio(){
        int kuvionTyyppi = this.random.nextInt(4);
        Kuvio kuvio = new Kuvio();
        if (kuvionTyyppi == 0){ //I
            int[] paikat0 = {150, 15, 150, 45, 150, 75, 150, 105};
            asetaPalat(kuvio, paikat0);
        } else if (kuvionTyyppi == 1){ //O
            int[] paikat1 = {150, 15, 180, 15, 150, 45, 180, 45};
            asetaPalat(kuvio, paikat1);
        } else if (kuvionTyyppi == 2) { //L
            int[] paikat2 = {150, 45, 150, 15, 150, 75, 180, 75};
            asetaPalat(kuvio, paikat2);
        } else if (kuvionTyyppi == 3) { //T
            int[] paikat3 = {150, 45, 150, 15, 120, 45, 180, 45};
            asetaPalat(kuvio, paikat3);
        }
        
        return kuvio;
    }
    
    public void asetaPalat(Kuvio kuvio, int[] paikat){
        for (int i = 0; i < paikat.length; i++){
            kuvio.lisaaPala(new Pala(paikat[i], paikat[i+1]));
        }
    }
    
}
