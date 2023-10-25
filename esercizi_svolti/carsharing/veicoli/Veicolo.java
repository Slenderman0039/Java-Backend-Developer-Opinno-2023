package veicoli;

import lombok.Getter;
import lombok.Setter;
import posizione.Posizione;

@Getter
public abstract class Veicolo {


    public enum Stato{ AFFITTATO, DISPONIBILE, MANUTENZIONE }

    private final int id;
    private final String nome;
    @Setter
    private String tipo;
    private static int globalId = 0;
    @Setter
    private Stato stato;
    @Setter
    private Posizione posizione;

    public Veicolo(String nome){
        id = globalId++;
        this.nome = nome;
        stato = veicoli.Veicolo.Stato.DISPONIBILE;
        posizione = new Posizione(0, 0);
    }

    public String toStringForPrenotazione() {
        return "Nome: " + getNome() + ".\nPosizione: "+ getPosizione() + ".";
    }

    public String toString(){
        return nome + "; " + stato + "; " + posizione;
    }
}