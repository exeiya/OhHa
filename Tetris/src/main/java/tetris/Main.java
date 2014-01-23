
package tetris;
import tetris.peli.Peli;
import tetris.domain.*;

public class Main {

    public static void main(String[] args) {
        
        Kuvio kuvio = new Kuvio();
        Pala pala = new Pala(5,5);
        Pala pala2 = new Pala(5,4);
        Pala pala3 = new Pala(6,5);
        Pala pala4 = new Pala(4,5);
        kuvio.lisaaPala(pala);
        kuvio.lisaaPala(pala2);
        kuvio.lisaaPala(pala3);
        kuvio.lisaaPala(pala4);
        
        kuvio.tulosta();
        System.out.println("");
        kuvio.kaanna();
        
        kuvio.tulosta();
    }
}