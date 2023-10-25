/* Scrivere un programma Java che permetta all’utente di inserire due numeri interi e,
successivamente, stampi a video il risultato di addizione, sottrazione, moltiplicazione e divisione
tra i due numeri.*/

import java.util.Scanner;
public class Esercizio1 {

    public static Scanner scanner = new Scanner(System.in);

    public static int inserisciNumero(){
        int num;
        System.out.print("Inserisci numero: ");
        num = scanner.nextInt();
        return num;
    }

    public static int sommaNumeri(int a, int b) {
        int somma = a + b;
        return somma;
    }

    public static int differenza(int a, int b){

        int differenza = a - b;
        return differenza;
    }

    public static int prodotto(int a, int b){
        int risultato = a * b;
        return risultato;
    }

    public static double divisione(int a, int b){
        double rapporto = (double) a / (double) b;
        return rapporto;
    }
}
