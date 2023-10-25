package prenotazione;

import carsharing.CarSharing;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;
import veicoli.*;
import users.*;


@Getter
public class Prenotazione {

    private int globalId;
    private final int id;
    private LocalDateTime dataInizio;
    @Setter
    private LocalDateTime dataFine;
    @Setter
    private double costoCorsa;
    @Setter
    private Persona p;
    @Setter
    private Veicolo v;


    public Prenotazione(Persona p, Veicolo v) {
        this.id = globalId++;
        this.p = p;
        this.v = v;
    }

    public void inizioCorsa(){
        dataInizio = LocalDateTime.now();
        getV().setStato(Veicolo.Stato.AFFITTATO);
        //System.out.println("Hai iniziato la tua corsa");
    }

    /**
     * Stabilisce in tempo reale la data e i minuti del termine della corsa, controllando che sia passato il tempo minimo dall'inizio
     * della corsa (5 minuti) e che l'utente abbia il credito necessario per pagare la corsa. Se l'utente ha il credito sufficiente viene scalato
     * il corso della corsa.
     * */
    public boolean terminaCorsa(){

        if(dataFine != null){
            Duration duration = Duration.between(dataInizio,LocalDateTime.now());
            long minuti = duration.toMinutes();
        /*if(minuti < 5){
            System.out.println("La corsa non può durare meno di 5 minuti!");
            return false;
        }*/
            setCostoCorsa(CarSharing.getTariffa(getV(), minuti));
            if(p.getCredito() >= getCostoCorsa()){
                dataFine = LocalDateTime.now();
                p.setCredito(p.getCredito() - getCostoCorsa());
                System.out.println("[ CORSA TERMINATA - RIEPILOGO ]");
                System.out.println(toString());
            }else{
                System.out.println("Transazione non eseguita, credito insufficiente.");
                return false;
            }
        }
        else{
            System.out.println("Prenotazione già chiusa");
            return false;
        }
        return true;
    }


    /**
     * Ritorna tutte le caratteristiche della prenotazione, insieme alle caratteristiche dell'utente e del veicolo
     * @return String
     * */
    public String toStringCompleto() {
            String persona = getP().toStringForPrenotazione();
            String veicolo = getV().toStringForPrenotazione();
            return persona+"\n"+veicolo+"\n"+this.toString();
    }

    /**
     * Ritorna le informazioni sulla corsa quando essa viene terminata.
     * @return String
     * */
    @Override
    public String toString() {
        String prenotazione = "==== PRENOTAZIONE ===\nID: "+getId();
        if(dataInizio!=null){
            prenotazione += "\nDate inizio: " + getDataInizio()+".";
        }else{
            prenotazione += "\nDate inizio: Non ancora definito.";
        }
        if(dataFine!=null){
            prenotazione += "\nDate fine: " + getDataFine()+".";
            prenotazione += "\nImporto Pagato: " + getCostoCorsa()+"€ .";
        }else{
            prenotazione += "\nDate fine: Non ancora definito.";
        }
        return prenotazione;
    }
}