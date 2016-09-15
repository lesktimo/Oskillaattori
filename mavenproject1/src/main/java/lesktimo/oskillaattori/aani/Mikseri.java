package lesktimo.oskillaattori.aani;

import com.jsyn.unitgen.LineOut;

/**
 *
 * @author lesktimo
 */
public class Mikseri {

    public LineOut ulos;

    public Mikseri() {
        this.ulos = new LineOut();
    }

    public void aloitaMikseri() {
        ulos.start();
    }

    public void lopetaMikseri() {
        ulos.stop();
    }
}
