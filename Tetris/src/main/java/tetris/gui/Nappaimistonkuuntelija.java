
package tetris.gui;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import tetris.domain.Kuvio;
import tetris.Suunta;

public class Nappaimistonkuuntelija implements KeyListener {
    
    private Kuvio kuvio;
    
    public Nappaimistonkuuntelija(Kuvio kuvio){
        this.kuvio = kuvio;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            this.kuvio.setSuunta(Suunta.VASEN);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            this.kuvio.setSuunta(Suunta.OIKEA);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    
    
}
