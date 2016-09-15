package lesktimo.oskillaattori.aani;

import com.jsyn.JSyn;
import com.jsyn.Synthesizer;
import com.jsyn.devices.AudioDeviceManager;
import com.jsyn.unitgen.LineOut;
import com.jsyn.unitgen.SineOscillator;
import com.jsyn.unitgen.UnitOscillator;

/**
 *
 * @author lesktimo
 */
public class Syntetisaattori {

    private int kanavatSisaan;
    private int kanavatUlos;
    private Synthesizer masiina;
    private UnitOscillator osk1;
    private Mikseri mikseri;
    private LineOut out;

    public Syntetisaattori() {
        kanavatSisaan = 2;
        kanavatUlos = 2;
        this.masiina = JSyn.createSynthesizer();
//      this.mikseri = new Mikseri();

//      tuli pieniä ongelmia aluksi näiden luokkien kanssa,
//      joten melkein kaikki toiminnallisuus on tällä hetkellä tässä luokassa,
//      jotta se toimisi. Alan pikku hiljaa siirtämään mikserille sen omaa
//      toimintaansa, kuten myös oskillaattorille

    }

    public void aloita() throws InterruptedException {
        try {
            masiina.start(44100, AudioDeviceManager.USE_DEFAULT_DEVICE, kanavatSisaan, AudioDeviceManager.USE_DEFAULT_DEVICE,
                    kanavatUlos);
            masiina.add(osk1 = new SineOscillator(440.0, 0.5));
            masiina.add(out = new LineOut());
            osk1.output.connect(0, out.input, 0);
            osk1.start();
            out.start();
            masiina.sleepFor(5.0);
            osk1.stop();
            out.stop();
            masiina.stop();
        } catch (Exception e) {
            System.out.println("Caught " + e);
        }
    }
}
