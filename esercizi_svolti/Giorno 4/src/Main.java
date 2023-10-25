//ESERCIZI GIORNO 02/10/2023

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Esercizio1.stackOverflow(1000000);
        //Esercizio2.isPrime(50);

        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(Esercizio3.sommaArray(arr, arr.length-1));

        String s = "itopinonavevanonipoti";
        Esercizio4.palindromoRicorsivo(s, 0, s.length()-1);

        Esercizio5.tartaglia(10);
        System.out.println("--------------------");
        Esercizio6.stampaPerfetti(1000);
        System.out.println("--------------------");

        int[] arr_2 = { 1, 2, 4, 5, 8, 9, 4, 1, 2, 6, 1 };
        Arrays.sort(arr_2);
        System.out.println(Arrays.toString(arr_2));
        System.out.println(Esercizio7.binarySearch(arr_2, 0, arr_2.length, 6));
    }
}