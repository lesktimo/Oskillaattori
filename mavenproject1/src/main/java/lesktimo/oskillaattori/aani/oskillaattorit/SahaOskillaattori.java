package lesktimo.oskillaattori.aani.oskillaattorit;

import com.jsyn.unitgen.SawtoothOscillator;

/**
 * Oskillaattori joka tuottaa sahalaitaista ääniaaltoa.
 */
public class SahaOskillaattori extends SawtoothOscillator {

    private double taajuus;
    private double voimakkuus;

    /**
     * Konstruktorille annetaan haluttu taajuus, sekä äänenvoimakkuus.
     *
     * @param taajuus taajuus, jolla oskillaattori sahalaita ilmenee
     * @param voimakkuus äänenvoimakkuus
     */
    public SahaOskillaattori(double taajuus, double voimakkuus) {
        this.taajuus = taajuus;
        this.voimakkuus = voimakkuus;
        super.frequency.set(taajuus);
        super.amplitude.set(voimakkuus);
    }

    /**
     * Aloittaa oskillaattorin.
     */
    public void aloitaOskillaatori() {
        super.start();
    }

    /**
     * Sulkee oskillaattorin.
     */
    public void lopetaOskillaatori() {
        super.stop();
    }

    /**
     * Säätää oskillaattorin taajuuttaa, mikä vaikuttaa sävelkorkeuteen.
     *
     * @param uusiTaajuus Haluttu taajuus.
     */
    public void setTaajuus(double uusiTaajuus) {
        this.taajuus = uusiTaajuus;
        super.frequency.set(taajuus);
    }

    /**
     * Säätää oskillaattorin soiton voimakkuutta.
     *
     * @param voimakkuus Haluttu äänenvoimakkuus.
     */
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
