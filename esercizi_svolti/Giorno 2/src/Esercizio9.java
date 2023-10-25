import java.util.Scanner;
public class Esercizio9 {
    public static void contaSecondi(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Numero di secondi: ");
        int secondi = scanner.nextInt(), giorni, ore, minuti;
        giorni = secondi/86400;
        if(giorni > 0)
            secondi = secondi - (86400 * giorni);
        ore = secondi/3600;
        if(ore > 0)
            secondi = secondi - (3600 * ore);
        minuti = secondi/60;
        if(minuti > 0)
            secondi = secondi - (60 * minuti);
        System.out.println("Giorni: " + giorni + "\nOre: " + ore + "\nMinuti: " + minuti + "\nSecondi: " + secondi);
    }
}
