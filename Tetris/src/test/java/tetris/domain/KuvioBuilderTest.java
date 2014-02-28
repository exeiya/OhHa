
package tetris.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class KuvioBuilderTest {
    
    KuvioBuilder builder;
    
    public KuvioBuilderTest() {
    }
    
    @Before
    public void setUp() {
        this.builder = new KuvioBuilder();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void uusiKuvioToimiiArvolla1(){
        
    }
    
    @Test
    public void asetaPalatLisaaPalat(){
        Kuvio kuvio = new Kuvio();
        int[] koordinaatit = {0, 30, 30, 60};
        builder.asetaPalat(kuvio, koordinaatit);
        assertEquals(kuvio.getPalat().size(), 2);
        assertEquals(kuvio.getPalat().get(0).getX(), 0);
        assertEquals(kuvio.getPalat().get(0).getY(), 30);
        assertEquals(kuvio.getPalat().get(1).getX(), 30);
        assertEquals(kuvio.getPalat().get(1).getY(), 60);
    }
}
