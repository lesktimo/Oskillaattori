/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesktimo.oskillaattori.aani.apu;

import lesktimo.oskillaattori.aani.Syntetisaattori;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lesktimo
 */
public class LukijaTest {

    public LukijaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void lukeekoLukijaOikein() {
        Syntetisaattori s = new Syntetisaattori(44100, 1, 2, 3);
        Lukija l = new Lukija(s);
        String[] testi;
        String[] varmistus = {"C4:1/8","FSHARP5:1/16"};
        String testisyote = "c4 : 1 / 8  ,  fsharp5 : 1/16";
        testi = l.lueTeksti(testisyote);
        Assert.assertArrayEquals(varmistus, testi);
    }
    
    @Test
    public void soittaakoLukijaOikein() throws InterruptedException {
        Syntetisaattori s = new Syntetisaattori(44100, 1, 2, 3);
        Lukija l = new Lukija(s);
        boolean testiB = true;
        String[] testi;
        String testisyote = "c4 : 1 / 8  ,  fsharp5 : 1/16";
        testi = l.lueTeksti(testisyote);
        l.soita(testisyote, testiB);
        assertEquals(true, testiB);
    }
    
    @Test
    public void soittaakoLukijaOikein2() throws InterruptedException {
        Syntetisaattori s = new Syntetisaattori(44100, 1, 2, 3);
        Lukija l = new Lukija(s);
        boolean testiB = false;
        String[] testi;
        String testisyote = "c4 : 1 / 8  ,  fsharp5 : 1/16";
        testi = l.lueTeksti(testisyote);
        l.soita(testi[0], testiB);
        assertEquals(false, testiB);
    }
    
    @Test
    public void lukeekoLukijaOikeinTyhja() throws InterruptedException {
        Syntetisaattori s = new Syntetisaattori(44100, 1, 2, 3);
        Lukija l = new Lukija(s);
        String[] testi;
        String[] varmistus = {};
        String testisyote = "";
        testi = l.lueTeksti(testisyote);
        Assert.assertArrayEquals(testi, varmistus);
    }
    
    @Test
    public void soittaakoLukijaOikeinTyhja() throws InterruptedException {
        Syntetisaattori s = new Syntetisaattori(44100, 1, 2, 3);
        Lukija l = new Lukija(s);
        String testisyote = "";
        l.lue(testisyote, true);
        assertEquals(testisyote, "");
    }
      
       
}