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
    private int pisteet;
    private boolean peliohi;
    
    public Peli() {
        super(1000, null);
        this.palatKentalla = new ArrayList<>();
        this.jatkuu = true;
        this.kuvionMuodostaja = new KuvioBuilder();
        this.kuvio = null;
        this.pisteet = 0;
        this.peliohi = false;

        lisaaKuvio();

        addActionListener(this);
        setInitialDelay(1000);
    }

    public boolean jatkuu() {
        return this.jatkuu;
    }

    public void peliOhi() {
        this.jatkuu = false;
        this.peliohi = true;
        stop();
    }
    
    public boolean getPeliOhi(){
        return this.peliohi;
    }

    public void liikutaKuviota() {
        if (this.kuvio.osuuPohjaan() || (osuuKentanPaloihin() && this.kuvio.getSuunta() == Suunta.ALAS)) {
            lisaaKentanPaloihin();
            lisaaKuvio();
            pisteet += 5;
            tarkistaRivit();
        } else {
            this.kuvio.siirry();
        }
    }

    public void tiputaRivit(int rivi) {
        for (int i = rivi - 30; i > 0; i -= 30) {
            for (Pala pala : palatKentalla) {
                if (pala.getY() == i) {
                    pala.siirry(0, 30);
                }
            }
        }
    }

    public void poistaPalat(int rivi) {
        List<Pala> poistettavat = new ArrayList<>();
        for (Pala pala : palatKentalla) {
            if (pala.getY() == rivi) {
                poistettavat.add(pala);
            }
        }
        for (Pala pala : poistettavat) {
            palatKentalla.remove(pala);
        }
        
    }

    public void tarkistaRivit() {
        int monta = 0;
        for (int i = 570; i > 0; i -= 30) {
            for (Pala pala : palatKentalla) {
                if (pala.getY() == i) {
                    monta++;
                }
            }
            if (monta == 10) {
                poistaPalat(i);
                pisteet += 10;
                tiputaRivit(i);
                monta = 0;
            }
            monta = 0;
        }
        paivitettava.paivita();
    }
    
    public String getPisteet(){
        return this.pisteet + "";
    }
    
    public boolean osuukoUusiKentanPaloihin(Kuvio uusiKuvio){
        Kuvio testikuvio = uusiKuvio.luoTestikuvio();
        for (Pala pala : palatKentalla) {
            if (testikuvio.osuuPalaan(pala)) {
                return true;
            }
        }
        return false;
    }

    public void lisaaKuvio() {
        Kuvio uusiKuvio = this.kuvionMuodostaja.uusiKuvio();
        if (osuukoUusiKentanPaloihin(uusiKuvio)){
            this.kuvio = uusiKuvio;
            System.out.println("ÖRR");
            peliOhi();
        } else {
            this.kuvio = uusiKuvio;
        }
        
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
    
    public void aloitaUudelleen(){
        this.palatKentalla.clear();
        this.jatkuu = true;
        this.peliohi = false;
        this.kuvio = null;
        this.pisteet = 0;
        
        lisaaKuvio();
        
        start();
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
            paivitettava.paivita();
        } else if(peliohi) {
            paivitettava.paivita();
        }
        
    }
}
