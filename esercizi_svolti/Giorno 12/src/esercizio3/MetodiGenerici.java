package esercizio3;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MetodiGenerici<T> {

    public static <T> List<T> inverti(List<T> lista){

        Collections.reverse(lista);

        return lista;
    }

    public static <T> T max(List<T> lista){
        lista.sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.hashCode() > o2.hashCode() ? 1 : o1.hashCode() < o2.hashCode() ? -1 : 0;
            }
        }.reversed());

        return lista.get(0);
    }
}
