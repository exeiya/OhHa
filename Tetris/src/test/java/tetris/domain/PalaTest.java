
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
}
