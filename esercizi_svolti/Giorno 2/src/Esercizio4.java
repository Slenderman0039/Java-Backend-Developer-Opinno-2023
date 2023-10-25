import java.util.Scanner;
public class Esercizio4 {
    public static int factorial(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il numero: ");
        int n = scanner.nextInt(), factorial = 1;
        if(n < 0) return 0;
        else if(n == 0) return 1;
        while(n > 0)
            factorial = factorial * (n--);
        return factorial;
    }
}
