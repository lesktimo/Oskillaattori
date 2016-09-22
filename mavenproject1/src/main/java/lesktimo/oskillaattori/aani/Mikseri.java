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
    Add linja1;
    Add linja2;
    Add linja3;

    public Mikseri() {

        ulostulo1 = new LineOut();
        linja1 = new Add();
        linja2 = new Add();
        linja3 = new Add();
    }

    protected void yhdista(UnitOscillator oskillaattori1, UnitOscillator oskillaattori2, UnitOscillator oskillaattori3) {

        oskillaattori1.output.connect(0, linja1.inputA, 0);
        oskillaattori2.output.connect(0, linja2.inputA, 0);
        oskillaattori3.output.connect(0, linja3.inputA, 0);

        lisaa();
    }

    public void lisaa() {
        linja1.output.connect(0, ulostulo1.input, 0);
        linja1.output.connect(0, ulostulo1.input, 1);
        linja2.output.connect(0, ulostulo1.input, 0);
        linja2.output.connect(0, ulostulo1.input, 1);
        linja3.output.connect(0, ulostulo1.input, 0);
        linja3.output.connect(0, ulostulo1.input, 1);

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
