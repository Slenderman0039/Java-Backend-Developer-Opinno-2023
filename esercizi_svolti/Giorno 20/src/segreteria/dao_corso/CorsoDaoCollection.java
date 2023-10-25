package segreteria.dao_corso;

import segreteria.classi.Corso;
import segreteria.classi.Studente;
import segreteria.interfaccedao.CorsoDao;

import java.util.*;

public class CorsoDaoCollection implements CorsoDao {

    Map<UUID, Corso> mappaCorsi;

    public CorsoDaoCollection(){
        mappaCorsi = new HashMap<>();
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
