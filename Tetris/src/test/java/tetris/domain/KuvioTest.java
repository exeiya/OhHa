package tetris.domain;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.Suunta;

public class KuvioTest {
    
    Kuvio kuvio;
    
    public KuvioTest() {
    }
    
    
    @Before
    public void setUp() {
        kuvio = new Kuvio();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void setSuuntaToimii(){
        kuvio.setSuunta(Suunta.VASEN);
        assertEquals(kuvio.getSuunta(), Suunta.VASEN);
    }
    
    @Test
    public void getSuuntaToimii(){
        assertEquals(kuvio.getSuunta(), Suunta.ALAS);
    }
    
    @Test
    public void lisaaPalaToimii(){
        this.kuvio.lisaaPala(new Pala(0,0));
    }
    
    @Test
    public void getPalatToimii(){
        kuvio.lisaaPala(new Pala(0,0));
        kuvio.lisaaPala(new Pala(30,30));
        assertEquals(kuvio.getPalat().get(0).getY(), 0);
        assertEquals(kuvio.getPalat().get(1).getY(), 30);
        assertEquals(kuvio.getPalat().size(), 2);
    }
    
    @Test
    public void siirryToimiiKunSuuntaAlas(){
        kuvio.lisaaPala(new Pala(0,0));
        kuvio.lisaaPala(new Pala(30,30));
        kuvio.siirry();
        assertEquals(kuvio.getPalat().get(0).getY(), 30);
        assertEquals(kuvio.getPalat().get(1).getY(), 60);
    }
    
    
    
    
}
