package esercizio1;


public class Main {
    
    public static int id = 0;
    
    public static void main(String[] args) {

        Canzone canzone1 = new Canzone("aaa","bbb");
        Canzone canzone2 = new Canzone("bbb","bbb");
        Canzone canzone3 = new Canzone("ccc","ccc");
        Canzone canzone4 = new Canzone("ddd","ddd");
        Canzone canzone5 = new Canzone("aaa","aaa");
        Canzone canzone6 = new Canzone("aaa","bbb");

        System.out.println(canzone1);
        System.out.println(canzone2);
        System.out.println(canzone3);

        System.out.println("------------------------------------");
        Raccolta raccolta = new Raccolta();

        raccolta.aggiungiCanzone(canzone4);
        System.out.println(raccolta);

        raccolta.aggiungiCanzone(canzone3);
        System.out.println(raccolta);

        raccolta.aggiungiCanzone(canzone2);
        System.out.println(raccolta);

        raccolta.aggiungiCanzone(canzone1);
        System.out.println(raccolta);

        raccolta.aggiungiCanzone(canzone5);
        System.out.println(raccolta);

        raccolta.aggiungiCanzone(canzone6);
        System.out.println(raccolta);

        System.out.println("------------------------------------");
        RaccoltaOrdinata raccoltaOrdinata = new RaccoltaOrdinata();
        raccoltaOrdinata.aggiungiCanzone(canzone3);
        raccoltaOrdinata.aggiungiCanzone(canzone2);
        raccoltaOrdinata.aggiungiCanzone(canzone4);
        raccoltaOrdinata.aggiungiCanzone(canzone1);
        raccoltaOrdinata.aggiungiCanzone(canzone5);

        System.out.println(raccoltaOrdinata);
    }
}