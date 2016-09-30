package lesktimo.oskillaattori.aani.oskillaattorit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class NelikulmaOskillaattoriTest {

    public NelikulmaOskillaattoriTest() {
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
        NelikulmaOskillaattori osk = new NelikulmaOskillaattori(400.0, 0.5);
        double x = osk.getTaajuus();
        assertEquals(400.0, x, Double.MIN_VALUE);
    }

    @Test
    public void taajuusTasmaa2() {
        NelikulmaOskillaattori osk = new NelikulmaOskillaattori(800.0, 0.5);
        double x = osk.getTaajuus();
        assertEquals(800.0, x, Double.MIN_VALUE);
    }

    @Test
    public void taajuusMuuttuu() {
        NelikulmaOskillaattori osk = new NelikulmaOskillaattori(400.0, 0.5);
        osk.setTaajuus(100);
        double x = osk.getTaajuus();
        assertEquals(100.0, x, Double.MIN_VALUE);
    }

    @Test
    public void voimakkuusTasmaa() {
        NelikulmaOskillaattori osk = new NelikulmaOskillaattori(400.0, 0.5);
        double x = osk.getVoimakkuus();
        assertEquals(0.5, x, Double.MIN_VALUE);
    }

    @Test
    public void voimakkuusMuuttuu() {
        NelikulmaOskillaattori osk = new NelikulmaOskillaattori(400.0, 0.5);
        osk.setVoimakkuus(0.9);
        double x = osk.getVoimakkuus();
        assertEquals(0.9, x, Double.MIN_VALUE);
    }

    @Test
    public void superTaajuusTasmaa() {
        NelikulmaOskillaattori osk = new NelikulmaOskillaattori(400.0, 0.5);
        double x = osk.frequency.get();
        assertEquals(400.0, x, Double.MIN_VALUE);
    }

    @Test
    public void superTaajuusTasmaa2() {
        NelikulmaOskillaattori osk = new NelikulmaOskillaattori(800.0, 0.5);
        double x = osk.frequency.get();
        assertEquals(800.0, x, Double.MIN_VALUE);
    }

    @Test
    public void superTaajuusMuuttuu() {
        NelikulmaOskillaattori osk = new NelikulmaOskillaattori(400.0, 0.5);
        osk.setTaajuus(100);
        double x = osk.frequency.get();
        assertEquals(100.0, x, Double.MIN_VALUE);
    }

    @Test
    public void superVoimakkuusTasmaa() {
        NelikulmaOskillaattori osk = new NelikulmaOskillaattori(400.0, 0.5);
        double x = osk.amplitude.get();
        assertEquals(0.5, x, Double.MIN_VALUE);
    }

    @Test
    public void superVoimakkuusMuuttuu() {
        NelikulmaOskillaattori osk = new NelikulmaOskillaattori(400.0, 0.5);
        osk.setVoimakkuus(0.9);
        double x = osk.amplitude.get();
        assertEquals(0.9, x, Double.MIN_VALUE);
    }
}
