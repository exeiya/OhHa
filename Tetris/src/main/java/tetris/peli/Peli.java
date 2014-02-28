package tetris.peli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.Timer;
import tetris.Suunta;
import tetris.domain.*;
import tetris.gui.Paivitettava;

/**
 * Pelilogiikasta huolehtiva luokka
 * 
 * @author Krista
 */

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

    /**
     * Palauttaa jatkuuko peli edelleen vai ei.
     * @return
     */
    public boolean jatkuu() {
        return this.jatkuu;
    }

    /**
     * Metodi vaihtaa gameOverin päälle ja pysäyttää timerin.
     */
    public void peliOhi() {
        this.jatkuu = false;
        this.peliohi = true;
        stop();
    }
    
    public boolean getPeliOhi(){
        return this.peliohi;
    }

    /**
     * Metodi, jota kutsumalla liikutetaan Kuviota ja tarkistetaan,
     * osuuko se pohjaan, muihin paloihin tai jääkö se ylärajan yli.
     */
    public void liikutaKuviota() {
        if (this.kuvio.osuuPohjaan() || (osuuKentanPaloihin() && this.kuvio.getSuunta() == Suunta.ALAS)) {
            lisaaKentanPaloihin();
            tarkistaRivit();
            if(onkoYliYlarajan()){
                peliOhi();
            } else {
                lisaaKuvio();
                pisteet += 5;
            }
        } else {
            this.kuvio.siirry();
        }
    }

    /**
     * Tiputtaa kaikkia valitun rivin paloja
     * yhden askeleen verran alemmaksi.
     * @param rivi valittu rivi, jonka palat tiputetaan
     */
    public void tiputaRivit(int rivi) {
        for (int i = rivi - 30; i > 0; i -= 30) {
            for (Pala pala : palatKentalla) {
                if (pala.getY() == i) {
                    pala.siirry(0, 30);
                }
            }
        }
    }

    /**
     * Poistaa valitun rivin palat.
     * @param rivi rivi, jolta palat poistetaan
     */
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

    /**
     * Metodi täysien rivien tarkistamiseen.
     * Kerää täydet kentän rivit listaan.
     */
    public void tarkistaRivit() {
        int monta = 0;
        List<Integer> taydetRivit = new ArrayList<>();
        for (int i = 570; i > 0; i -= 30) {
            for (Pala pala : palatKentalla) {
                if (pala.getY() == i) {
                    monta++;
                }
            }
            if (monta == 10) {
                taydetRivit.add(i);
                
                monta = 0;
            }
            monta = 0;
        }
        Collections.reverse(taydetRivit);
        for(int rivi : taydetRivit){
            poistaPalat(rivi);
            pisteet += 10;
            tiputaRivit(rivi);
        }
        paivitettava.paivita();
    }
    /**
     * Tarkistaa, onko joku liikkuvan Kuvion
     * Paloista kentän ylärajan yläpuolella.
     * @return 
     */
    public boolean onkoYliYlarajan(){
        for(Pala pala : kuvio.getPalat()){
            if(pala.getY() < 0){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Lisää uuden liikkuvan Kuvion kentälle.
     */
    public void lisaaKuvio() {
        this.kuvio = kuvionMuodostaja.uusiKuvio();
        
    }

    /**
     * Metodi Kuvion törmäystarkistukseen.
     * Tarkistaa, osuuko Kuvio mihinkään kentällä olevaan palaan.
     * @return 
     */
    public boolean osuuKentanPaloihin() {
        for (Pala pala : palatKentalla) {
            if (this.kuvio.osuuPalaan(pala)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Lisää nykyisen tippuvan Kuvion palat kentällä olevien
     * palojen listaan.
     */
    public void lisaaKentanPaloihin() {
        for (Pala pala : this.kuvio.getPalat()) {
            this.palatKentalla.add(pala);
        }
    }
    
    /**
     * Aloittaa pelin uudelleen nollaamalla nykyisen pelin arvot.
     */
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
    
    public String getPisteet(){
        return this.pisteet + "";
    }
    
     public Kuvio getLiikkuvaKuvio() {
        return this.kuvio;
    }

    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jatkuu) {
            liikutaKuviota();
            paivitettava.paivita();
        } else {
            paivitettava.paivita();
        }
    }
}
