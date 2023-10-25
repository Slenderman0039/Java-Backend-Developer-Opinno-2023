package segreteria.dao_studente;

import segreteria.classi.Corso;
import segreteria.classi.Studente;
import segreteria.interfaccedao.StudenteDao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;

public class StudenteDaoCSV implements StudenteDao {

    Map<UUID, Studente> mappaStudenti;

    public void writeFileCSV(Path path){

        List<String> righe = new ArrayList<>();

        try{
            if (!(Files.exists(path)))
                Files.createFile(path);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> righeInverse = new ArrayList<>();
        for(int i = 0; i < righe.size(); i++){
            righeInverse.add(righe.get(righe.size() - i - 1));
        }

        try (BufferedWriter bw = Files.newBufferedWriter(path)) {

            for (String s : righeInverse) {
                bw.write(s);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public StudenteDaoCSV(){
        mappaStudenti = new HashMap<>();
    }

    public void readFileCSV(Path path){

        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            // legge una riga del file e passa alla successiva finché ce ne sono da leggere nel file buffer
            while ((line = br.readLine()) != null) {
                String[] riga = line.split(",");

                String matricola = riga[0];
                String nome = riga[1];
                String cognome = riga[2];
                LocalDate dataDiNascita = LocalDate.of(Integer.parseInt(riga[3]), Integer.parseInt(riga[4]), Integer.parseInt(riga[5]));

                insert(new Studente(matricola, nome, cognome, dataDiNascita));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Studente insert(Studente s) {
        mappaStudenti.put(UUID.randomUUID(), s);
        return s;
    }

    @Override
    public Studente update(Studente s) {
        mappaStudenti.put(getID(s), s);
        return s;
    }

    @Override
    public Studente getByNameAndSurname(String nome, String cognome) {
        return mappaStudenti.values().stream()
                .filter(corso -> corso.getNome().equalsIgnoreCase(nome) && corso.getCognome().equalsIgnoreCase(cognome))
                .findFirst().get();
    }

    @Override
    public Studente getByID(UUID id) {
        return mappaStudenti.entrySet().stream()
                .filter(k -> k.getKey().equals(id))
                .findFirst()
                .get()
                .getValue();
    }

    @Override
    public UUID getID(Studente s) {
        return mappaStudenti.entrySet().stream()
                .filter(k -> k.getValue().equals(s))
                .findFirst()
                .get()
                .getKey();
    }

    @Override
    public void delete(Studente s) {
        mappaStudenti.remove(s);
    }

    @Override
    public List<Studente> getAllStudenti() {
        return new ArrayList<>(mappaStudenti.values());
    }

    @Override
    public Corso aggiungiCorso(Corso c, List<Studente> studenti) {
        return null;
    }

    @Override
    public List<Corso> getCorsi(Studente s) {
        return getByID(getID(s)).getCorsi();
    }

    public String toString(){
        String s = "";
        for(Studente studente : mappaStudenti.values())
            s += studente.toString() + "\n";
        return s;
    }
}
