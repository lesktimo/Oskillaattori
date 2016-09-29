package lesktimo.oskillaattori.aani;

import com.jsyn.ports.UnitInputPort;
import com.jsyn.ports.UnitOutputPort;
import com.jsyn.unitgen.Circuit;
import com.jsyn.unitgen.UnitOscillator;
import static java.lang.Thread.sleep;
import java.util.concurrent.TimeUnit;
import static java.lang.Thread.sleep;

public class Hallintapiiri extends Circuit {

    UnitInputPort taajuus;
    UnitOutputPort ulos;
    UnitOscillator osk1;
    UnitOscillator osk2;
    UnitOscillator osk3;
//    UnitInputPort voimakkuus;

    public Hallintapiiri(UnitOscillator osk1, UnitOscillator osk2, UnitOscillator osk3) {

        this.osk1 = osk1;
        this.osk2 = osk2;
        this.osk3 = osk3;

        this.taajuus = new UnitInputPort(3, "taajuus");
//        this.voimakkuus = new UnitInputPort(3, "voimakkuus");

        super.addPort(taajuus);
//        super.addPort(voimakkuus);

        super.add(osk1);
        taajuus = osk1.frequency;
        super.addPort(taajuus);
        super.add(osk2);
        taajuus = osk2.frequency;
        super.addPort(taajuus);
        super.add(osk3);
        taajuus = osk3.frequency;
        super.addPort(taajuus);

        ulos = osk1.output;
        super.addPort(ulos);
        ulos = osk2.output;
        super.addPort(ulos);
        ulos = osk3.output;
        super.addPort(ulos);

    }

    public void testi() throws InterruptedException {
        System.out.println(super.getPorts());
        taajuus.set(440);
        System.out.println(osk1.frequency);
        TimeUnit.SECONDS.sleep(2);
        taajuus.set(880);
        System.out.println(osk1.frequency);
    }
}
