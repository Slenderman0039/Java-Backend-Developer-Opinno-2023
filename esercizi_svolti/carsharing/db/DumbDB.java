package db;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import veicoli.*;
import prenotazione.*;
import users.*;

@Getter
@Setter
public class DumbDB {

    private Map<Integer,Persona> persone;
    private Map<Integer,Veicolo> veicoli;
    private static Map<Integer,Prenotazione> prenotazioni;

    public DumbDB(){
        persone = new HashMap<Integer, Persona>();
        veicoli = new HashMap<Integer, Veicolo>();
        prenotazioni = new HashMap<Integer, Prenotazione>();
    }

    /**
     * Aggiunge un nuovo utente
     * @params Persona p
     * */
    public void aggiungiPersona(Persona p){
        persone.put(p.getId(),p);
        //System.out.println("Hai aggiunto con successo " + p.getNome() + " " + p.getCognome());
    }

    /**
     * Rimuove un utente
     * @params Persona p
     * */
    public void rimuoviPersona(Persona p){
        persone.remove(p);
    }

    /**
     * Aggiunge un nuovo Veicolo alla flotta
     * @params Veicolo v
     * */
    public void aggiungiVeicolo(Veicolo v){
        if(!veicoli.containsValue(v)){
            veicoli.put(v.getId(),v);
        }
        //System.out.println("Hai aggiunto con correttamente il veicolo " + v.getId());
    }

    public void prenotaVeicolo(Prenotazione p){
        prenotazioni.put(p.getId(),p);
        //System.out.println("Hai aggiunto con successo la prenotazione");
    }

    /**
     * Restituisce l'elenco dei veicoli sotto forma di lista
     * @return List<Veicolo></>
     * */
    public List<Veicolo> getVeicoli(){
        ArrayList<Veicolo> veicoli = new ArrayList<Veicolo>(this.veicoli.values());
        return veicoli;
    }

    public String getVeicoliString(){
        String s = "";
        for(Veicolo v : veicoli.values())
            s += v.toString() + "\n";
        return s;
    }

    /**
     * Restituisce l'elenco degli utenti sotto forma di lista
     * @return List<Persona></>
     * */
    public List<Persona> getPersone(){
        ArrayList<Persona> listPersone = new ArrayList<>();
        for(Persona p : this.persone.values())
            listPersone.add(p);

        return listPersone;
    }

    public String getPersoneString(){
        String s = "";
        for(Persona p : persone.values())
            s += p.toString() + "\n";
        return s;
    }

    public Persona getPersona(String email){
        for (Persona p : persone.values()){
            if (p.getEmail().equals(email))
                return p;
        }
        return null;
    }

    /**
     * Restituisce l'elenco dei veicoli disponibili (del tipo richiesto) sotto forma di lista
     * @return List<Veicolo></>
     * */
    public List<Veicolo> getVeicoliDisponibili(String tipoVeicolo){
        List<Veicolo> disponibili = new ArrayList<>();
        for(Veicolo v: veicoli.values()){
            if(v.getStato() == Veicolo.Stato.DISPONIBILE){
                if(v.getTipo().equals(tipoVeicolo)) disponibili.add(v);
            }
        }
        return disponibili;
    }

    /**
     * Restituisce l'elenco dei veicoli disponibili sotto forma di lista
     * @return List<Veicolo></>
     * */
    public List<Veicolo> getVeicoliDisponibili(){
        List<Veicolo> disponibili = new ArrayList<>();
        for(Veicolo v: veicoli.values()){
            if(v.getStato() == Veicolo.Stato.DISPONIBILE){
                disponibili.add(v);
            }
        }
        return disponibili;
    }

    /**
     * Ritorna i veicoli disponibili (del tipo richiesto) sotto forma di stringa
     * */
    public String getVeicoliDisponibiliString(String tipoVeicolo){
        String s = "";
        for(Veicolo v : veicoli.values()){
            if(v.getStato() == Veicolo.Stato.DISPONIBILE){
                if (v.getTipo().equals(tipoVeicolo)) s += v.toString() + "\n";
            }
        }
        return s;
    }

    /**
     * Restituisce l'elenco dei veicoli affittati sotto forma di lista
     * @return List<Veicolo></>
     * */
    public List<Veicolo> getVeicoliAffittati(){
        List<Veicolo> affittati = new ArrayList<>();
        for(Veicolo v: veicoli.values()){
            if(v.getStato() == Veicolo.Stato.AFFITTATO){
                affittati.add(v);
            }
        }
        return affittati;
    }

    /**
     * Restituisce lo storico delle prenotazioni sotto forma di lista
     * @return List<Prenotazione></>
     * */
    public List<Prenotazione> getPrenotazioni() {
        List<Prenotazione> prenotazioni = new ArrayList<>();
        for(Prenotazione p : this.prenotazioni.values()){
            prenotazioni.add(p);
        }
        return prenotazioni;
    }

    /**
     * Restituisce la lista delle prenotazioni sotto forma di stringa
     * @return String
     * */
    public String getPrenotazioniString(){
        String s = "";
        for(Prenotazione p : this.prenotazioni.values()) s += p.toString() + "\n";
        return s;
    }

    /**
     * Ritorna la prima occorrenza di veicolo che ha il nome inserito in input
     */
    public Veicolo getVeicolo(String nomeVeicolo){
        for (Veicolo v : veicoli.values()){
            if (v.getNome().equals(nomeVeicolo))
                return v;
        }
        return null;
    }


    /**
     * Ritorna la prima occorrenza trovata della prenotazione che abbia l'utente desiderato (cercato per email) e del primo veicolo trovato (cercato per nome)
     * @return Prenotazione p
     * */
    public Prenotazione getPrenotazione(String email, String nomeVeicolo){
        Persona persona = getPersona(email);
        Veicolo veicolo = getVeicolo(nomeVeicolo);
        for(Prenotazione p : prenotazioni.values()){
            if(p.getP().equals(persona) && p.getV().equals(veicolo))
                return p;
        }
        return null;
    }
}