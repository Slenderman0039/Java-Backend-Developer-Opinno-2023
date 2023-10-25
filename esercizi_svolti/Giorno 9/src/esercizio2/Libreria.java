package esercizio2;

import java.util.ArrayList;
import java.util.Iterator;

public class Libreria implements Iterable<Scaffale>{

    private ArrayList<Scaffale> scaffali;

    public Libreria(){ scaffali = new ArrayList<>(); }

    public void aggiungiScaffale(Scaffale s){ scaffali.add(s); }

    public void rimuoviScaffale(Scaffale s){ scaffali.remove(s); }

    public Scaffale getScaffale(int k){ return scaffali.get(k); }

    public void aggiungiLibro(Libro l){
        for (Scaffale s : scaffali) {
            if(s.size() < s.getCapienzaMassima()){
                s.aggiungiLibro(l);
                return;
            }
        }
    }

    @Override
    public Iterator<Scaffale> iterator() {

        Iterator<Scaffale> iterator = new Iterator<Scaffale>() {

            int index = 0;

            @Override
            public boolean hasNext() {
                return index != scaffali.size();
            }

            @Override
            public Scaffale next() {
                return scaffali.get(index++);
            }
        };
        return iterator;
    }
}
