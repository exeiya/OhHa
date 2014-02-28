
package tetris.domain;
import tetris.domain.*;
import java.util.Random;

/**
 * Luo varsinaista peliä varten tarvittavat Kuviot.
 * Arpoo randomin, jonka mukaan valitaan muodostettavan
 * kuvion tyyppi ja asetetaan palat kuvioon taulukossa
 * olevien arvojen perusteella.
 * 
 * @author Krista
 */

public class KuvioBuilder {

    private Random random;
    
    public KuvioBuilder(){
        this.random = new Random();
    }
    
    /**
     * Metodi uuden kuvion luomista varten.
     * Valitsee satunnaisen arvon 0-6 ja valitsee sen
     * perusteella kuvion tyypin.
     * @return 
     */
    public Kuvio uusiKuvio(){
        int kuvionTyyppi = this.random.nextInt(7);
        Kuvio kuvio = new Kuvio();
        kuvio.setTyyppi(kuvionTyyppi);
        if (kuvionTyyppi == 0){ //I
            int[] paikat0 = {150, -60, 150, -90, 150, -30, 150, 0};
            asetaPalat(kuvio, paikat0);
        } else if (kuvionTyyppi == 1){ //O
            int[] paikat1 = {150, -30, 180, -30, 150, 0, 180, 0};
            asetaPalat(kuvio, paikat1);
        } else if (kuvionTyyppi == 2) { //L
            int[] paikat2 = {150, -30, 150, -60, 150, 0, 180, 0};
            asetaPalat(kuvio, paikat2);
        } else if (kuvionTyyppi == 3) { //T
            int[] paikat3 = {150, 0, 150, -30, 120, 0, 180, 0};
            asetaPalat(kuvio, paikat3);
        } else if (kuvionTyyppi == 4) { //Z
            int[] paikat4 = {150, -30, 120, -30, 150, 0, 180, 0};
            asetaPalat(kuvio, paikat4);
        } else if (kuvionTyyppi == 5) { //S
            int[] paikat5 = {150, -30, 180, -30, 150, 0, 120, 0};
            asetaPalat(kuvio, paikat5);
        } else if (kuvionTyyppi == 6) { //J
            int[] paikat6 = {150, -30, 150, -60, 150, 0, 120, 0};
            asetaPalat(kuvio, paikat6);
        }
        
        return kuvio;
    }
    
    /**
     * Lisää valittuun kuvioon palat, joilla on valitun
     * listan koordinaatit.
     * @param kuvio
     * @param paikat 
     */
    public void asetaPalat(Kuvio kuvio, int[] paikat){
        for (int i = 0; i < paikat.length; i+=2){
            kuvio.lisaaPala(new Pala(paikat[i], paikat[i+1]));
        }
    }
    
}
