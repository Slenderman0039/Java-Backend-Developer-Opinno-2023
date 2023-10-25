package main;

import segreteria.db.DBCSV;

import java.nio.file.Path;
import java.nio.file.Paths;

public class MainCSV {

    public static void main(String[] args) {

        DBCSV db = DBCSV.getInstance();

        Path pathStudenti = Paths.get("Giorno 20","src", "csv", "studenti.csv");
        Path pathCorsi = Paths.get("Giorno 20","src", "csv", "corsi.csv");

        db.getStudenti().readFileCSV(pathStudenti);
        db.getCorsi().readFileCSV(pathCorsi);

        System.out.println(db.getStudenti().toString());
        System.out.println(db.getCorsi().toString());

        Path pathStudentiWrite = Paths.get("Giorno 20","src", "csv", "studenti2.csv");
        Path pathCorsiWrite = Paths.get("Giorno 20","src", "csv", "corsi2.csv");

        db.getStudenti().writeFileCSV(pathStudentiWrite);
        db.getCorsi().writeFileCSV(pathCorsiWrite);

    }

}
