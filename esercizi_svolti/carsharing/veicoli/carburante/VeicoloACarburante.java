package veicoli.carburante;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import veicoli.Veicolo;

@Getter
public class VeicoloACarburante extends Veicolo {

    public enum TipoMotore{ BENZINA, GASOLIO, GPL, METANO }

    private final String targa;
    private final double volumeTanga;
    private final TipoMotore motore;
    @Setter
    private double carburante;

    public VeicoloACarburante(String nome, String targa, double volumeTanga, TipoMotore motore, double carburante){
        super(nome);
        this.targa = targa;
        this.volumeTanga = volumeTanga;
        this.motore = motore;
        try{
            if(carburante > volumeTanga || carburante < 0)
                throw new IllegalArgumentException("Valore del carburante inaccettabile.");
            if(volumeTanga < 0)
                throw new IllegalArgumentException("Valore del volume della tanga inaccettabile.");
            this.carburante = carburante;
        }
        catch (IllegalArgumentException exc){
            System.out.println(exc.getMessage());
        }
    }

    public String toString(){
        return getNome() + "; " + getStato() + "; " + getPosizione() + "; " + motore + "; Volume tanga: " + volumeTanga + "l; Carburante: " + carburante + "l.";
    }

}
