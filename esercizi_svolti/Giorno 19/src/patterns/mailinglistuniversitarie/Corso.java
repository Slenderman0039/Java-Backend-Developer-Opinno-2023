package patterns.mailinglistuniversitarie;

import java.util.ArrayList;
import java.util.List;

public class Corso {

    private final String nome;
    private Docente docente;
    private String aula;
    List<Studente> studentiIscritti = new ArrayList<>();
    private MailingList mailingList;
    private boolean hasMailingList;

    public Corso(String nome, Docente docente, String aula){
        this.nome = nome;
        this.docente = docente;
        this.aula = aula;
        mailingList = new MailingList();
        hasMailingList = true;
    }
    /*public boolean aggiungiStudente(Studente o) {
        return studentiIscritti.add(o);
    }

    public boolean eliminaStudente(Studente o) {
        return studentiIscritti.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for(Studente studente : this.studentiIscritti){
            studente.update(docente.sendMessage(message));
        }
    }*/

    public boolean aggiungiStudente(Studente s){
        mailingList.addObserver(s);
        return studentiIscritti.add(s);
    }

    public void inviaMessaggio(String message){
        mailingList.notifyObservers(message);
    }

    public String studentiIscritti(){
        String s = "";
        for(Studente studente : studentiIscritti)
            s += studente.toString() + "\n";
        return s;
    }
}
