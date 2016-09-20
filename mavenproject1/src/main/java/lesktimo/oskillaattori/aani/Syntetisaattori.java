package lesktimo.oskillaattori.aani;

import com.jsyn.JSyn;
import com.jsyn.Synthesizer;
import com.jsyn.devices.AudioDeviceManager;
import com.jsyn.unitgen.UnitOscillator;

/**
 *
 * @author lesktimo
 */
public class Syntetisaattori {

    private int kanavatSisaan;
    private int kanavatUlos;
    private Synthesizer masiina;
    private AaltoOskillaattori osk1;
    private SahaOskillaattori osk2;
    private Mikseri mikseri;
    private boolean on;

    //tässä voidaan määrittää moottorin framerate hertseinä
    public Syntetisaattori(int hz) {
        //stereo sisään ja ulos
        kanavatSisaan = 2;
        kanavatUlos = 2;
        //määritellään syntikan moottori, mikseri ja oskillaattori
        this.masiina = JSyn.createSynthesizer();
        this.mikseri = new Mikseri();
        this.osk1 = new AaltoOskillaattori(440.0, 0.5);
        this.osk2 = new SahaOskillaattori(440.0, 0.5);
        //alustetaan syntikan äänikortti ja kanavat
        masiina.start(hz, AudioDeviceManager.USE_DEFAULT_DEVICE, kanavatSisaan, AudioDeviceManager.USE_DEFAULT_DEVICE,
                kanavatUlos);
        //lisätään syntikkaan oskillaattori ja mikseri, sekä kytketään ne
        masiina.add(osk1);
        masiina.add(osk2);
        masiina.add(mikseri.ulostulo1);
        mikseri.yhdista(osk1, osk2);

    }

    public void aloita() throws InterruptedException {

        try {

            setOn(true);
            mikseri.aloitaMikseri();

        } catch (Exception e) {

            System.out.println("Caught " + e);

        }
    }

    public void lopeta() {
        try {

            setOn(false);

            mikseri.lopetaMikseri();
//          masiina.stop();

        } catch (Exception e) {

            System.out.println("Caught " + e);

        }
    }

    public int getKanavatSisaan() {
        return kanavatSisaan;
    }

    public int getKanavatUlos() {
        return kanavatUlos;
    }

    public int getFrameRate() {
        return masiina.getFrameRate();
    }

    public AaltoOskillaattori getOsk1() {
        return osk1;
    }

    public SahaOskillaattori getOsk2() {
        return osk2;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean b) {
        this.on = b;
    }

}
