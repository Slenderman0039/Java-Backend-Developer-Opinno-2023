import java.util.Scanner;
public class Esercizio3 {
    public static boolean isPrime(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il numero: ");
        int n = scanner.nextInt();
        boolean flag = true;
        for(int k = 2; k < n; k++){
            if(n % k == 0)
                return false;
        }
        return true;
    }
}
