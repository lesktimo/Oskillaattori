package lesktimo.oskillaattori.aani.apu;

import lesktimo.oskillaattori.aani.Syntetisaattori;

/**
 *
 * @author lesktimo
 */
public class Lukija {

    private Syntetisaattori syntikka;
    private Nuotti[] nuotit;
    boolean paalla;

    public Lukija(Syntetisaattori syntikka) {
        paalla = false;
        this.syntikka = syntikka;
        nuotit = new Nuotti[]{Nuotti.A4, Nuotti.A5, Nuotti.ASHARP4, Nuotti.ASHARP5,
            Nuotti.B4, Nuotti.B5, Nuotti.C4, Nuotti.C5, Nuotti.CSHARP4, Nuotti.CSHARP5,
            Nuotti.D4, Nuotti.D5, Nuotti.DSHARP4, Nuotti.DSHARP5, Nuotti.E4, Nuotti.E5,
            Nuotti.F4, Nuotti.F5, Nuotti.FSHARP4, Nuotti.FSHARP5, Nuotti.G4, Nuotti.G5,
            Nuotti.GSHARP4, Nuotti.GSHARP5};
    }

    public void lue(String syote, boolean paalla) throws InterruptedException {
        
        String isoSyote = syote.toUpperCase();
        String[] nuotitJaPituudet = isoSyote.split(",");

        for (String string : nuotitJaPituudet) {
            String[] yksiNuotti = string.split(":");
            for (Nuotti nuotti : nuotit) {
                if (nuotti.toString().equals(yksiNuotti[0])) {
                    System.out.println("Nuotti: " + yksiNuotti[0] + ", pituus: " + yksiNuotti[1]);
                    syntikka.soitaLuettuNuotti(nuotti.getI(), yksiNuotti[1], paalla);
                    break;
                }
            }
        }
    }
}
