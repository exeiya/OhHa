
package tetris.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import tetris.peli.Peli;

public class Kayttoliittyma implements Runnable{
    
    private JFrame frame;
    private Peli peli;
    private Piirtoalusta piirtoalusta;
    
    public Kayttoliittyma(Peli peli){
        this.peli = peli;
    }
    
    @Override
    public void run() {
        frame = new JFrame("Tetris");
        
        frame.setPreferredSize(new Dimension(350,650));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void luoKomponentit(Container container){
        piirtoalusta = new Piirtoalusta(this.peli);
        container.add(piirtoalusta);
        Nappaimistonkuuntelija nk = new Nappaimistonkuuntelija(peli, piirtoalusta);
        getFrame().addKeyListener(nk);
    }

    public JFrame getFrame() {
        return frame;
    }
    
    public Paivitettava getPaivitettava(){
        return this.piirtoalusta;
    }
    
}
