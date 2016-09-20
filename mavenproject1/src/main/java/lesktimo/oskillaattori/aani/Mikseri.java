package lesktimo.oskillaattori.aani;

import com.jsyn.unitgen.Add;
import com.jsyn.unitgen.LineOut;
import com.jsyn.unitgen.UnitOscillator;

/**
 *
 * @author lesktimo
 */
public class Mikseri {

    LineOut ulostulo1;
    Add linja;

    public Mikseri() {

        ulostulo1 = new LineOut();
        linja = new Add();
    }

    protected void yhdista(UnitOscillator oskillaattori1, UnitOscillator oskillaattori2) {
        
        oskillaattori1.output.connect(0, linja.inputA, 0);
        oskillaattori2.output.connect(0, linja.inputB, 0);

        lisaa();
    }

    public void lisaa() {
        linja.output.connect(0, ulostulo1.input, 0);
        linja.output.connect(0, ulostulo1.input, 1);
    }

    public void aloitaMikseri() {
        ulostulo1.start();
    }

    public void lopetaMikseri() {
        ulostulo1.stop();
    }

    public LineOut getUlostulo1() {
        return ulostulo1;

    }

}
