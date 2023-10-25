package patterns.mailinglistuniversitarie;

import java.util.ArrayList;
import java.util.List;

public class Docente {

    private List<Corso> corsi = new ArrayList<>();
    private final String nome, cognome;
    private String ruolo;

    public Docente(String nome, String cognome, String ruolo){
        this.nome = nome;
        this.cognome = cognome;
        this.ruolo = ruolo;
    }

    public boolean aggiungiCorso(Corso corso){
        return corsi.add(corso);
    }

    public String sendMessage(String message){
        for(Corso corso : corsi){
            corso.inviaMessaggio(message);
        }
        return message;
    }

    public String sendMessage(String message, Corso ... corsi){
        for(Corso corso : corsi){
            corso.inviaMessaggio(message);
        }
        return message;
    }
}
