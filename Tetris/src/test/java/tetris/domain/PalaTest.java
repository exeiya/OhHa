
package tetris.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PalaTest {
    
    Pala pala;
    
    public PalaTest() {
    }
    
    @Before
    public void setUp() {
        pala = new Pala(10, 10);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void getXToimii() {
        assertEquals(pala.getX(), 10);
    }
    
    @Test
    public void getYToimii() {
        assertEquals(pala.getY(), 10);
    }
    
    @Test
    public void palaSiirtyyOikein(){
        pala.siirry(30, 20);
        assertEquals(pala.getY(), 30);
        assertEquals(pala.getX(), 40);
    }
    
    @Test
    public void palaOsuuPohjaanPalauttaaTrue(){
        pala.siirry(0, 560);
        assertEquals(pala.osuuPohjaan(), true);
        pala.siirry(0, 40);
        assertEquals(pala.osuuPohjaan(), true);
    }
    
    @Test
    public void palaEiOsuPohjaan(){
        pala.siirry(0, 300);
        assertEquals(pala.osuuPohjaan(), false);
    }
    
    @Test
    public void palaOsuuReunaan(){
        pala.siirry(-10, 0);
        assertEquals(pala.osuuReunaan(0), true);
    }
    
    @Test
    public void palaEiOsuReunaan(){
        assertEquals(pala.osuuReunaan(0), false);
    }
    
    @Test
    public void kaannaToimii(){
        
    }
    
    @Test
    public void toStringToimii(){
        assertEquals(pala.toString(), "10,10");
    }
}
