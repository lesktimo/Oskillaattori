package lesktimo.oskillaattori.aani.oskillaattorit;

import com.jsyn.unitgen.SawtoothOscillator;

public class SahaOskillaattori extends SawtoothOscillator {

    private double taajuus;
    private double voimakkuus;

    public SahaOskillaattori(double taajuus, double voimakkuus) {
        this.taajuus = taajuus;
        this.voimakkuus = voimakkuus;
        super.frequency.set(taajuus);
        super.amplitude.set(voimakkuus);
    }

    public void aloitaOskillaatori() {
        super.start();
    }

    public void lopetaOskillaatori() {
        super.stop();
    }

    public void setTaajuus(double uusiTaajuus) {
        this.taajuus = uusiTaajuus;
        super.frequency.set(taajuus);
    }

    public void setVoimakkuus(double voimakkuus) {
        this.voimakkuus = voimakkuus;
        super.amplitude.set(voimakkuus);
    }

    public double getTaajuus() {
        return taajuus;
    }

    public double getVoimakkuus() {
        return voimakkuus;
    }
}