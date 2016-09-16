package lesktimo.oskillaattori.aani;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import lesktimo.oskillaattori.aani.AaltoOskillaattori;
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
public class OskillaattoriTest {

    public OskillaattoriTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void taajuusTasmaa() {
        AaltoOskillaattori osk = new AaltoOskillaattori(400.0, 0.5);
        double x = osk.getTaajuus();
        assertEquals(400.0, x, Double.MIN_VALUE);
    }

    @Test
    public void taajuusTasmaa2() {
        AaltoOskillaattori osk = new AaltoOskillaattori(800.0, 0.5);
        double x = osk.getTaajuus();
        assertEquals(800.0, x, Double.MIN_VALUE);
    }

    @Test
    public void taajuusMuuttuu() {
        AaltoOskillaattori osk = new AaltoOskillaattori(440.0, 0.5);
        osk.setTaajuus(100);
        double x = osk.getTaajuus();
        assertEquals(100.0, x, Double.MIN_VALUE);
    }

    @Test
    public void voimakkuusTasmaa() {
        AaltoOskillaattori osk = new AaltoOskillaattori(440.0, 0.5);
        double x = osk.getVoimakkuus();
        assertEquals(0.5, x, Double.MIN_VALUE);
    }

    @Test
    public void voimakkuusMuuttuu() {
        AaltoOskillaattori osk = new AaltoOskillaattori(440.0, 0.5);
        osk.setVoimakkuus(0.9);
        double x = osk.getVoimakkuus();
        assertEquals(0.9, x, Double.MIN_VALUE);
    }

    @Test
    public void superTaajuusTasmaa() {
        AaltoOskillaattori osk = new AaltoOskillaattori(400.0, 0.5);
        double x = osk.frequency.get();
        assertEquals(400.0, x, Double.MIN_VALUE);
    }

    @Test
    public void superTaajuusTasmaa2() {
        AaltoOskillaattori osk = new AaltoOskillaattori(800.0, 0.5);
        double x = osk.frequency.get();
        assertEquals(800.0, x, Double.MIN_VALUE);
    }

    @Test
    public void superTaajuusMuuttuu() {
        AaltoOskillaattori osk = new AaltoOskillaattori(440.0, 0.5);
        osk.setTaajuus(100);
        double x = osk.frequency.get();
        assertEquals(100.0, x, Double.MIN_VALUE);
    }

    @Test
    public void superVoimakkuusTasmaa() {
        AaltoOskillaattori osk = new AaltoOskillaattori(440.0, 0.5);
        double x = osk.amplitude.get();
        assertEquals(0.5, x, Double.MIN_VALUE);
    }

    @Test
    public void superVoimakkuusMuuttuu() {
        AaltoOskillaattori osk = new AaltoOskillaattori(440.0, 0.5);
        osk.setVoimakkuus(0.9);
        double x = osk.amplitude.get();
        assertEquals(0.9, x, Double.MIN_VALUE);
    }
}
