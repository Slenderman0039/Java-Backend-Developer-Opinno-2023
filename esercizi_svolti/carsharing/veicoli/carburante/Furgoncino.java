package veicoli.carburante;

public class Furgoncino extends VeicoloACarburante{

    public Furgoncino(String nome, String targa, double volumeTanga, TipoMotore motore, double carburante){
        super(nome, targa, volumeTanga, motore, carburante);
        super.setTipo("Furgoncino");
    }

}
