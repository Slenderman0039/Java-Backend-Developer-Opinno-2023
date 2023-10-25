package segreteria.classi;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Corso {

    private final UUID id = UUID.randomUUID();
    private final String nomeCorso, nomeDocente;
    private final int numeroCFU;
    private List<Studente> studentiIscritti;

    public Corso(String nomeCorso, String nomeDocente, int numeroCFU){
        this.nomeCorso = nomeCorso;
        this.nomeDocente = nomeDocente;
        this.numeroCFU = numeroCFU;
        studentiIscritti = new ArrayList<>();
    }

    public Studente aggiungiStudente(Studente s){
        studentiIscritti.add(s);
        return s;
    }

    public void rimuoviStudente(Studente s){
        studentiIscritti.remove(s);
    }

    public String toString(){
        return nomeCorso + ", Docente: " + nomeDocente + "(" + numeroCFU + " CFU)";
    }
}