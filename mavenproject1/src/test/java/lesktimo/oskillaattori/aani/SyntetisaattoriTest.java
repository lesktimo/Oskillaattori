package lesktimo.oskillaattori.aani;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import lesktimo.oskillaattori.aani.oskillaattorit.SiniOskillaattori;
import lesktimo.oskillaattori.aani.oskillaattorit.SahaOskillaattori;
import lesktimo.oskillaattori.aani.oskillaattorit.NelikulmaOskillaattori;
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

    @Test
    public void kanavatSisaanTasmaa() {
        Syntetisaattori s = new Syntetisaattori(44100, 1, 1, 1);
        int i = s.getKanavatSisaan();
        assertEquals(i, 2);
    }

    @Test
    public void kanavatUlosTasmaa() {
        Syntetisaattori s = new Syntetisaattori(44100, 1, 1, 1);
        int i = s.getKanavatUlos();
        assertEquals(i, 2);
    }

    @Test
    public void onkoSamaSampleRate() {
        Syntetisaattori s = new Syntetisaattori(44100, 1, 1, 1);
        assertEquals(s.getFrameRate(), 44100);
    }

    @Test
    public void onkoSamaSampleRate2() {
        Syntetisaattori s = new Syntetisaattori(48000, 1, 1, 1);
        assertEquals(s.getFrameRate(), 48000);
    }

    @Test
    public void onkoOikeatOskillaattoritSini1() {
        Syntetisaattori s = new Syntetisaattori(48000, 1, 1, 1);
        SiniOskillaattori osk = new SiniOskillaattori(440, 0);
        assertEquals(osk.getClass(), s.getOsk1().getClass());
    }

    @Test
    public void onkoOikeatOskillaattoritSini2() {
        Syntetisaattori s = new Syntetisaattori(48000, 1, 1, 1);
        SiniOskillaattori osk = new SiniOskillaattori(440, 0);
        assertEquals(osk.getClass(), s.getOsk2().getClass());
    }

    @Test
    public void onkoOikeatOskillaattoritSini3() {
        Syntetisaattori s = new Syntetisaattori(48000, 1, 1, 1);
        SiniOskillaattori osk = new SiniOskillaattori(440, 0);
        assertEquals(osk.getClass(), s.getOsk3().getClass());
    }

    @Test
    public void onkoOikeatOskillaattoritNelikulma1() {
        Syntetisaattori s = new Syntetisaattori(48000, 2, 2, 2);
        NelikulmaOskillaattori osk = new NelikulmaOskillaattori(440, 0);
        assertEquals(osk.getClass(), s.getOsk1().getClass());
    }

    @Test
    public void onkoOikeatOskillaattoritNelikulma2() {
        Syntetisaattori s = new Syntetisaattori(48000, 2, 2, 2);
        NelikulmaOskillaattori osk = new NelikulmaOskillaattori(440, 0);
        assertEquals(osk.getClass(), s.getOsk2().getClass());
    }

    @Test
    public void onkoOikeatOskillaattoritNelikulma3() {
        Syntetisaattori s = new Syntetisaattori(48000, 2, 2, 2);
        NelikulmaOskillaattori osk = new NelikulmaOskillaattori(440, 0);
        assertEquals(osk.getClass(), s.getOsk3().getClass());
    }

    @Test
    public void onkoOikeatOskillaattoritSaha1() {
        Syntetisaattori s = new Syntetisaattori(48000, 3, 3, 3);
        SahaOskillaattori osk = new SahaOskillaattori(440, 0);
        assertEquals(osk.getClass(), s.getOsk1().getClass());
    }

    @Test
    public void onkoOikeatOskillaattoritSaha2() {
        Syntetisaattori s = new Syntetisaattori(48000, 3, 3, 3);
        SahaOskillaattori osk = new SahaOskillaattori(440, 0);
        assertEquals(osk.getClass(), s.getOsk2().getClass());
    }

    @Test
    public void onkoOikeatOskillaattoritSaha3() {
        Syntetisaattori s = new Syntetisaattori(48000, 3, 3, 3);
        SahaOskillaattori osk = new SahaOskillaattori(440, 0);
        assertEquals(osk.getClass(), s.getOsk3().getClass());
    }

    @Test
    public void onPaalla() throws InterruptedException {
        Syntetisaattori s = new Syntetisaattori(48000, 1, 2, 3);
        s.aloita();
        assertEquals(s.isOn(), true);
    }

    @Test
    public void eiOlePaalla() throws InterruptedException {
        Syntetisaattori s = new Syntetisaattori(48000, 1, 2, 3);
        s.aloita();
        s.lopeta();
        assertEquals(s.isOn(), false);
    }

    @Test
    public void kaantaaTaajuudenOikeinPlusYks() {
        Syntetisaattori s = new Syntetisaattori(44100, 1, 2, 3);
        double tarkistus;
        int askel = 1;
        tarkistus = s.kaannaSavelTaajuudeksi(askel);
        assertEquals(tarkistus, 466.16, 0.01);
    }

    @Test
    public void kaantaaTaajuudenOikeinMinusYks() {
        Syntetisaattori s = new Syntetisaattori(44100, 1, 2, 3);
        double tarkistus;
        int askel = -1;
        tarkistus = s.kaannaSavelTaajuudeksi(askel);
        assertEquals(tarkistus, 415.30, 0.01);
    }

    @Test
    public void kaantaaTaajuudenOikeinPlus13() {
        Syntetisaattori s = new Syntetisaattori(44100, 1, 2, 3);
        double tarkistus;
        int askel = 13;
        tarkistus = s.kaannaSavelTaajuudeksi(askel);
        assertEquals(tarkistus, 932.33, 0.01);
    }

    @Test
    public void kaantaaTaajuudenOikeinMinus13() {
        Syntetisaattori s = new Syntetisaattori(44100, 1, 2, 3);
        double tarkistus;
        int askel = -13;
        tarkistus = s.kaannaSavelTaajuudeksi(askel);
        assertEquals(tarkistus, 207.65, 0.01);
    }

}
