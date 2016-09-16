package lesktimo.oskillaattori.aani;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lesktimo
 */
public class SyntetisaattoriTest {

    public SyntetisaattoriTest() {
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

//     TODO add test methods here.
//     The methods must be annotated with annotation @Test. For example:
//    
    @Test
    public void kanavatSisaanTasmaa() {
        Syntetisaattori s = new Syntetisaattori(44100);
        int i = s.getKanavatSisaan();
        assertEquals(i, 2);
    }

    @Test
    public void kanavatUlosTasmaa() {
        Syntetisaattori s = new Syntetisaattori(44100);
        int i = s.getKanavatUlos();
        assertEquals(i, 2);
    }

    @Test
    public void onkoSamaSampleRate() {
        Syntetisaattori s = new Syntetisaattori(44100);
        assertEquals(s.getFrameRate(), 44100);
    }

    @Test
    public void onkoSamaSampleRate2() {
        Syntetisaattori s = new Syntetisaattori(48000);
        assertEquals(s.getFrameRate(), 48000);
    }

}
