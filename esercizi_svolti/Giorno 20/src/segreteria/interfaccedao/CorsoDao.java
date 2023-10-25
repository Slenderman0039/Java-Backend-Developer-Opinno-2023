package segreteria.interfaccedao;

import segreteria.classi.Corso;
import segreteria.classi.Studente;

import java.util.List;
import java.util.UUID;

public interface CorsoDao {

    public Corso insert(Corso c);

    public Corso update(Corso c);

    public Corso getByID(UUID id);

    public UUID getID(Corso c);

    public Corso get(String nome, int numeroCFU);

    public void delete(Corso c);

    List<Corso> getAllCorsi();

    String toString();

}
