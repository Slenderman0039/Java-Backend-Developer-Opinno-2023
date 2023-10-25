import java.util.Scanner;
public class Esercizio6 {
    public static boolean isPalindrome(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci la stringa: ");
        String s = scanner.next(), reverse = "";
        for (int i = s.length() - 1; i >= 0; i--)
            reverse += s.charAt(i);
        if(s.equalsIgnoreCase(reverse))
            return true;
        return false;
    }
}
