package tetris.domain;

import java.util.*;
import tetris.Suunta;

public class Kuvio {

    private List<Pala> palat;
    private Suunta suunta;
    private int kuvionTyyppi;

    public Kuvio() {
        this.palat = new ArrayList<>();
        this.suunta = Suunta.ALAS;
    }

    public void lisaaPala(Pala pala) {
        pala.setTyyppi(kuvionTyyppi);
        palat.add(pala);
    }

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
    
    public void siirraPalat(int x, int y){
        for (Pala pala : palat) {
                pala.siirry(x, y);
            }
    }
    
    public Kuvio luoTestikuvio(){
        Kuvio testik = new Kuvio();
        testik.palat.clear();
        for (Pala p : this.palat){
            testik.lisaaPala(new Pala(p.getX(), p.getY()));
        }
        return testik;
    }
    
    public boolean osuuPalaan(Pala toinen){
        Kuvio testik = luoTestikuvio();
        testik.setSuunta(suunta);
        testik.siirry();
        for (Pala pala : testik.palat){
            if (pala.osuuPalaan(toinen)){
                return true;
            }
        }
        return false;
    }
    
    public boolean osuuReunaan(int x){
        for (Pala pala : this.palat){
            if (pala.osuuReunaan(x)){
                return true;
            }
        }
        return false;
    }
    
    public boolean osuuPohjaan(){
        for (Pala pala : this.palat){
            if (pala.osuuPohjaan()){
                return true;
            }
        }
        return false;
    }

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

    public void tulosta() {
        for (Pala pala : palat) {
            System.out.println(pala);
        }
    }
}
