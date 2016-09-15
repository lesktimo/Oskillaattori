package lesktimo.oskillaattori.aani;

//aluksi sine, eli aallonmuotoinen oskillaatori, myöhemmin vähän lisää
import com.jsyn.unitgen.UnitOscillator;
import com.jsyn.unitgen.LineOut;
import com.jsyn.unitgen.SineOscillator;

/**
 *
 * @author lesktimo
 */
public class Oskillaattori {

    private double taajuus;
    private double voimakkuus;
    private String tyyppi;
    private UnitOscillator oskillaattori;
    private LineOut linja;

    public Oskillaattori(String tyyppi, double taajuus, double voimakkuus, LineOut linja) {

        this.taajuus = taajuus;
        this.voimakkuus = voimakkuus;
        this.tyyppi = tyyppi;
        this.linja = linja;
        this.oskillaattori = luoOskillaatori(this.tyyppi, this.taajuus, this.voimakkuus);

    }

    public static UnitOscillator luoOskillaatori(String tyyppi, double taajuus, double voimakkuus) {

        UnitOscillator palautus = null;
        if (tyyppi.equals("sine")) {
            SineOscillator osk = new SineOscillator(taajuus, voimakkuus);
            palautus = osk;
        }
        return palautus;
    }

    public void yhdista(LineOut linja) {
        oskillaattori.output.connect(0, linja.input, 0);
        oskillaattori.output.connect(0, linja.input, 1);
    }

    public void aloitaOskillaatori() {
        oskillaattori.start();
    }

    public void lopetaOskillaatori() {
        oskillaattori.stop();
    }
    
    
}
