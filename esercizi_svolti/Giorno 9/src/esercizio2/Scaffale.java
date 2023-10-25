package esercizio2;

import java.util.ArrayList;
import java.util.Iterator;

public class Scaffale implements Iterable<Libro>{

    private int capienzaMassima;
    private ArrayList<Libro> libri;

    public Scaffale(int capienzaMassima){
        this.capienzaMassima = capienzaMassima;
        libri = new ArrayList<>();
    }

    public int getCapienzaMassima() {
        return capienzaMassima;
    }

    public void setCapienzaMassima(int capienzaMassima) {
        this.capienzaMassima = capienzaMassima;
    }

    public int size(){ return libri.size(); }

    public ArrayList<Libro> getLibri() {
        return libri;
    }

    public void setLibri(ArrayList<Libro> libri) {
        this.libri = libri;
    }

    public Libro ricercaLibro(String titolo){
        for(int i = 0; i < libri.size(); i++){
            if(libri.get(i).getTitolo().equalsIgnoreCase(titolo))
                return libri.get(i);
        }
        return null;
    }

    public Libro cercaLibroNuovo(String titolo){
        Libro l = ricercaLibro(titolo);
        if (!l.letto())
            return l;
        return null;
    }

    public Libro cercaLibroUsato(String titolo){
        Libro l = ricercaLibro(titolo);
        if (l.letto())
            return l;
        return null;
    }

    public void aggiungiLibro(Libro l){
        if(libri.size() < capienzaMassima)
        libri.add(l);
    }

    public void rimuoviLibro(String titolo){
        Libro l = ricercaLibro(titolo);
        libri.remove(l);
    }

    @Override
    public Iterator<Libro> iterator() {

        Iterator<Libro> iterator = new Iterator<Libro>() {

            int index = 0;

            @Override
            public boolean hasNext() {
                return index != libri.size();
            }

            @Override
            public Libro next() {
                return libri.get(index++);
            }
        };
        return iterator;
    }
}
