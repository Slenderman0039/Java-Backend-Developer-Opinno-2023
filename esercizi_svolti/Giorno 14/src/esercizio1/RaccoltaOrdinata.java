package esercizio1;


import java.util.Comparator;
import java.util.TreeSet;

public class RaccoltaOrdinata {

    TreeSet<Canzone> canzoni;

    public RaccoltaOrdinata(){
        canzoni = new TreeSet<>(new Comparator<Canzone>() {
            @Override
            public int compare(Canzone o1, Canzone o2) {
                if(o1.getNome().compareTo(o2.getNome()) == 0){
                    return o1.getAutore().compareTo(o2.getAutore());
                }
                return o1.getNome().compareTo(o2.getNome());
            }
        });
    }

    public void aggiungiCanzone(Canzone canzone){
        canzoni.add(canzone);
        System.out.println("Hai aggiunto correttamente la canzone: " + canzone.getNome());
    }

    @Override
    public String toString() {
        String s = "";
        for(Canzone c: canzoni){
            s+= c.toString();
        }
        return s;
    }
}
