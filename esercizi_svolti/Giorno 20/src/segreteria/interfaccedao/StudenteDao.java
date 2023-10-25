package segreteria.interfaccedao;

import segreteria.classi.Corso;
import segreteria.classi.Studente;
import java.util.List;
import java.util.UUID;

public interface StudenteDao {

    public Studente insert(Studente s);
    public Studente update(Studente s);
    public Studente getByNameAndSurname(String nome, String cognome);
    public Studente getByID(UUID id);
    public UUID getID(Studente s);

    public void delete(Studente s);

    List<Studente> getAllStudenti();

    Corso aggiungiCorso(Corso c, List<Studente> studenti);

    List<Corso> getCorsi(Studente s);

    String toString();

}
