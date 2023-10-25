package veicoli.carburante;

import lombok.AllArgsConstructor;
import veicoli.Veicolo;

public class Automobile extends VeicoloACarburante {

    public Automobile(String nome, String targa, double volumeTanga, TipoMotore motore, double carburante){
        super(nome, targa, volumeTanga, motore, carburante);
        super.setTipo("Automobile");
    }

}
