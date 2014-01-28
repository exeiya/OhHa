package tetris.peli;
import tetris.domain.*;
import java.util.*;

public class Peli {
    
    private int leveys;
    private int korkeus;
    private List<Pala> palatKentalla;
    
    public Peli(int leveys, int korkeus){
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.palatKentalla = new ArrayList<Pala>();
        
    }
    
    
}
