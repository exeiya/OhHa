
package tetris.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import tetris.domain.Pala;
import tetris.peli.Peli;

/**
 * Piirtoalusta huolehtii graafisesta puolesta pelissä,
 * lataa kaikken palojen kuvat, taustakuvan ja näyttää
 * lisäksi pisteet.
 * 
 * @author Krista
 */

public class Piirtoalusta extends JPanel implements Paivitettava {

    private Peli peli;
    Image tausta;
    List<Image> kuvat;
    Image gameover;
    
    public Piirtoalusta(Peli peli){
        this.peli = peli;
        tausta = new ImageIcon(Piirtoalusta.class.getResource("/tausta.png")).getImage();
        Image sininen = new ImageIcon(Piirtoalusta.class.getResource("/sininen.png")).getImage();
        Image pinkki = new ImageIcon(Piirtoalusta.class.getResource("/pinkki.png")).getImage();
        Image lime = new ImageIcon(Piirtoalusta.class.getResource("/lime.png")).getImage();
        Image punainen = new ImageIcon(Piirtoalusta.class.getResource("/punainen.png")).getImage();
        Image keltainen = new ImageIcon(Piirtoalusta.class.getResource("/keltainen.png")).getImage();
        Image liila = new ImageIcon(Piirtoalusta.class.getResource("/liila.png")).getImage();
        Image oranssi = new ImageIcon(Piirtoalusta.class.getResource("/oranssi.png")).getImage();
        gameover = new ImageIcon(Piirtoalusta.class.getResource("/gameover.png")).getImage();
        kuvat = new ArrayList<>();
        kuvat.add(sininen);
        kuvat.add(lime);
        kuvat.add(pinkki);
        kuvat.add(keltainen);
        kuvat.add(liila);
        kuvat.add(oranssi);
        kuvat.add(punainen);
    }
    
    @Override
    public void paivita() {
        repaint();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Font f = new Font("Tahoma", Font.BOLD, 18);
        
        g.setFont(f);
        g.drawImage(tausta, 0, 0, this);
        
        for(Pala pala : this.peli.getLiikkuvaKuvio().getPalat()){
             g.drawImage(kuvat.get(pala.getTyyppi()), pala.getX(), pala.getY(), this);
        }
        for(Pala p : this.peli.getKentanPalat()){
            g.drawImage(kuvat.get(p.getTyyppi()), p.getX(), p.getY(), this);
        }
        g.drawString(this.peli.getPisteet(), 250, 30);
        
        if(peli.getPeliOhi()){
            g.drawImage(gameover, 20, 260, this);
        }
    }
    
    
    
}
