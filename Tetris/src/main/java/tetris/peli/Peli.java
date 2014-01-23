package tetris.peli;
import tetris.domain.*;

public class Peli {
    
    private int leveys;
    private int korkeus;
    
    public Peli(int leveys, int korkeus){
        this.leveys = leveys;
        this.korkeus = korkeus;
    }
    
    private boolean kuvioOnPohjassa(){
        
        return false;
    }
}
