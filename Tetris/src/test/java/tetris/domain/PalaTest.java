
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
        pala.setTyyppi(1);
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
        pala.siirry(20, 20);
        pala.kaanna(60, 60);
        assertEquals(pala.getX(), 90);
        assertEquals(pala.getY(), 30);
    }
    
    @Test
    public void osuuPalaanJosSamassaPaikassa(){
        Pala pala2 = new Pala(10,10);
        assertEquals(pala.osuuPalaan(pala2), true);
    }
    
    @Test
    public void eiOsuPalaanJosEriPaikassa(){
        Pala pala2 = new Pala(20,20);
        assertEquals(pala.osuuPalaan(pala2), false);
    }
    
    @Test
    public void setTyyppiToimii(){
        pala.setTyyppi(2);
        assertEquals(pala.getTyyppi(), 2);
    }
    
    @Test
    public void getTyyppiToimii(){
        assertEquals(pala.getTyyppi(), 1);
    }
    
    @Test
    public void toStringToimii(){
        assertEquals(pala.toString(), "10,10");
    }
}
