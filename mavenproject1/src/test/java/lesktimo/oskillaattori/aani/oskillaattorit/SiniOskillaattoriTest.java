package lesktimo.oskillaattori.aani.oskillaattorit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import lesktimo.oskillaattori.aani.oskillaattorit.SiniOskillaattori;
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
public class SiniOskillaattoriTest {

    public SiniOskillaattoriTest() {
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
        SiniOskillaattori osk = new SiniOskillaattori(400.0, 0.5);
        double x = osk.getTaajuus();
        assertEquals(400.0, x, Double.MIN_VALUE);
    }

    @Test
    public void taajuusTasmaa2() {
        SiniOskillaattori osk = new SiniOskillaattori(800.0, 0.5);
        double x = osk.getTaajuus();
        assertEquals(800.0, x, Double.MIN_VALUE);
    }

    @Test
    public void taajuusMuuttuu() {
        SiniOskillaattori osk = new SiniOskillaattori(440.0, 0.5);
        osk.setTaajuus(100);
        double x = osk.getTaajuus();
        assertEquals(100.0, x, Double.MIN_VALUE);
    }

    @Test
    public void voimakkuusTasmaa() {
        SiniOskillaattori osk = new SiniOskillaattori(440.0, 0.5);
        double x = osk.getVoimakkuus();
        assertEquals(0.5, x, Double.MIN_VALUE);
    }

    @Test
    public void voimakkuusMuuttuu() {
        SiniOskillaattori osk = new SiniOskillaattori(440.0, 0.5);
        osk.setVoimakkuus(0.9);
        double x = osk.getVoimakkuus();
        assertEquals(0.9, x, Double.MIN_VALUE);
    }

    @Test
    public void superTaajuusTasmaa() {
        SiniOskillaattori osk = new SiniOskillaattori(400.0, 0.5);
        double x = osk.frequency.get();
        assertEquals(400.0, x, Double.MIN_VALUE);
    }

    @Test
    public void superTaajuusTasmaa2() {
        SiniOskillaattori osk = new SiniOskillaattori(800.0, 0.5);
        double x = osk.frequency.get();
        assertEquals(800.0, x, Double.MIN_VALUE);
    }

    @Test
    public void superTaajuusMuuttuu() {
        SiniOskillaattori osk = new SiniOskillaattori(440.0, 0.5);
        osk.setTaajuus(100);
        double x = osk.frequency.get();
        assertEquals(100.0, x, Double.MIN_VALUE);
    }

    @Test
    public void superVoimakkuusTasmaa() {
        SiniOskillaattori osk = new SiniOskillaattori(440.0, 0.5);
        double x = osk.amplitude.get();
        assertEquals(0.5, x, Double.MIN_VALUE);
    }

    @Test
    public void superVoimakkuusMuuttuu() {
        SiniOskillaattori osk = new SiniOskillaattori(440.0, 0.5);
        osk.setVoimakkuus(0.9);
        double x = osk.amplitude.get();
        assertEquals(0.9, x, Double.MIN_VALUE);
    }
}
