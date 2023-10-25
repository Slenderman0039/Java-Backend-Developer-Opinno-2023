/*Date tre stringhe a, b e c in input, stampare c dopo aver rimpiazzato, all’interno di c, ogni
occorrenza compresa tra due spazi di a con b. Ad esempio, date in input le stringhe «a», «b», «a
abc d», stampare a video «a bbc d». Potete dare per assunto che la stringa c conterrà sempre e
solo due spazi.*/

import java.util.Scanner;
public class Esercizio4 {
    public static Scanner scanner = new Scanner(System.in);

    public static String replaceIntruder(String a, String b, String c){
        String[] s = c.split(" ");
        s[1] = s[1].replace(a, b);
        return s[0] + " " + s[1] + " " + s[2];
    }


}
