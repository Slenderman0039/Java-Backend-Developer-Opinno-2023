package segreteria.db;

import lombok.Getter;
import segreteria.dao_corso.CorsoDaoCSV;
import segreteria.dao_studente.StudenteDaoCSV;

@Getter
public class DBCSV {

    private static DBCSV instance;

    private StudenteDaoCSV studenti;
    private CorsoDaoCSV corsi;


    private DBCSV(){
        studenti = new StudenteDaoCSV();
        corsi = new CorsoDaoCSV();
    }

    public static DBCSV getInstance(){
        if(instance == null)
            instance = new DBCSV();
        return instance;
    }

}
