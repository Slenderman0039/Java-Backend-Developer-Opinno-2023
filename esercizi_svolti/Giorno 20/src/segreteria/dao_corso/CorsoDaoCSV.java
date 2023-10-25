package segreteria.dao_corso;

import segreteria.classi.Corso;
import segreteria.classi.Studente;
import segreteria.interfaccedao.CorsoDao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;

public class CorsoDaoCSV implements CorsoDao {

    Map<UUID, Corso> mappaCorsi;

    public CorsoDaoCSV(){
        mappaCorsi = new HashMap<>();
    }

    public void writeFileCSV(Path path){


    }

    public void readFileCSV(Path path){

        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            // legge una riga del file e passa alla successiva finché ce ne sono da leggere nel file buffer
            while ((line = br.readLine()) != null) {
                String[] riga = line.split(",");

                String nome = riga[0];
                String nomeDocente = riga[1];
                int numeroCFU = Integer.parseInt(riga[2]);

                insert(new Corso(nome, nomeDocente, numeroCFU));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Corso insert(Corso c) {
        return mappaCorsi.put(UUID.randomUUID(), c);
    }

    @Override
    public Corso update(Corso c) {
        return mappaCorsi.put(getID(c), c);
    }

    @Override
    public Corso getByID(UUID id) {
        return mappaCorsi.entrySet().stream()
                .filter(k -> k.getKey().equals(id))
                .findFirst()
                .get()
                .getValue();
    }

    @Override
    public UUID getID(Corso c) {
        return mappaCorsi.entrySet().stream()
                .filter(k -> k.getValue().equals(c))
                .findFirst()
                .get()
                .getKey();
    }

    @Override
    public Corso get(String nome, int numeroCFU) {
        return mappaCorsi.values().stream()
                .filter(corso -> corso.getNomeCorso().equalsIgnoreCase(nome) && corso.getNumeroCFU() == numeroCFU)
                .findFirst().get();
    }

    @Override
    public void delete(Corso c) {
        mappaCorsi.remove(c);
    }

    @Override
    public List<Corso> getAllCorsi() {
        return new ArrayList<Corso>(mappaCorsi.values());
    }

    public String toString(){
        String s = "";
        for(Corso corso : mappaCorsi.values())
            s += corso.toString() + "\n";
        return s;
    }

}
