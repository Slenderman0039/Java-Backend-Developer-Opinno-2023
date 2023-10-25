//Dato un numero, stampare true se il numero è pari, false altrimenti
public class Esercizio2 {

    public static boolean verificaNumeroPari(){
        int n = Esercizio1.inserisciNumero();
        if(n % 2 == 0)
            return true;
        return false;
    }


}
