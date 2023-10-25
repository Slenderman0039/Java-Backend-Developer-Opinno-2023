public class Esercizio1 {

    //Scrivere un metodo che, dato un char a e una stringa b, stampa il numero di occorrenze di a in b

    public static void countOccurrences(char a, String b){
        int counter = 0;
        a = String.valueOf(a).toLowerCase().charAt(0);
        b = b.toLowerCase();
        for(int i = 0; i < b.length(); i++){
            if(b.charAt(i) == a) counter++;
        }
        System.out.println("Il numero di volte in cui spunta il carattere è: " + counter);
    }
}
