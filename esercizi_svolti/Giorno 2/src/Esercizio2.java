import java.util.Scanner;
public class Esercizio2 {
    public static void stringReverse() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci la stringa: ");
        String s = scanner.next();
        for (int i = s.length() - 1; i >= 0; i--)
            System.out.print(s.charAt(i));
    }
}
