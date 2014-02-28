
package tetris;
import javax.swing.SwingUtilities;
import tetris.gui.Kayttoliittyma;
import tetris.peli.Peli;

/**
 * Main pitää huolta pelin käynnistyksestä
 * 
 * @author Krista
 */

public class Main {

    public static void main(String[] args) {
        
        Peli tetris = new Peli();
        
        Kayttoliittyma kayttis = new Kayttoliittyma(tetris);
        SwingUtilities.invokeLater(kayttis);
        
        while(kayttis.getPaivitettava() == null){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex){
                System.out.println("Piirtoalustaa ei ole luotu");
            }
        }
        
        tetris.setPaivitettava(kayttis.getPaivitettava());
        tetris.start();
    }
}