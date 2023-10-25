package veicoli.elettrici;

import veicoli.Veicolo;

public class Monopattino extends Veicolo {

    private int percentualeBatteria;

    public Monopattino(String nome, int percentualeBatteria){
        super(nome);
        super.setTipo("Monopattino");
        try{
            if(percentualeBatteria < 0 || percentualeBatteria > 100) throw new IllegalArgumentException("Percentuale di batteria inserita non valida.\n");
            this.percentualeBatteria = percentualeBatteria;
        }
        catch (IllegalArgumentException exc){
            System.out.println(exc.getMessage());
        }

    }

    public String toString(){
        return getNome() + "; " + getStato() + "; " + getPosizione() + "; Batteria: " + percentualeBatteria + "%";
    }

}
