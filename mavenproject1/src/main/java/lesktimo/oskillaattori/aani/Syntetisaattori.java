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
    private UnitOscillator osk1;
    private UnitOscillator osk2;
    private UnitOscillator osk3;
    private Mikseri mikseri;
    private boolean on;
    int o1, o2, o3;

    //tässä voidaan määrittää moottorin framerate hertseinä
    public Syntetisaattori(int hz, int o1, int o2, int o3) {
        //stereo sisään ja ulos
        kanavatSisaan = 2;
        kanavatUlos = 2;
        this.o1 = o1;
        this.o2 = o2;
        this.o3 = o3;
        //määritellään syntikan moottori, mikseri ja oskillaattori
        this.masiina = JSyn.createSynthesizer();
        this.mikseri = new Mikseri();
        this.osk1 = valitseOskillaattori(o1);
        this.osk2 = valitseOskillaattori(o2);
        this.osk3 = valitseOskillaattori(o3);
        //alustetaan syntikan äänikortti ja kanavat
        masiina.start(hz, AudioDeviceManager.USE_DEFAULT_DEVICE, kanavatSisaan, AudioDeviceManager.USE_DEFAULT_DEVICE,
                kanavatUlos);
        //lisätään syntikkaan oskillaattori ja mikseri, sekä kytketään ne
        masiina.add(osk1);
        masiina.add(osk2);
        masiina.add(osk3);
        masiina.add(mikseri.ulostulo1);
        mikseri.yhdista(osk1, osk2, osk3);

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

    public UnitOscillator getOsk1() {
        return osk1;
    }

    public UnitOscillator getOsk2() {
        return osk2;
    }

    public UnitOscillator getOsk3() {
        return osk3;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean b) {
        this.on = b;
    }

    public Synthesizer getMasiina() {
        return masiina;
    }

    public static UnitOscillator valitseOskillaattori(int i) {

        UnitOscillator osc = null;

        switch (i) {
            case 1:
                osc = new SiniOskillaattori(440.0, 0.0);
                break;
            case 2:
                osc = new NelikulmaOskillaattori(440.0, 0.0);
                break;
            case 3:
                osc = new SahaOskillaattori(440.0, 0.0);
                break;
        }
        return osc;
    }

}
