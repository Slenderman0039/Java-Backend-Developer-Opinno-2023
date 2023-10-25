package segreteria.classi;

import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Studente {

    private final String matricola;
    private final String nome, cognome;
    private final LocalDate dataDiNascita;
    private List<Corso> corsi;

    public Studente(String matricola, String nome, String cognome, LocalDate dataDiNascita){
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        corsi = new ArrayList<>();
    }

    public Corso aggiungiCorso(Corso c){
        corsi.add(c);
        c.aggiungiStudente(this);
        return c;
    }

    public void rimuoviCorso(Corso c){
        c.rimuoviStudente(this);
        corsi.remove(c);
    }

    public String toString(){
        return matricola + ": " + nome + " " + cognome + ", nato/a il " + dataDiNascita;
    }

}
