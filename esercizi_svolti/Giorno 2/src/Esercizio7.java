import java.util.Scanner;
//PRIMO ESERCIZIO SLIDE "02-02_ABC_in_Java. I PRIMI 3 ESERCIZI SONO IN QUESTA SCHEDA"
public class Esercizio7 {
    public static void ritornaQuadrato(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il numero: ");
        int n = scanner.nextInt(), sum = 0, num_dispari = 1;
        System.out.print(n + " = ");
        while(sum != n){
            System.out.print(num_dispari + " + ");
            sum += num_dispari;
            num_dispari += 2;
        }
    }
}
