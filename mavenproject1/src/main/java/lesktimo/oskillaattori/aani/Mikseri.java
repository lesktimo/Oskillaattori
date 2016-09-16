package lesktimo.oskillaattori.aani;

import com.jsyn.unitgen.LineOut;

/**
 *
 * @author lesktimo
 */
//tämä luokka ole vielä käytössä syntetisaattorissa
public class Mikseri {

    LineOut ulostulo1;

    public Mikseri() {

        ulostulo1 = new LineOut();

    }

    protected void yhdista(AaltoOskillaattori oskillaattori) {
        oskillaattori.output.connect(0, ulostulo1.input, 0);
        oskillaattori.output.connect(0, ulostulo1.input, 1);
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
