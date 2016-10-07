package lesktimo.oskillaattori.aani;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import lesktimo.oskillaattori.aani.oskillaattorit.SiniOskillaattori;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author lesktimo
 */
public class MikseriTest {

    public MikseriTest() {
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
    public void yhdistaminenToimii1() {
        Mikseri m = new Mikseri();
        SiniOskillaattori osk1 = new SiniOskillaattori(440.0, 0.5);
        SiniOskillaattori osk2 = new SiniOskillaattori(440.0, 0.5);
        SiniOskillaattori osk3 = new SiniOskillaattori(440.0, 0.5);
        m.yhdista(osk1, osk2, osk3);
        assertEquals(m.linja1.inputA.isConnected(), true);
    }

    @Test
    public void yhdistaminenToimii2() {
        Mikseri m = new Mikseri();
        SiniOskillaattori osk1 = new SiniOskillaattori(440.0, 0.5);
        SiniOskillaattori osk2 = new SiniOskillaattori(440.0, 0.5);
        SiniOskillaattori osk3 = new SiniOskillaattori(440.0, 0.5);
        m.yhdista(osk1, osk2, osk3);
        assertEquals(m.linja2.inputA.isConnected(), true);
    }

    @Test
    public void yhdistaminenToimii3() {
        Mikseri m = new Mikseri();
        SiniOskillaattori osk1 = new SiniOskillaattori(440.0, 0.5);
        SiniOskillaattori osk2 = new SiniOskillaattori(440.0, 0.5);
        SiniOskillaattori osk3 = new SiniOskillaattori(440.0, 0.5);
        m.yhdista(osk1, osk2, osk3);
        assertEquals(m.linja3.inputA.isConnected(), true);
    }

    @Test
    public void yhdistaminenToimiiOutput() {
        Mikseri m = new Mikseri();
        SiniOskillaattori osk1 = new SiniOskillaattori(440.0, 0.5);
        SiniOskillaattori osk2 = new SiniOskillaattori(440.0, 0.5);
        SiniOskillaattori osk3 = new SiniOskillaattori(440.0, 0.5);
        m.yhdista(osk1, osk2, osk3);
        assertEquals(m.ulostulo1.input.isConnected(), true);
    }

    @Test
    public void getteriToimii() {
        Mikseri m = new Mikseri();
        assertEquals(m.getUlostulo1(), m.ulostulo1);
    }
    
}
