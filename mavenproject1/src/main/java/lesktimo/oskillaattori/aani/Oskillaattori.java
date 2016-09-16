package lesktimo.oskillaattori.aani;

//aluksi sine, eli aallonmuotoinen oskillaattori, myöhemmin vähän lisää

import com.jsyn.ports.UnitInputPort;
import com.jsyn.unitgen.UnitOscillator;
import com.jsyn.unitgen.LineOut;
import com.jsyn.unitgen.SineOscillator;
import com.jsyn.unitgen.UnitGenerator;

/**
 *
 * @author lesktimo
 */
public class Oskillaattori extends SineOscillator {

    private double taajuus;
    private double voimakkuus;
    private String tyyppi;
    private SineOscillator oskillaattori;
    

    public Oskillaattori(String tyyppi, double taajuus, double voimakkuus) {

        this.taajuus = taajuus;
        this.voimakkuus = voimakkuus;
        this.tyyppi = tyyppi;
        this.oskillaattori = luoAaltoOskillaatori(this.tyyppi, this.taajuus, this.voimakkuus);

    }

    public static SineOscillator luoAaltoOskillaatori(String tyyppi, double taajuus, double voimakkuus) {

        SineOscillator luotuOsk = null;
        if (tyyppi.equals("sine")) {
            SineOscillator osk = new SineOscillator(taajuus, voimakkuus);
            luotuOsk = osk;
        }
        return luotuOsk;
    }

    

    public void aloitaOskillaatori() {
        oskillaattori.start();
    }

    public void lopetaOskillaatori() {
        oskillaattori.stop();
    }

}
