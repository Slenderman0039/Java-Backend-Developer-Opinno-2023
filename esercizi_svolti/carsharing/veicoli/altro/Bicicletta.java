package veicoli.altro;

import veicoli.Veicolo;

public class Bicicletta extends Veicolo {

    public Bicicletta(String nome){ super (nome); super.setTipo("Bicicletta"); }


    public String toString(){
        return getNome() + "; " + getStato() + "; " + getPosizione();
    }
}
