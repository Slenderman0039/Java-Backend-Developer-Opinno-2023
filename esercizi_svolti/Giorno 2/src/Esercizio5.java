import java.util.Scanner;
public class Esercizio5 {
    public static double harmonicSum(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci n: ");
        int n = scanner.nextInt();
        double harmonicSum = 0;
        while (n > 0)
            harmonicSum += (1/(double)n--);
        return harmonicSum;
    }
}
