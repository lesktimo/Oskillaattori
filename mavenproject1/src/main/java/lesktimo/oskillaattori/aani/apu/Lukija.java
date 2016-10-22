package lesktimo.oskillaattori.aani.apu;

import lesktimo.oskillaattori.aani.Syntetisaattori;

/**
 * Lukee käyttäjän syotetta UI:sta keräten nuotteja soitettavaksi.
 *
 */
public class Lukija {

    private Syntetisaattori syntikka;
    private Nuotti[] nuotit;
    boolean paalla;

    /**
     * Alustaa lukijalle käytettävän syntetisaattorin ja nuotit.
     *
     * @param syntikka Käytössä oleva syntetisaattori
     */
    public Lukija(Syntetisaattori syntikka) {
        paalla = false;
        this.syntikka = syntikka;
        nuotit = new Nuotti[]{Nuotti.A4, Nuotti.A5, Nuotti.ASHARP4, Nuotti.ASHARP5,
            Nuotti.B4, Nuotti.B5, Nuotti.C4, Nuotti.C5, Nuotti.CSHARP4, Nuotti.CSHARP5,
            Nuotti.D4, Nuotti.D5, Nuotti.DSHARP4, Nuotti.DSHARP5, Nuotti.E4, Nuotti.E5,
            Nuotti.F4, Nuotti.F5, Nuotti.FSHARP4, Nuotti.FSHARP5, Nuotti.G4, Nuotti.G5,
            Nuotti.GSHARP4, Nuotti.GSHARP5};
    }

    /**
     * Lukee syötteestä nuotteja ja niiden pituuksia heittäen ne eteenpäin
     * syntetisaattorille soitettavaksi.
     *
     * @param syote käyttäjän antama syöte
     * @param paalla boolean arvo, jolla testataan pitääkö soittaa vai lopettaa
     * soitto
     * @throws InterruptedException Heittää virhesanoman mikäli juoksu
     * keskeytyy.
     */
    public void lue(String syote, boolean paalla) throws InterruptedException {

        String[] nuotitJaPituudet = lueTeksti(syote);
        if (nuotitJaPituudet.length >= 1) {
            for (String string : nuotitJaPituudet) {
                soita(string, paalla);
            }
        }
    }

    /**
     * Apumetodi Lue -metodille, joka käy tekstin läpi, ja jakaa sen osiin.
     *
     * @param syote Annettu tekstisyöte.
     * @return palauttaa läpikäydyn tekstin.
     */
    public String[] lueTeksti(String syote) {
        if (!syote.isEmpty()) {
            String isoSyote = syote.toUpperCase().trim();
            String[] erottelu = isoSyote.split(",");
            String[] palautus = erottelu;
            int i = 0;
            for (String string : erottelu) {
                String x = string.replaceAll("\\s+", "");
                palautus[i] = x;
                i++;
            }
            return palautus;
        } else {
            String[] tyhja = {};
            return tyhja;
        }
    }

    /**
     * Toinen apumetodi Lue-metodille joka soittattaa syntetisaattorilla luetut
     * nuotit.
     *
     * @param syote Annettu syöte.
     * @param paalla Pitääkö soittaa vai lopettaa soitto.
     * @throws InterruptedException Mikäli juoksu keskeytyy yllättäen.
     */
    public void soita(String syote, boolean paalla) throws InterruptedException {
        String[] yksiNuotti = syote.split(":");
        if (nuotit.length >= 1) {
            for (Nuotti nuotti : nuotit) {
                if (nuotti.toString().equals(yksiNuotti[0])) {
                    if (paalla == true) {
                        syntikka.soitaLuettuNuotti(nuotti.getI(), yksiNuotti[1], paalla);
                        break;
                    } else if (paalla == false) {
                        break;
                    }
                }
            }
        }
    }
}
