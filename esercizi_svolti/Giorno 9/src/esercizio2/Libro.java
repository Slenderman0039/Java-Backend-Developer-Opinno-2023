package esercizio2;

public class Libro implements Leggibile{
    private String titolo, autore;
    private boolean isRead;

    public Libro(String titolo, String autore) {
        this.titolo = titolo;
        this.autore = autore;
        this.isRead = false;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void leggi(){ this.isRead = true; }

    public boolean letto(){ return this.isRead; }
}