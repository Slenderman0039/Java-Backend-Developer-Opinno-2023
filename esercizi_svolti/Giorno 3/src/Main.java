//ESERCIZI GIORNO 27/09/2023

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Esercizio 1

        Scanner scanner = new Scanner(System.in);

        int[] arr = {1, 2, 3, 4, 5, 7};
        arr = Esercizio1.oddToEven(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("--------------------------");
        System.out.println("--------------------------");

        //Esercizio 2
        System.out.println(Arrays.toString(Esercizio2.moltiplica(5,6)));
        System.out.println("--------------------------");

        //Esercizio 3
        System.out.println("Settimo elemento di fibonacci: " + Esercizio3.fibonacci(7));
        System.out.println("--------------------------");


        //Esercizio 4
        Esercizio4.anagrammi("dfh", "nnl");

        //Esercizio 5
        //Esercizio5.computeMinAndMax();
        System.out.println("--------------------------");

        //Esercizio 6
        System.out.print("Diagonale sinistra[0] | Diagonale destra[1]: ");
        int flag = scanner.nextInt();
        if(flag == 0) System.out.println(Esercizio6.diagonaleSinistra());
        else    System.out.println(Esercizio6.diagonaleDestra());

    }
}