
package tetris.domain;

import tetris.domain.Pala;
import java.util.*;

public class Kuvio {
    private List<Pala> palat;
    
    public Kuvio(){
        this.palat = new ArrayList<Pala>();
    }
    
    public void lisaaPala(Pala pala){
        palat.add(pala);
    }
    
    public void siirry(int x, int y){
        for (Pala pala : palat){
            pala.siirry(x, y);
        }
    }
    
    public void kaanna(){
        int x = palat.get(0).getX();
        int y = palat.get(0).getY();
        for (Pala pala: palat){
            pala.kaanna(x, y);
        }
    }
    
    public void tulosta(){
        for (Pala pala: palat){
            System.out.println(pala);
        }
    }
    
}
