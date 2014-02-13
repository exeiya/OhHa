
package tetris.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import tetris.domain.Pala;
import tetris.peli.Peli;

public class Piirtoalusta extends JPanel implements Paivitettava {

    private Peli peli;
    
    public Piirtoalusta(Peli peli){
        this.peli = peli;
    }
    
    @Override
    public void paivita() {
        repaint();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.blue);
        for(Pala pala : this.peli.getLiikkuvaKuvio().getPalat()){
            g.fillRect(pala.getX(), pala.getY(), 30, 30);
        }
        g.setColor(Color.red);
        for(Pala p : this.peli.getKentanPalat()){
            g.fillRect(p.getX(), p.getY(), 30, 30);
        }
    }
    
    
    
}
