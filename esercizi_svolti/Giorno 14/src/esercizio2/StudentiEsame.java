package esercizio2;

import java.util.ArrayList;

public class StudentiEsame {
    private ArrayList<Studente> studenti;

    public StudentiEsame(){
        studenti = new ArrayList<>();
    }
    public void aggiungiStudente(Studente s){
        studenti.add(s);
    }

    public ArrayList<Studente> getStudenti() {
        return studenti;
    }

    @Override
    public String toString() {
        String s = "";
        for(Studente st: studenti){
            s+= st.toString();
        }
        return s;
    }
}
