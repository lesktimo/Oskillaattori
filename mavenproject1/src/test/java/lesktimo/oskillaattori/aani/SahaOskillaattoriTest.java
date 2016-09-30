package lesktimo.oskillaattori.aani;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import lesktimo.oskillaattori.aani.oskillaattorit.SahaOskillaattori;
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
public class SahaOskillaattoriTest {

    public SahaOskillaattoriTest() {
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
    public void taajuusTasmaa() {
        SahaOskillaattori osk = new SahaOskillaattori(400.0, 0.5);
        double x = osk.getTaajuus();
        assertEquals(400.0, x, Double.MIN_VALUE);
    }

    @Test
    public void taajuusTasmaa2() {
        SahaOskillaattori osk = new SahaOskillaattori(800.0, 0.5);
        double x = osk.getTaajuus();
        assertEquals(800.0, x, Double.MIN_VALUE);
    }

    @Test
    public void taajuusMuuttuu() {
        SahaOskillaattori osk = new SahaOskillaattori(440.0, 0.5);
        osk.setTaajuus(100);
        double x = osk.getTaajuus();
        assertEquals(100.0, x, Double.MIN_VALUE);
    }

    @Test
    public void voimakkuusTasmaa() {
        SahaOskillaattori osk = new SahaOskillaattori(440.0, 0.5);
        double x = osk.getVoimakkuus();
        assertEquals(0.5, x, Double.MIN_VALUE);
    }

    @Test
    public void voimakkuusMuuttuu() {
        SahaOskillaattori osk = new SahaOskillaattori(440.0, 0.5);
        osk.setVoimakkuus(0.9);
        double x = osk.getVoimakkuus();
        assertEquals(0.9, x, Double.MIN_VALUE);
    }

    @Test
    public void superTaajuusTasmaa() {
        SahaOskillaattori osk = new SahaOskillaattori(400.0, 0.5);
        double x = osk.frequency.get();
        assertEquals(400.0, x, Double.MIN_VALUE);
    }

    @Test
    public void superTaajuusTasmaa2() {
        SahaOskillaattori osk = new SahaOskillaattori(800.0, 0.5);
        double x = osk.frequency.get();
        assertEquals(800.0, x, Double.MIN_VALUE);
    }

    @Test
    public void superTaajuusMuuttuu() {
        SahaOskillaattori osk = new SahaOskillaattori(440.0, 0.5);
        osk.setTaajuus(100);
        double x = osk.frequency.get();
        assertEquals(100.0, x, Double.MIN_VALUE);
    }

    @Test
    public void superVoimakkuusTasmaa() {
        SahaOskillaattori osk = new SahaOskillaattori(440.0, 0.5);
        double x = osk.amplitude.get();
        assertEquals(0.5, x, Double.MIN_VALUE);
    }

    @Test
    public void superVoimakkuusMuuttuu() {
        SahaOskillaattori osk = new SahaOskillaattori(440.0, 0.5);
        osk.setVoimakkuus(0.9);
        double x = osk.amplitude.get();
        assertEquals(0.9, x, Double.MIN_VALUE);
    }
}
