package ktu.k2;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author BestBeast
 */
public class TelefonuSkambuciai {
    
    LinkedList<Skambuciai> isklotine = new LinkedList<Skambuciai>();
    LinkedList<Skambuciai> daline = new LinkedList<Skambuciai>();
    
    PrintStream out = System.out;
    
    public void skambuciaiIMiesta(String miestas){
        for(Skambuciai s : isklotine){
            if(s.getMiestasKurSkambinta().equals(miestas)){
                daline.add(s);
            }
        }
    }
    
    public void rusiuotiPagalMinutesKaina(){
        Object [] isvedimui = isklotine.toArray();
        Arrays.sort(isvedimui, Skambuciai.pagalKaina);
        
        out.println("\n *-------------------Miestai is eiles-----------------*");
        for(int i = 0; i < isvedimui.length; i++ ){
            out.println(isvedimui[i].toString());
        }
    }
    
    public void abonentuApkrovimas(){
        Map<String, Integer> stat = new TreeMap<String, Integer>();
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
        
        skambuciaiIMiesta("Kaunas");
                
        rusiuotiPagalMinutesKaina();
        abonentuApkrovimas();
    
    }
    public static void main(String[] args) {
        TelefonuSkambuciai start = new TelefonuSkambuciai();
        start.dummy();

    }
}
