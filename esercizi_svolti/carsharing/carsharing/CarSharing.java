package carsharing;

import db.DumbDB;
import lombok.Getter;
import prenotazione.Prenotazione;
import users.Persona;
import users.Persona.Patenti;
import veicoli.Veicolo;
import veicoli.altro.Bicicletta;
import veicoli.carburante.Automobile;
import veicoli.carburante.Furgoncino;
import veicoli.carburante.Scooter;
import veicoli.elettrici.Monopattino;

import java.util.Scanner;

public class CarSharing {

    @Getter
    private DumbDB db;
    Scanner scanner = new Scanner(System.in);

    public CarSharing(){ db = new DumbDB(); }

    /**
     * Calcola il costo della corsa in funzione del veicolo noleggiato e del tempo della corsa (in minuti)
     * @params Veicolo v, long minuti
     * @return double
     * */
    public static double getTariffa(Veicolo v, long minuti){
        double tariffa = 0;
        if(!(v instanceof Veicolo)) return -1;
        if(v instanceof Furgoncino) tariffa = 0.5f * minuti;       //Furgoncino --> 0.50€/min = 30€/h
        if(v instanceof Automobile) tariffa = 0.33f * minuti;       //Automobile --> 0.33€/min = 20€/h
        if(v instanceof Scooter) tariffa = 0.25f * minuti;       //Scooter --> 0.25€/min = 15€/h
        if(v instanceof Monopattino) tariffa = 1 + 0.15f * minuti;       //Monopattino --> 1€ + 0.15€/min = 10€/h prima ora, 9€/h poi
        if(v instanceof Bicicletta) tariffa = 0.2f * minuti;       //Bicicletta --> 0.20€/min = 12€/h
        return tariffa;
    }

    /**
     * Stampa i veicoli disponibili che coincidono con il tipo richiesto
     * */
    public void cercaVeicolo(){
        System.out.print("Scrivi il tipo di veicolo di cui hai bisogno (Automobile, Scooter, Monopattino, Bicicletta, Furgoncino): ");
        String s = scanner.nextLine();
        if(db.getVeicoliDisponibili(s).isEmpty())
            System.out.println("Non ci sono veicoli come quelli che hai richiesto.");
        else{
            System.out.println("Ecco i veicoli disponibili:\n" + db.getVeicoliDisponibiliString(s));
        }
    }

    /**
     * Verifica che l'utente che sta richiedendo di prenotare il veicolo esista, e il veicolo da prenotare sia disponibile.
     * Inoltre controlla che l'utente abbia il casco per i veicoli dove il casco necessario e anche che abbia le patenti necessarie per guidare ogni veicolo
     * @return boolean
     * @params String email, String nome
     * */
    public boolean prenotaVeicolo(String email, String nome){

        Veicolo veicoloDaPrenotare = null;
        Persona p = getDb().getPersona(email);

        if(p.equals(null)){
            System.out.println("Account con questa email non esistente.");
            return false;
        }

        for(Veicolo v : db.getVeicoliDisponibili()){
            if (v.getNome().equalsIgnoreCase(nome)){
                veicoloDaPrenotare = v;
                break;
            }
        }
        if(veicoloDaPrenotare.equals(null)){
            System.out.println("La prenotazione non è andata a buon fine.");
            return false;
        }
        else if(veicoloDaPrenotare instanceof Bicicletta || veicoloDaPrenotare instanceof Scooter){
            if(p.isCasco() == false){
                System.out.println("Prenotazione del veicolo non possibile, in quanto l'utente non ha il caso.");
                return false;
            }
        }
        else if(veicoloDaPrenotare instanceof Scooter){
            if(p.getPatenti().isEmpty()){
                System.out.println("Non hai nessuna patente, non puoi guidare questo veicolo!");
                return false;
            }

        }
        else if(veicoloDaPrenotare instanceof Automobile){
            if(!(p.getPatenti().contains(Patenti.B))) {
                System.out.println("Non hai la patente B, dunque non puoi guidare un'automobile!");
                return false;
            }
        }
        else if (veicoloDaPrenotare instanceof Furgoncino){
            if(!(p.getPatenti().contains(Patenti.C))){
                System.out.println("Non hai la patente C, dunque non puoi guidare un'furgoncino!");
                return false;
            }
        }
        System.out.println("Veicolo prenotato, corsa iniziata.");
        Prenotazione prenotazione = new Prenotazione(p, veicoloDaPrenotare);
        prenotazione.inizioCorsa();
        db.prenotaVeicolo(prenotazione);
        return true;
    }

    /**
     * Termina la corsa in corso data l'email dell'utente che sta svolgendo la corsa e il nome del veicolo noleggiato
     * @return boolean
     * */
    public boolean terminaCorsa(String email, String nomeVeicolo){
        return getDb().getPrenotazione(email, nomeVeicolo).terminaCorsa();
    }

    /**
     * Aggiunge la patente inserita alla email dell'utente
     * @params String email, Patenti patente
     * */
    public void aggiungiPatente(String email, Patenti patente){
        Persona p = getDb().getPersona(email);
        p.aggiungiPatente(patente);
    }

    /**
     * Aggiunge il credito alla email dell'utente
     * @params String email, double credito
     * */
    public void aggiungiCredito(String email, double credito){
        Persona p = getDb().getPersona(email);
        p.setCredito(p.getCredito() + credito);
    }
}