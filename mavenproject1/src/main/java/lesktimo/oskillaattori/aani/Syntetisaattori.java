package lesktimo.oskillaattori.aani;

import com.jsyn.engine.SynthesisEngine;

/**
 *
 * @author lesktimo
 */
public class Syntetisaattori {

    private SynthesisEngine masiina;
    private Oskillaattori osk1;
    private Mikseri mikseri;

    public Syntetisaattori() {

        this.masiina = new SynthesisEngine();
        this.mikseri = new Mikseri();
        Oskillaattori osk1 = new Oskillaattori("sine", 440.0, 0.5, mikseri.ulos);

    }

    public void aloita() throws InterruptedException {

        try {
            masiina.start();
            osk1.yhdista(mikseri.ulos);
            osk1.aloitaOskillaatori();
            mikseri.aloitaMikseri();
            masiina.sleepFor(5.0);
            osk1.lopetaOskillaatori();
            mikseri.lopetaMikseri();
            masiina.stop();
        } catch (Exception e) {
            System.out.println("Caught " + e);
        }
    }
}
