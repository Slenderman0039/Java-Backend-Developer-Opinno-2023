/*Date tre stringhe a, b e c in input, stampare l’intero corrispondente al numero di stringhe uguali
tra loro (ignorando maiuscole e minuscole). Esempio: se a, b e c sono uguali tra loro stamperà
«3», se invece a e b sono uguali ma c è diversa stamperà 2 etc.*/

import java.util.Scanner;
public class Esercizio5 {

    public static Scanner scanner = new Scanner(System.in);
    public static int compareStrings(){
        String str1, str2, str3;
        int counter = 1;

        System.out.print("Stringa 1: ");
        str1 = scanner.nextLine();
        System.out.print("Stringa 2: ");
        str2 = scanner.nextLine();
        System.out.print("Stringa 3: ");
        str3 = scanner.nextLine();
        if(str1.toUpperCase().equals(str2.toUpperCase())) counter++;
        if(str2.toUpperCase().equals(str3.toUpperCase())) counter++;

        if (counter == 1) return 0;
        else return counter;
    }
}
