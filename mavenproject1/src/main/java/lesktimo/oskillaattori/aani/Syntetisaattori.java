package lesktimo.oskillaattori.aani;

import com.jsyn.JSyn;
import com.jsyn.Synthesizer;
import com.jsyn.devices.AudioDeviceManager;

/**
 *
 * @author lesktimo
 */
public class Syntetisaattori {

    private int kanavatSisaan;
    private int kanavatUlos;
    private Synthesizer masiina;
    private AaltoOskillaattori osk1;
    private Mikseri mikseri;

    public Syntetisaattori() {
        //stereo sisään ja ulos
        kanavatSisaan = 2;
        kanavatUlos = 2;
        //määritellään syntikan moottori, mikseri ja oskillaattori
        this.masiina = JSyn.createSynthesizer();
        this.mikseri = new Mikseri();
        this.osk1 = new AaltoOskillaattori(440.0, 0.5);
        //alustetaan syntikan äänikortti ja kanavat
        masiina.start(44100, AudioDeviceManager.USE_DEFAULT_DEVICE, kanavatSisaan, AudioDeviceManager.USE_DEFAULT_DEVICE,
                kanavatUlos);
        //lisätään syntikkaan oskillaattori ja mikseri, sekä kytketään ne
        masiina.add(osk1);
        masiina.add(mikseri.ulostulo1);
        mikseri.yhdista(osk1);

    }
    //tässä voidaan määrittää moottorin framerate hertseinä
    public Syntetisaattori(int hZ) {
        //stereo sisään ja ulos
        kanavatSisaan = 2;
        kanavatUlos = 2;
        //määritellään syntikan moottori, mikseri ja oskillaattori
        this.masiina = JSyn.createSynthesizer();
        this.mikseri = new Mikseri();
        this.osk1 = new AaltoOskillaattori(440.0, 0.5);
        //alustetaan syntikan äänikortti ja kanavat
        masiina.start(hZ, AudioDeviceManager.USE_DEFAULT_DEVICE, kanavatSisaan, AudioDeviceManager.USE_DEFAULT_DEVICE,
                kanavatUlos);
        //lisätään syntikkaan oskillaattori ja mikseri, sekä kytketään ne
        masiina.add(osk1);
        masiina.add(mikseri.ulostulo1);
        mikseri.yhdista(osk1);

    }

    public void aloita() throws InterruptedException {

        try {
            //syntikka "soittaa" oskillaattorille määritetyltä taajuudelta 5 sek.
            mikseri.aloitaMikseri();
            masiina.sleepFor(5.0);
            mikseri.lopetaMikseri();
            masiina.stop();

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

}
