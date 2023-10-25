/*Data una stringa, stampare la stessa stringa invertendone il contenuto a partire dal primo spazio,
ad esempio data la stringa «come stai» stampare a video «stai come». Potete dare per assunto
che la stringa conterrà sempre un solo spazio.*/

import java.util.Scanner;
public class Esercizio3 {

    public static Scanner scanner = new Scanner(System.in);
    public static String reverseString(){
        String sub1, sub2, inverso;
        System.out.print("Inserisci stringa: ");
        String s = scanner.nextLine();
        sub1 = s.substring(0, s.indexOf(" "));
        sub2 = s.substring(s.indexOf(" ") + 1);
        inverso = sub2 + " " + sub1;
        return inverso;
    }
}
