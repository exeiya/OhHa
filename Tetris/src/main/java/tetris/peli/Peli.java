package tetris.peli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.Timer;
import tetris.Suunta;
import tetris.domain.*;
import tetris.gui.Paivitettava;

public class Peli extends Timer implements ActionListener {

    private List<Pala> palatKentalla;
    private boolean jatkuu;
    private Kuvio kuvio;
    private KuvioBuilder kuvionMuodostaja;
    private Paivitettava paivitettava;

    public Peli() {
        super(1000, null);
        this.palatKentalla = new ArrayList<>();
        this.jatkuu = true;
        this.kuvionMuodostaja = new KuvioBuilder();
        this.kuvio = null;
        
        lisaaKuvio();

        addActionListener(this);
        setInitialDelay(1000);
    }

    public boolean jatkuu() {
        return this.jatkuu;
    }

    public void peliOhi() {
        this.jatkuu = false;
    }

    public void liikutaKuviota() {
        if (this.kuvio.osuuPohjaan() || (osuuKentanPaloihin() && this.kuvio.getSuunta() == Suunta.ALAS)) {
            lisaaKentanPaloihin();
            lisaaKuvio();
        } else {
            this.kuvio.siirry();
        }
    }
    
    public void tiputaRivi(){
        //TODO: tiputetaan ylläolevat rivit
    }
    
    public void tarkistaRivit(){
        //TODO: tarkistetaan onko täysiä rivejä
    }

    public void lisaaKuvio() {
        this.kuvio = this.kuvionMuodostaja.uusiKuvio();
    }

    public boolean osuuKentanPaloihin() {
        for (Pala pala : palatKentalla) {
            if (this.kuvio.osuuPalaan(pala)) {
                return true;
            }
        }
        return false;
    }

    public Kuvio getLiikkuvaKuvio() {
        return this.kuvio;
    }

    public void lisaaKentanPaloihin() {
        for (Pala pala : this.kuvio.getPalat()) {
            this.palatKentalla.add(pala);
        }
    }

    public List<Pala> getKentanPalat() {
        return this.palatKentalla;
    }

    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jatkuu) {
            liikutaKuviota();
        }
        paivitettava.paivita();
    }
}
