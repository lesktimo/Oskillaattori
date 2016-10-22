/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesktimo.oskillaattori.aani.apu;

/**
 * Tempo-luokkaa käytetään nuottien pituuden laskemisessa.
 *
 */
public class Tempo {

    private int tempo;
    private final int minuuttiSekunteina;
    private final int tahti;
    private final int millisekuntejaSekunnissa;

    /**
     * Temmon oletusarvo on 120 iskua sekunnissa. Tahti kertoo montako iskua on
     * yhdessä tahdissa.
     */
    public Tempo() {
        tempo = 120;
        tahti = 4;
        minuuttiSekunteina = 60;
        millisekuntejaSekunnissa = 1000;
    }

    /**
     * Asettaa uuden temmon.
     *
     * @param uusiTempo uusi haluttu arvo temmolle.
     */
    public void setTempo(int uusiTempo) {
        this.tempo = uusiTempo;
    }

    public int getTempo() {
        return tempo;
    }

    /**
     * Laskee halutun nuotin pituuden ajanmääreenä käyttäen tempoa, tahtia ja
     * annettua nuotin pituutta: - 1/1 kokonuotti - 1/2 puolinuotti - 1/4
     * neljäsosanuotti - 1/8 kahdeksasosanuotti - 1/16 kuudestoistaosanuotti -
     * 1/32 kolmanneskymmenenneskahdesosanuoti Nämä ovat useimmiten käytetyt
     * nuottien pituudet 4/4 tahtilajissa.
     *
     * @param pituus annetun nuotin pituus suhteessa tahtiin
     * @return palauttaa nuotin pituuden millisekunteina
     */
    public double laskeNuotinPituus(String pituus) {
        double tulos;
        int osa;
        switch (pituus) {
            case "1/1":
                osa = 1;
                tulos = (((double) minuuttiSekunteina / (double) tempo) * ((double) tahti / (double) osa) * (double) millisekuntejaSekunnissa);
                return tulos;
            case "1/2":
                osa = 2;
                tulos = (((double) minuuttiSekunteina / (double) tempo) * ((double) tahti / (double) osa) * (double) millisekuntejaSekunnissa);
                return tulos;
            case "1/4":
                osa = 4;
                tulos = (((double) minuuttiSekunteina / (double) tempo) * ((double) tahti / (double) osa) * (double) millisekuntejaSekunnissa);
                return tulos;
            case "1/8":
                osa = 8;
                tulos = (((double) minuuttiSekunteina / (double) tempo) * ((double) tahti / (double) osa) * (double) millisekuntejaSekunnissa);
                return tulos;
            case "1/16":
                osa = 16;
                tulos = (((double) minuuttiSekunteina / (double) tempo) * ((double) tahti / (double) osa) * (double) millisekuntejaSekunnissa);
                return tulos;
            case "1/32":
                osa = 32;
                tulos = (((double) minuuttiSekunteina / (double) tempo) * ((double) tahti / (double) osa) * (double) millisekuntejaSekunnissa);
                return tulos;
            default:
                osa = 1;
                tulos = (((double) minuuttiSekunteina / (double) tempo) * ((double) tahti / (double) osa) * (double) millisekuntejaSekunnissa);
                return tulos;
        }
    }
}
