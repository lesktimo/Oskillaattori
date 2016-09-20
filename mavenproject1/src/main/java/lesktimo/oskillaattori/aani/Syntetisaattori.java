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

    //tässä voidaan määrittää moottorin framerate hertseinä
    public Syntetisaattori(int hz) {
        //stereo sisään ja ulos
        kanavatSisaan = 2;
        kanavatUlos = 2;
        //määritellään syntikan moottori, mikseri ja oskillaattori
        this.masiina = JSyn.createSynthesizer();
        this.mikseri = new Mikseri();
        this.osk1 = new SiniOskillaattori(440.0, 0.0);
        this.osk2 = new SahaOskillaattori(440.0, 0.0);
        this.osk3 = new NelikulmaOskillaattori(440.0, 0.0);
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

    public void vaihdaOsc(UnitOscillator osc, int i, int j, double dT, double dV) {

        switch (i) {
            case 1:

                masiina.remove(osc);
                UnitOscillator uusiOsk1 = new SiniOskillaattori(dT, dV);
                masiina.add(uusiOsk1);
//                vaihto(uusiOsk1, j);
                

                break;

            case 2:

                masiina.remove(osc);
                UnitOscillator uusiOsk2 = new SahaOskillaattori(dT, dV);
                masiina.add(uusiOsk2);
//                vaihto(uusiOsk2, j);

                break;

            case 3:

                masiina.remove(osc);
                UnitOscillator uusiOsk3= new NelikulmaOskillaattori(dT, dV);
                masiina.add(uusiOsk3);
//                vaihto(uusiOsk3, j);
                
                break;

            default:

                break;
        }
    }

    public void vaihto(UnitOscillator osc, int j) {
        switch (j) {
            case 1:
                mikseri.yhdista1(osc);
                break;
            case 2:
                mikseri.yhdista2(osc);
                break;
            case 3:
                mikseri.yhdista3(osc);
                break;
        }
    }
}
