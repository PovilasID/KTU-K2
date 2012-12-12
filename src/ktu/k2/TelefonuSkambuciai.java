/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ktu.k2;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author BestBeast
 */
public class TelefonuSkambuciai {
    
    ArrayList<Skambuciai> isklotine = new ArrayList<Skambuciai>();
    ArrayList<Skambuciai> daline = new ArrayList<Skambuciai>();
    
    PrintStream out = System.out;
    
    public void brangiausiSkambuciai(double skambucioKaina){
        for(Skambuciai s : isklotine){
            if(s.getSkambucioKaina() > skambucioKaina){
                daline.add(s);
            }
        }
    }
    
    public void rusiuotiPagalMiestus(){
        Object [] isvedimui = isklotine.toArray();
        Arrays.sort(isvedimui, Skambuciai.pagalMiestus);
        
        out.println("\n *-------------------Miestai is eiles-----------------*");
        for(int i = 0; i < isvedimui.length; i++ ){
            out.println(isvedimui[i].toString());
        }
    }
    
    public void miestuApkrovimas(){
        Map<String, Integer> stat = new HashMap<String, Integer>();
        for(Skambuciai s : isklotine){
            if(stat.containsKey(s.getMiestasKurSkambinta())){
                stat.put(s.getMiestasKurSkambinta(), 
                        stat.get(s.getMiestasKurSkambinta())+1);
            }else{
                stat.put(s.getMiestasKurSkambinta(), 1);
            }
        }
        
        out.println("\n*---------Labiausiai Apkrauti miestai-------------*");
        out.println("|  Miestas         |      Kartu skaicius          |");
        out.println("*-------------------------------------------------*");
        for(Map.Entry<String, Integer> l: stat.entrySet()){
            out.printf("|  %-15s | %11d %18s\n", l.getKey(), l.getValue(),"|");
        }
        out.println("*-------------------------------------------------*");
    }
    
    public void dummy(){
        isklotine.add(new Skambuciai("868612345", "Kaunas", 5, 0.64));
        isklotine.add(new Skambuciai("868611111", "Viena", 3, 1.46));
        isklotine.add(new Skambuciai("868611111", "Trakai", 10, 0.23));
        isklotine.add(new Skambuciai("868612322", "Kaunas", 7, 0.6));
        
        brangiausiSkambuciai(5);
        rusiuotiPagalMiestus();
        miestuApkrovimas();
    
    }
    public static void main(String[] args) {
        TelefonuSkambuciai start = new TelefonuSkambuciai();
        start.dummy();

    }
}
