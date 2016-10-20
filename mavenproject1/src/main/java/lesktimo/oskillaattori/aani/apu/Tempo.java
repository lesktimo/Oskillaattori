/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesktimo.oskillaattori.aani.apu;

/**
 *
 * @author lesktimo
 */
public class Tempo {

    private int tempo;
    private final int minuutti;
    private final int tahti;

    public Tempo() {
        tempo = 120;
        tahti = 4;
        minuutti = 60;
    }

    public boolean setTempo(int uusiTempo) {
        if (tempo >= 1 && tempo <= 999) {
            this.tempo = uusiTempo;
            return true;
        } else {
            return false;
        }
    }

    public int getTempo() {
        return tempo;
    }

    public long laskeNuotinPituus(String pituus) {
        switch (pituus) {
            case "1/1":
                return minuutti / tempo * tahti / 1;
            case "1/2":
                return minuutti / tempo * tahti / 2;
            case "1/4":
                return minuutti / tempo * tahti / 4;
            case "1/8":
                return minuutti / tempo * tahti / 8;
            case "1/16":
                return minuutti / tempo * tahti / 16;
            case "1/32":
                return minuutti / tempo * tahti / 32;
            default:
                return minuutti / tempo * tahti / 1;
        }
    }
}
