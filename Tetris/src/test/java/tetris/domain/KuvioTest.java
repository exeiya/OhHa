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
        kuvio.setTyyppi(1);
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
    public void getTyyppiToimii(){
        assertEquals(kuvio.getTyyppi(), 1);
    }
    
    @Test
    public void setTyyppiToimii(){
        kuvio.setTyyppi(3);
        assertEquals(kuvio.getTyyppi(), 3);
    }
    
    @Test
    public void lisaaPalaToimii(){
        Pala pala = new Pala(0,0);
        this.kuvio.lisaaPala(pala);
        assertEquals(kuvio.getPalat().size(), 1);
        assertEquals(kuvio.getPalat().get(0), pala);
        assertEquals(kuvio.getPalat().get(0).getTyyppi(), 1);
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
    public void siirraPalatSiirtaaPaloja(){
        kuvio.lisaaPala(new Pala(30,30));
        kuvio.lisaaPala(new Pala(30,0));
        kuvio.siirraPalat(10, 10);
        assertEquals(kuvio.getPalat().get(0).getY(), 40);
        assertEquals(kuvio.getPalat().get(0).getX(), 40);
        assertEquals(kuvio.getPalat().get(1).getY(), 10);
        assertEquals(kuvio.getPalat().get(1).getX(), 40);
    }
    
    @Test
    public void siirryToimiiKunSuuntaAlas(){
        kuvio.lisaaPala(new Pala(0,0));
        kuvio.lisaaPala(new Pala(30,30));
        kuvio.siirry();
        assertEquals(kuvio.getPalat().get(0).getY(), 30);
        assertEquals(kuvio.getPalat().get(1).getY(), 60);
    }
    
    @Test
    public void siirryToimiiKunSuuntaOikea(){
        kuvio.lisaaPala(new Pala(0,0));
        kuvio.lisaaPala(new Pala(30,30));
        kuvio.setSuunta(Suunta.OIKEA);
        kuvio.siirry();
        assertEquals(kuvio.getPalat().get(0).getY(), 0);
        assertEquals(kuvio.getPalat().get(0).getX(), 30);
        assertEquals(kuvio.getPalat().get(1).getY(), 30);
        assertEquals(kuvio.getPalat().get(1).getX(), 60);
    }
    
    @Test
    public void siirryToimiiKunSuuntaVasen(){
        kuvio.lisaaPala(new Pala(0,0));
        kuvio.lisaaPala(new Pala(30,30));
        kuvio.setSuunta(Suunta.VASEN);
        kuvio.siirry();
        assertEquals(kuvio.getPalat().get(0).getY(), 0);
        assertEquals(kuvio.getPalat().get(0).getX(), -30);
        assertEquals(kuvio.getPalat().get(1).getY(), 30);
        assertEquals(kuvio.getPalat().get(1).getX(), 0);
    }
    
    @Test
    public void osuuPohjaan(){
        kuvio.lisaaPala(new Pala(0, 570));
        assertEquals(kuvio.osuuPohjaan(), true);
    }
    
    @Test
    public void eiOsuPohjaanKentalla(){
        kuvio.lisaaPala(new Pala(0, 0));
        assertEquals(kuvio.osuuPohjaan(), false);
    }
    
    @Test
    public void osuuReunaan(){
        kuvio.lisaaPala(new Pala(90, 0));
        assertEquals(kuvio.osuuReunaan(90), true);
    }
    
    @Test
    public void eiOsuReunoihin(){
        kuvio.lisaaPala(new Pala(30, 0));
        assertEquals(kuvio.osuuReunaan(90), false);
    }
    
    @Test
    public void luoTestikuvioLuoKopion(){
        Pala pala = new Pala(40,40);
        kuvio.lisaaPala(pala);
        Kuvio testik = kuvio.luoTestikuvio();
        assertEquals(testik.getPalat().get(0).getY(), 40);
        assertEquals(testik.getPalat().get(0).getX(), 40);
    }
    
    @Test
    public void kuvionPalatOsuuToiseen(){
        kuvio.lisaaPala(new Pala(10,10));
        kuvio.lisaaPala(new Pala(60,60));
        Pala pala = new Pala(10,40);
        assertEquals(kuvio.osuuPalaan(pala), true);
    }
    
    @Test
    public void kuvionPalatEiOsuToiseen(){
        kuvio.lisaaPala(new Pala(10,10));
        kuvio.lisaaPala(new Pala(10,40));
        Pala pala = new Pala(90,90);
        assertEquals(kuvio.osuuPalaan(pala), false);
    }
    
    
    
}
