package lesktimo.oskillaattori.aani;

import lesktimo.oskillaattori.aani.oskillaattorit.SahaOskillaattori;
import lesktimo.oskillaattori.aani.oskillaattorit.NelikulmaOskillaattori;
import lesktimo.oskillaattori.aani.oskillaattorit.SiniOskillaattori;
import com.jsyn.JSyn;
import com.jsyn.Synthesizer;
import com.jsyn.devices.AudioDeviceManager;
import com.jsyn.instruments.SubtractiveSynthVoice;
import com.jsyn.unitgen.UnitOscillator;
import com.jsyn.util.VoiceAllocator;
import com.softsynth.shared.time.TimeStamp;

/**
 * Syntetisaattori-luokka sitoo yhteen koko toiminnallisuuden, oskillaattorit ja
 * mikserin mukaanlukien.
 */
public class Syntetisaattori {

    private int kanavatSisaan;
    private int kanavatUlos;
    private Synthesizer masiina;
    private UnitOscillator osk1, osk2, osk3;
    private VoiceAllocator allokaattori;
    private Mikseri mikseri;
    private boolean on;

    int o1, o2, o3;
    int nuotit;

    private final int max;

    //tässä voidaan määrittää moottorin framerate hertseinä
    /**
     * Syntetisaattorin konstruktori saa parametreikseen sample/framerate
     * hertsimäärän, sekä kolme kokonaislukua, jotka vaikuttavat
     * oskillaattorivalintoihin.
     *
     * @param hz hertsit, ns. sämpläys taajuus, eli kuinka monta sämpleä kone
     * käsittelee per sekunti.
     * @param o1 ensimmäisen oskillaattorin määräävä valinta
     * @param o2 toisen oskillaattorin määräävä valinta
     * @param o3 kolmannen oskillaattorin määräävä valinta
     */
    public Syntetisaattori(int hz, int o1, int o2, int o3) {
        //stereo sisään ja ulos
        kanavatSisaan = 2;
        kanavatUlos = 2;
        nuotit = 24;
        this.o1 = o1;
        this.o2 = o2;
        this.o3 = o3;
        max = 24;
        //määritellään syntikan moottori, mikseri ja oskillaattorit, ja hallintapiiri
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
        masiina.add(mikseri.ulostulo2);
        mikseri.yhdista(osk1, osk2, osk3);
    }

    /**
     * Hyödyntää mikserin aloita metodia, joka käynnistää siihen kytketyt
     * "laitteet".
     *
     * @throws InterruptedException mikäli käynnistys keskeytyy
     */
    public void aloita() throws InterruptedException {
        try {
            setOn(true);
            mikseri.aloitaMikseri();
        } catch (Exception e) {
            System.out.println("Caught " + e);
        }
    }

    /**
     * Sammuttaa mikseriin kytketyt "laitteet" hyodyntäen mikserin
     * lopetus-metodia.
     */
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

    public Mikseri getMikseri() {
        return mikseri;
    }

    /**
     * Tässä metodi alustaa oskillaattorien aaltomuodot käyttäjänvalinnan mukaan
     * GUI:sta.
     *
     * @param i valintamuuttuja
     * @return palauttaa valitun oskillaattorin
     */
    public static UnitOscillator valitseOskillaattori(int i) {
        UnitOscillator osk = null;
        switch (i) {
            case 1:
                osk = new SiniOskillaattori(440.0, 0.0);
                break;
            case 2:
                osk = new NelikulmaOskillaattori(440.0, 0.0);
                break;
            case 3:
                osk = new SahaOskillaattori(440.0, 0.0);
                break;
        }
        return osk;
    }

    /**
     * Yhdistää oskillaattorien äänet yhdeksi instumentiksi.
     *
     * @throws InterruptedException Mikäli aloita-metodi keskeytyy.
     */
    public void yhdistaAanet() throws InterruptedException {
        SubtractiveSynthVoice[] voices = new SubtractiveSynthVoice[nuotit];
        for (int i = 0; i < nuotit; i++) {
            SubtractiveSynthVoice voice = new SubtractiveSynthVoice();
            masiina.add(voice);
            osk1.output.disconnectAll();
            osk2.output.disconnectAll();
            osk3.output.disconnectAll();
            osk1.output.connect(voice.pitchModulation);
            osk2.output.connect(voice.pitchModulation);
            osk3.output.connect(voice.pitchModulation);
            voice.getOutput().connect(0, mikseri.linja4.inputA, 0);
            voices[i] = voice;
        }

        allokaattori = new VoiceAllocator(voices);
        aloita();

    }

    /**
     * Lopettaa halutun nuotin soiton.
     *
     * @param nuotinNumero Halutun nuotin numero, jotta metodi osaa sammuttaa
     * oikean nuotin soiton.
     */
    public void noteOff(int nuotinNumero) {
        allokaattori.noteOff(nuotinNumero + 9, masiina.createTimeStamp());
    }

    /**
     * Soittaa halutun nuotin.
     *
     * @param nuotinNumero Halutun nuotin numero, jotta metodi osaa soittaa
     * oikean sävelen.
     * @param voima Halutun nuotin voimakkuus.
     */
    public void noteOn(int nuotinNumero, int voima) {
        double taajuus = kaannaSavelTaajuudeksi(nuotinNumero);
        double voimakkuus = voima / (4 * 128.0);
        TimeStamp timeStamp = masiina.createTimeStamp();
        allokaattori.noteOn(nuotinNumero + 9, taajuus, voimakkuus, timeStamp);

    }

    /**
     * Metodi kääntää sille annetun nuotin arvon halutulle taajuudelle.
     *
     * @param askel nuotin relaatio A4 nuottiin
     * @return palauttaa muunnetun taajuudeen double-arvon
     */
    double kaannaSavelTaajuudeksi(int askel) {
        final double a4 = 440.0;
        return a4 * Math.pow(2.0, (askel / 12.0));
    }

    public VoiceAllocator getAllokaattori() {
        return allokaattori;
    }

}
