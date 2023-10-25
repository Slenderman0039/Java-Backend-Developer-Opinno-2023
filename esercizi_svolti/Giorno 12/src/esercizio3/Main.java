package esercizio3;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> listaInteri = new LinkedList<>();

        listaInteri.add(1);
        listaInteri.add(5);
        listaInteri.add(2);
        listaInteri.add(35);
        listaInteri.add(123);
        listaInteri.add(121);
        listaInteri.add(13);

        System.out.println(MetodiGenerici.inverti(listaInteri));

        System.out.println(MetodiGenerici.max(listaInteri));

        List<String> listaStringhe = new LinkedList<>();

        listaStringhe.add("Pasquale");
        listaStringhe.add("Alessandro");
        listaStringhe.add("Jacopo");
        listaStringhe.add("Giuseppe");
        listaStringhe.add("Claudio");

        System.out.println(MetodiGenerici.inverti(listaStringhe));

        System.out.println(MetodiGenerici.max(listaStringhe));

    }
}
