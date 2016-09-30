package lesktimo.oskillaattori.aani;

import lesktimo.oskillaattori.aani.oskillaattorit.SahaOskillaattori;
import lesktimo.oskillaattori.aani.oskillaattorit.NelikulmaOskillaattori;
import lesktimo.oskillaattori.aani.oskillaattorit.SiniOskillaattori;
import com.jsyn.JSyn;
import com.jsyn.Synthesizer;
import com.jsyn.devices.AudioDeviceManager;
import com.jsyn.instruments.SubtractiveSynthVoice;
import com.jsyn.unitgen.Circuit;
import com.jsyn.unitgen.UnitOscillator;
import com.jsyn.util.VoiceAllocator;
import com.softsynth.shared.time.TimeStamp;

public class Syntetisaattori {

    private int kanavatSisaan;
    private int kanavatUlos;
    private Synthesizer masiina;
    private UnitOscillator osk1, osk2, osk3;
    private VoiceAllocator allokaattori1, allokaattori2, allokaattori3;
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

    public Mikseri getMikseri() {
        return mikseri;
    }

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

    public void yhdistaAanet() {
        SubtractiveSynthVoice[] voices1 = new SubtractiveSynthVoice[24];
        for (int i = 0; i < 24; i++) {
            SubtractiveSynthVoice voice1 = new SubtractiveSynthVoice();
            masiina.add(voice1);
            osk1.getOutput().connect(voice1.pitchModulation);
            voice1.getOutput().connect(0, mikseri.ulostulo1.input, 0);
            voice1.getOutput().connect(0, mikseri.ulostulo1.input, 1);
            voices1[i] = voice1;
        }
        SubtractiveSynthVoice[] voices2 = new SubtractiveSynthVoice[24];
        for (int i = 0; i < 24; i++) {
            SubtractiveSynthVoice voice2 = new SubtractiveSynthVoice();
            masiina.add(voice2);
            osk2.getOutput().connect(voice2.pitchModulation);
            voice2.getOutput().connect(0, mikseri.ulostulo1.input, 0);
            voice2.getOutput().connect(0, mikseri.ulostulo1.input, 1);
            voices2[i] = voice2;
        }
        SubtractiveSynthVoice[] voices3 = new SubtractiveSynthVoice[24];
        for (int i = 0; i < 24; i++) {
            SubtractiveSynthVoice voice3 = new SubtractiveSynthVoice();
            masiina.add(voice3);
            osk3.getOutput().connect(voice3.pitchModulation);
            voice3.getOutput().connect(0, mikseri.ulostulo1.input, 0);
            voice3.getOutput().connect(0, mikseri.ulostulo1.input, 1);
            voices3[i] = voice3;
        }
        allokaattori1 = new VoiceAllocator(voices1);
        allokaattori2 = new VoiceAllocator(voices2);
        allokaattori3 = new VoiceAllocator(voices3);
        
        System.out.println(allokaattori1.getSynthesizer());
        System.out.println(allokaattori2.getSynthesizer());
        System.out.println(allokaattori3.getSynthesizer());
        System.out.println(allokaattori1.getVoiceCount());
        System.out.println(allokaattori2.getVoiceCount());
        System.out.println(allokaattori3.getVoiceCount());
    }

    public void noteOff(VoiceAllocator allokaattori, int channel, int nuotinNumero, int voima) {
        allokaattori.noteOff(nuotinNumero, masiina.createTimeStamp());
    }

    public void noteOn(VoiceAllocator allocator, int channel, int nuotinNumero, int voima) {
        double taajuus = kaannaSavelTaajuudeksi(nuotinNumero);
        double voimakkuus = voima / (4 * 128.0);
        TimeStamp timeStamp = masiina.createTimeStamp();
        allocator.noteOn(nuotinNumero+9, taajuus, voimakkuus, timeStamp);
        
    }

    double kaannaSavelTaajuudeksi(int askel) {
        final double a4 = 440.0;
        return a4 * Math.pow(2.0, (askel / 12.0));
    }

    public VoiceAllocator getAllokaattori1() {
        return allokaattori1;
    }

    public VoiceAllocator getAllokaattori2() {
        return allokaattori2;
    }

    public VoiceAllocator getAllokaattori3() {
        return allokaattori3;
    }
}
