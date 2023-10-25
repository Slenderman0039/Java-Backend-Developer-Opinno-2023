package esercizio1;

import static esercizio1.Casella.Stato.VUOTO;

public class Casella {

    public enum Stato{
        VUOTO,
        NAVE,
        COLPITO;
    }

    private Stato stato;
    private boolean isPlayed;        //Serve a capire se questa casella è stata giocata per renderla coperta o scoperta

    public Casella(){
        this.stato = VUOTO;
        this.isPlayed = false;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public boolean isPlayed() {
        return isPlayed;
    }

    public void setPlayed(boolean played) {
        isPlayed = played;
    }
}
