package esercizio6;

public class Impianto {
   public static boolean corrente=true;

    public static void stacca(){
        System.out.println("Impianto spento");
        corrente = false;
    }

    public static void riattacca(){
        System.out.println("Impianto in funzione");
        corrente = true;
    }

    public static boolean getCorrente() {
        return corrente;
    }

}
