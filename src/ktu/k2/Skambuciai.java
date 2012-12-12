/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ktu.k2;

import java.util.Comparator;
import java.util.Scanner;

public class Skambuciai implements Comparable {

    private String telefonoNumeris;
    private String miestasKurSkambinta;
    private int skambucioTrukme;
    private double minutesKaina;

    public Skambuciai() {
        this.telefonoNumeris = "";
        this.miestasKurSkambinta = "";
        this.skambucioTrukme = 0;
        this.minutesKaina = 0;
    }

    public Skambuciai(String telefonoNumeris, String miestasKurSkambinta, int skambucioTrukme, double minutesKaina) {
        this.telefonoNumeris = telefonoNumeris;
        this.miestasKurSkambinta = miestasKurSkambinta;
        this.skambucioTrukme = skambucioTrukme;
        this.minutesKaina = minutesKaina;
    }

    public String getTelefonoNumeris() {
        return telefonoNumeris;
    }

    public String getMiestasKurSkambinta() {
        return miestasKurSkambinta;
    }

    public int getSkambucioTrukme() {
        return skambucioTrukme;
    }

    public double getMinutesKaina() {
        return minutesKaina;
    }

    
    @Override
    public String toString() {
        return "Skambuciai{" + "telefonoNumeris=" + telefonoNumeris + ", miestasKurSkambinta=" + miestasKurSkambinta + ", skambucioTrukme=" + skambucioTrukme + ", minutesKaina=" + minutesKaina + '}';
    }

    @Override
    public int compareTo(Object o) {
        return telefonoNumeris.compareTo(((Skambuciai) o).getTelefonoNumeris());
    }
    
    public static Comparator pagalKaina = new Comparator(){
        @Override
        public int compare(Object o1, Object o2) {
            double kaina1 = ((Skambuciai) o1).getMinutesKaina();
            double kaina2 = ((Skambuciai) o2).getMinutesKaina();
            return (kaina1 > kaina2)? 1 : ((kaina1 < kaina2)? -1 : 0);
        }
    };
    
    public static Comparator pagalMiestus = new Comparator(){
        @Override
        public int compare(Object o1, Object o2) {
            return ((Skambuciai) o1).getMiestasKurSkambinta().compareTo(
                    ((Skambuciai) o2).getMiestasKurSkambinta());
        }
    };
    
    public double getSkambucioKaina(){
        return this.minutesKaina * this.skambucioTrukme;
    }

}
