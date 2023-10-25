package esercizio1;

import java.util.ArrayList;
import java.util.HashSet;

public class Raccolta {

    HashSet<Canzone> canzoni;
    public Raccolta(){
        canzoni = new HashSet <>();
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
