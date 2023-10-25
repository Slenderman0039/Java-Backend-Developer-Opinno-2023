package segreteria.db;

import lombok.Getter;
import segreteria.dao_corso.CorsoDaoCollection;
import segreteria.dao_studente.StudenteDaoCollection;

@Getter
public class DummyDB {

    private static DummyDB instance;

    private StudenteDaoCollection studenti;
    private CorsoDaoCollection corsi;


    private DummyDB(){
        studenti = new StudenteDaoCollection();
        corsi = new CorsoDaoCollection();
    }

    public static DummyDB getInstance(){
        if(instance == null)
            instance = new DummyDB();
        return instance;
    }
}
