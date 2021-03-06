package tetris.domain;

import java.util.*;
import tetris.Suunta;

/**
 * Yksittäistä kuviota kuvaava luokka,
 * sisältää kuvion tyyppitiedon, suunnan
 * ja siihen kuuluvat palat. 
 * 
 * @author Krista
 */

public class Kuvio {

    private List<Pala> palat;
    private Suunta suunta;
    private int kuvionTyyppi;

    public Kuvio() {
        this.palat = new ArrayList<>();
        this.suunta = Suunta.ALAS;
    }
    /**
     * Lisätään valittu Pala Kuvioon.
     * @param pala lisättävä pala
     */
    public void lisaaPala(Pala pala) {
        pala.setTyyppi(kuvionTyyppi);
        palat.add(pala);
    }

    /**
     * Siirretään Kuvion listassa olevia Paloja suunnan
     * mukaisesti yhden askeleen verran.
     */
    public void siirry() {
        if (this.suunta == Suunta.ALAS) {
            siirraPalat(0, 30);
        }
        if (this.suunta == Suunta.VASEN) {
            siirraPalat(-30, 0);
        } 
        if (this.suunta == Suunta.OIKEA ) {
            siirraPalat(30, 0);
        }
    }
    
    /**
     * Siirtää kaikki kuviossa olevan listan palat
     * vaaka- ja pystysuunnassa parametrien osoittaman määrän.
     * 
     * @param x paljonko siirretään vaakasuunnassa
     * @param y paljonko siirretään pystysuunnassa
     */
    
    public void siirraPalat(int x, int y){
        for (Pala pala : palat) {
                pala.siirry(x, y);
            }
    }
    
    /**
     * Luo kopion kuviosta törmäystestausta varten.
     * 
     * @return kuvion kopio
     */
    public Kuvio luoTestikuvio(){
        Kuvio testik = new Kuvio();
        testik.palat.clear();
        for (Pala p : this.palat){
            testik.lisaaPala(new Pala(p.getX(), p.getY()));
        }
        return testik;
    }
    
    /**
     * Testaa, osuuko joku kuvion kopion paloista
     * valittuun palaan, kun se liikkuu suunnan mukaisesti
     * askeleen verran.
     * 
     * @param toinenPala toinen Pala, johon törmäystä testaan
     * @return false, jos ei osu Palaan; true, jos osuu
     */
    public boolean osuuPalaan(Pala toinenPala){
        Kuvio testik = luoTestikuvio();
        testik.setSuunta(suunta);
        testik.siirry();
        for (Pala pala : testik.palat){
            if (pala.osuuPalaan(toinenPala)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Testaa, osuuko Kuvion listassa olevat Palat
     * valittuun kohdassa x olevaan reunaan
     * 
     * @param x valitun reunan vaakakoordinaatti
     * @return false, jos ei osu koordinaattiin; true, jos osuu
     */
    public boolean osuuReunaan(int x){
        for (Pala pala : this.palat){
            if (pala.osuuReunaan(x)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Testaa, osuuko Kuvion listassa olevat Palat
     * kentän pohjaan.
     * 
     * @return false, jos ei osu pohjaan; true, jos osuu
     */
    public boolean osuuPohjaan(){
        for (Pala pala : this.palat){
            if (pala.osuuPohjaan()){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Kääntää jokaista Kuvion listassa olevaa Palaa
     * listan ensimmäisen palan koordinaattien suhteen. 
     */
    public void kaanna() {
        int x = palat.get(0).getX();
        int y = palat.get(0).getY();
        for (Pala pala : palat) {
            pala.kaanna(x, y);
        }
    }

    public void setSuunta(Suunta suunta) {
        this.suunta = suunta;
    }

    public List<Pala> getPalat() {
        return this.palat;
    }
    
    public Suunta getSuunta(){
        return this.suunta;
    }
    
    public void setTyyppi(int kuvionTyyppi){
        this.kuvionTyyppi = kuvionTyyppi;
    }
    
    public int getTyyppi(){
        return kuvionTyyppi;
    }

    /**
     * Tulostaa kaikki Kuvion listan Palat
     */
    public void tulosta() {
        for (Pala pala : palat) {
            System.out.println(pala);
        }
    }
}
