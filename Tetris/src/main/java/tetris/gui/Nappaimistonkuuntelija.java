
package tetris.gui;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import tetris.domain.Kuvio;
import tetris.peli.Peli;
import tetris.Suunta;
import tetris.domain.Pala;

public class Nappaimistonkuuntelija implements KeyListener {
    
    private Peli peli;
    private Kuvio kuvio;
    private Paivitettava paivitettava;

    public Nappaimistonkuuntelija(Peli peli, Paivitettava paivitettava){
        this.peli = peli;
        this.paivitettava = paivitettava;
        this.kuvio = peli.getLiikkuvaKuvio();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    public boolean osuukoReunaan(int x){
        if (this.kuvio.osuuReunaan(x)){
            return true;
        }
        return false;
    }
    
    public boolean osuukoKaantyessaPaloihin(){
        Kuvio testi = kuvio.luoTestikuvio();
        testi.kaanna();
        for (Pala pala : peli.getKentanPalat()){
            if (testi.osuuPalaan(pala)){
                return true;
            }
        }
        return false;
    }
    
    public boolean meneekoReunanYliKaantyessa(){
        Kuvio testi = kuvio.luoTestikuvio();
        testi.kaanna();
        for(Pala pala : testi.getPalat()){
            if (pala.getX() > 270 || pala.getX() < 0){
                return true;
            }
        }
        return false;
    }
    
    public boolean osuukoPaloihin(Suunta suunta){
        Kuvio testi = kuvio.luoTestikuvio();
        testi.setSuunta(suunta);
        for (Pala pala : this.peli.getKentanPalat()){
            if (testi.osuuPalaan(pala)){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        this.kuvio = peli.getLiikkuvaKuvio();
        if (!peli.jatkuu()){
            
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT){
                if(!osuukoPaloihin(Suunta.VASEN) && !osuukoReunaan(0)){
                    this.kuvio.setSuunta(Suunta.VASEN);
                    this.peli.liikutaKuviota();
                    this.kuvio.setSuunta(Suunta.ALAS);
                }
            
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(!osuukoPaloihin(Suunta.OIKEA) && !osuukoReunaan(270)){
                this.kuvio.setSuunta(Suunta.OIKEA);
                this.peli.liikutaKuviota();
                this.kuvio.setSuunta(Suunta.ALAS);
            }

        }
        else if (e.getKeyCode() == KeyEvent.VK_UP){
            if(!osuukoKaantyessaPaloihin() && !meneekoReunanYliKaantyessa()){
                kuvio.kaanna();
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            this.peli.liikutaKuviota();
        }
        
        paivitettava.paivita();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    
    
}
