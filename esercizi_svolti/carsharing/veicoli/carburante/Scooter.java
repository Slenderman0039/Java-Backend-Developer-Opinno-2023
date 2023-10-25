package veicoli.carburante;

public class Scooter extends VeicoloACarburante{

    public Scooter(String nome, String targa, double volumeTanga, TipoMotore motore, double carburante){
        super(nome, targa, volumeTanga, motore, carburante);
        super.setTipo("Scooter");
    }

}
