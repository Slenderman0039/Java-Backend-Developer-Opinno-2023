package patterns.mailinglistuniversitarie;

import java.util.ArrayList;
import java.util.List;

public class Studente implements Observer<String> {

    private final String nome;
    private List<Corso> iscrizioni = new ArrayList<>();

    public Studente(String nome){
        this.nome = nome;
    }

    public boolean subscribe(Corso corso){
        corso.aggiungiStudente(this);
        return iscrizioni.add(corso);
    }

    @Override
    public void update(String message) {
        System.out.println(nome + " ha ricevuto il messaggio: " + message);
    }

    public String toString(){ return this.nome; }
}
