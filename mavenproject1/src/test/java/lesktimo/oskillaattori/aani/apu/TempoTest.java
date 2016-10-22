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

/**
 *
 * @author lesktimo
 */
public class TempoTest {
    
    public TempoTest() {
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
     public void luontiTest() {
         Tempo t = new Tempo();
         assertEquals(t.getTempo(), 120);
     }
     
     @Test
     public void setTempoTest() {
         Tempo t = new Tempo();
         int uusiTempo = 125;
         t.setTempo(uusiTempo);
         assertEquals(t.getTempo(), uusiTempo);
     }
     
     @Test
     public void laskeNuotinPituusToimii1() {
         Tempo t = new Tempo();
         double sekuntia = t.laskeNuotinPituus("1/1");
         assertEquals(sekuntia, 2000, 0);
     }
     @Test
     public void laskeNuotinPituusToimii2() {
         Tempo t = new Tempo();
         double sekuntia = t.laskeNuotinPituus("1/2");
         assertEquals(sekuntia, 1000, 0);
     }
     @Test
     public void laskeNuotinPituusToimii4() {
         Tempo t = new Tempo();
         double sekuntia = t.laskeNuotinPituus("1/4");
         assertEquals(sekuntia, 500, 0);
     }
     @Test
     public void laskeNuotinPituusToimii8() {
         Tempo t = new Tempo();
         double sekuntia = t.laskeNuotinPituus("1/8");
         assertEquals(sekuntia, 250, 0);
     }
     @Test
     public void laskeNuotinPituusToimii16() {
         Tempo t = new Tempo();
         double sekuntia = t.laskeNuotinPituus("1/16");
         assertEquals(sekuntia, 125, 0);
     }
     @Test
     public void laskeNuotinPituusToimii32() {
         Tempo t = new Tempo();
         double sekuntia = t.laskeNuotinPituus("1/32");
         assertEquals(sekuntia, 62.5, 0);
     }
     @Test
     public void laskeNuotinPituusToimiiTemmonmuututtua() {
         Tempo t = new Tempo();
         t.setTempo(60);
         double sekuntia = t.laskeNuotinPituus("1/2");
         assertEquals(sekuntia, 2000, 0);
     }
     
     @Test
     public void laskeNuotinPituusToimiiDefault() {
         Tempo t = new Tempo();
         double sekuntia = t.laskeNuotinPituus("");
         assertEquals(sekuntia, 2000, 0);
     }
}
