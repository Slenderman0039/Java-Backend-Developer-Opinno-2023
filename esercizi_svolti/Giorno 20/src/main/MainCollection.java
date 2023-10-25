package main;

import segreteria.classi.Corso;
import segreteria.classi.Studente;
import segreteria.db.DummyDB;

import java.time.LocalDate;

public class MainCollection {

    public static void main(String[] args) {

        DummyDB db = DummyDB.getInstance();

        // Aggiungo gli studenti

        db.getStudenti().insert(new Studente("123", "Claudio", "Sottile", LocalDate.of(2002, 7, 25)));
        db.getStudenti().insert(new Studente("124", "Alessandro", "Macaluso", LocalDate.of(2002, 7, 25)));
        db.getStudenti().insert(new Studente("125", "Pasquale", "La Gatta", LocalDate.of(2002, 7, 25)));
        db.getStudenti().insert(new Studente("126", "Jacopo", "Perna", LocalDate.of(2002, 7, 25)));

        // Aggiungo due corsi

        db.getCorsi().insert(new Corso("Analisi", "Dalla Riva", 12));
        db.getCorsi().insert(new Corso("Fisica 1", "Pagano", 6));

        // Tutti e 4 gli studenti seguono Analisi

        db.getStudenti().aggiungiCorso(db.getCorsi().get("Analisi", 12), db.getStudenti().getAllStudenti());

        // Voglio tutti i corsi che segue Claudio Sottile

        System.out.print("Le materie dello studente Claudio Sottile: " + db.getStudenti().getCorsi(db.getStudenti().getByNameAndSurname("Claudio", "Sottile")));

    }

}