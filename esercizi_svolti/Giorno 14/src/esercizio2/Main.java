package esercizio2;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;

public class Main {

    public static void main(String[] args) {

        Studente studente = new Studente("aaa","aaa","00000");
        Studente studente2 = new Studente("bbb","bbb","11111");

        Studente studente3 = new Studente("ccc","ccc","22222");
        Studente studente4 = new Studente("ddd","ddd","33333");

        StudentiEsame se = new StudentiEsame();
        se.aggiungiStudente(studente);
        se.aggiungiStudente(studente2);
        se.aggiungiStudente(studente3);

        StudentiEsame se2 = new StudentiEsame();
        se2.aggiungiStudente(studente3);
        se2.aggiungiStudente(studente4);

        MultiMappa mm = new MultiMappa();
        mm.put("Analisi",se.getStudenti());
        System.out.println(mm);

        MultiMappa mm2 = new MultiMappa();
        mm2.put("Analisi",se2.getStudenti());
        System.out.println(mm2);

        System.out.println("=============================");
        mm.putAll(mm2);
        System.out.println(mm);

        System.out.println("=============================");

        System.out.println(mm.get("Analisi","c"));

        System.out.println("=============================");

        System.out.println(mm.values());
        System.out.println("=============================");

        List<Studente> result = mm.values(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Studente studente1 = (Studente) o1;
                Studente studente2 = (Studente) o2;
                return studente1.compareTo(studente2);
            }
        });

        System.out.println(result);

        System.out.println("=============================");

        MultiMappa mm3 = mm.mapEach(new BiFunction() {
            public Object apply(Object o, Object o2) {
                String k = (String) o;
                Studente v = (Studente) o2;
                return new Studente(v.getNome()+" " + k, v.getCognome() + " " + k, v.getMatricola()+ " " + k);
            }
        });


        System.out.println(mm3);






    }


}