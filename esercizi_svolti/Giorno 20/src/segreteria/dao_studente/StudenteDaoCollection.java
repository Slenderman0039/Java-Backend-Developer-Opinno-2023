package segreteria.dao_studente;

import segreteria.classi.Corso;
import segreteria.classi.Studente;
import segreteria.interfaccedao.StudenteDao;

import java.util.*;
import java.util.stream.Collectors;

public class StudenteDaoCollection implements StudenteDao {

    Map<UUID, Studente> mappaStudenti;

    public StudenteDaoCollection(){
        mappaStudenti = new HashMap<>();
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

    public UUID getID(Studente s){
        return mappaStudenti.entrySet().stream()
                .filter(k -> k.getValue().equals(s))
                .findFirst()
                .get()
                .getKey();
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
    public void delete(Studente s) {
        mappaStudenti.remove(s);
    }

    @Override
    public List<Studente> getAllStudenti() {
        return new ArrayList<>(mappaStudenti.values());
    }
    public Corso aggiungiCorso(Corso c, List<Studente> studenti){
        for(Studente s : studenti)
            s.aggiungiCorso(c);
        return c;
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