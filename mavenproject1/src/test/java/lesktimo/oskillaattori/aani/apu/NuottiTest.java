/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesktimo.oskillaattori.aani.apu;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class NuottiTest {

    Nuotti n;

    public NuottiTest() {
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
    public void toimiikoGetIC4() {
        assertEquals(Nuotti.C4.getI(), -9);
    }

    @Test
    public void toimiikoGetIC5() {
        assertEquals(Nuotti.C5.getI(), 3);
    }

    @Test
    public void toimiikoGetICs4() {
        assertEquals(Nuotti.CSHARP4.getI(), -8);
    }

    @Test
    public void toimiikoGetICs5() {
        assertEquals(Nuotti.CSHARP5.getI(), 4);
    }

    @Test
    public void toimiikoGetID4() {
        assertEquals(Nuotti.D4.getI(), -7);
    }

    @Test
    public void toimiikoGetID5() {
        assertEquals(Nuotti.D5.getI(), 5);
    }

    @Test
    public void toimiikoGetIDs4() {
        assertEquals(Nuotti.DSHARP4.getI(), -6);
    }

    @Test
    public void toimiikoGetIDs5() {
        assertEquals(Nuotti.DSHARP5.getI(), 6);
    }

    @Test
    public void toimiikoGetIE4() {
        assertEquals(Nuotti.E4.getI(), -5);
    }

    @Test
    public void toimiikoGetIE5() {
        assertEquals(Nuotti.E5.getI(), 7);
    }

    @Test
    public void toimiikoGetIF4() {
        assertEquals(Nuotti.F4.getI(), -4);
    }

    @Test
    public void toimiikoGetIF5() {
        assertEquals(Nuotti.F5.getI(), 8);
    }

    @Test
    public void toimiikoGetIFs4() {
        assertEquals(Nuotti.FSHARP4.getI(), -3);
    }

    @Test
    public void toimiikoGetIFs5() {
        assertEquals(Nuotti.FSHARP5.getI(), 9);
    }

    @Test
    public void toimiikoGetIG4() {
        assertEquals(Nuotti.G4.getI(), -2);
    }

    @Test
    public void toimiikoGetIG5() {
        assertEquals(Nuotti.G5.getI(), 10);
    }

    @Test
    public void toimiikoGetIGs4() {
        assertEquals(Nuotti.GSHARP4.getI(), -1);
    }

    @Test
    public void toimiikoGetIGs5() {
        assertEquals(Nuotti.GSHARP5.getI(), 11);
    }

    @Test
    public void toimiikoGetIA4() {
        assertEquals(Nuotti.A4.getI(), 0);
    }

    @Test
    public void toimiikoGetIA5() {
        assertEquals(Nuotti.A5.getI(), 12);
    }

    @Test
    public void toimiikoGetIAs4() {
        assertEquals(Nuotti.ASHARP4.getI(), 1);
    }

    @Test
    public void toimiikoGetIAs5() {
        assertEquals(Nuotti.ASHARP5.getI(), 13);
    }

    @Test
    public void toimiikoGetIB4() {
        assertEquals(Nuotti.B4.getI(), 2);
    }

    @Test
    public void toimiikoGetIB5() {
        assertEquals(Nuotti.B5.getI(), 14);
    }
}
