package tetris.peli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.Timer;
import tetris.domain.*;

public class Peli extends Timer implements ActionListener{
    
    private int leveys;
    private int korkeus;
    private List<Pala> palatKentalla;
    private boolean jatkuu;
    private Kuvio kuvio;
    private KuvioBuilder kuvionMuodostaja;
    
    public Peli(){
        super(1000, null);
        this.leveys = 300;
        this.korkeus = 600;
        this.palatKentalla = new ArrayList<>();
        this.jatkuu = true;
        this.kuvionMuodostaja = new KuvioBuilder();
        
        lisaaKuvio();
        
        addActionListener(this);
        setInitialDelay(1500);
    }
    
    public boolean jatkuu(){
        return this.jatkuu;
    }
    
    public void lisaaKuvio(){
        this.kuvio = this.kuvionMuodostaja.uusiKuvio();
    }
    
    public boolean osuuPohjaan(){
        return false;
    }
    
    public void lisaaKentanPaloihin(){
        for (Pala pala : this.kuvio.getPalat()){
            this.palatKentalla.add(pala);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    
    
}
