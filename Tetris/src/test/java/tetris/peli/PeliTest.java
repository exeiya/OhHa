
package tetris.peli;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.domain.*;

public class PeliTest {
    
    Peli peli;
    
    public PeliTest() {
    }
    
    @Before
    public void setUp() {
        this.peli = new Peli();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void peliKaynnistyy(){
        peli.start();
        assertEquals(peli.isRunning(), true);
    }
    
    @Test
    public void palauttaaJatkuukoOikein(){
        assertEquals(peli.jatkuu(), true);
    }
    
    @Test
    public void getPeliOhiPalauttaaOikein(){
        assertEquals(peli.getPeliOhi(), false);
    }
            
    @Test
    public void peliOhiToimii(){
        peli.peliOhi();
        assertEquals(peli.jatkuu(), false);
        assertEquals(peli.getPeliOhi(), true);
        assertEquals(peli.isRunning(), false);
    }
    
    @Test
    public void aloitaUudelleenToimii(){
        peli.aloitaUudelleen();
        assertEquals(peli.getKentanPalat().size(), 0);
        assertEquals(peli.getPeliOhi(), false);
        assertEquals(peli.jatkuu(), true);
        assertEquals(peli.isRunning(), true);
        assertEquals(peli.getPisteet(), "0");
    }
    
    @Test
    public void lisaaKuvioToimii(){
        peli.lisaaKuvio();
        assertNotNull(peli.getLiikkuvaKuvio());
    }
    
    @Test
    public void lisaaKuvioKentanPaloihinToimii(){
        peli.lisaaKentanPaloihin();
        assertNotNull(peli.getKentanPalat());
    }
    
    
    
}
