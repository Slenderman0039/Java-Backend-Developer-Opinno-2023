import java.util.Arrays;
import java.util.Scanner;

/*Dato un array di interi (inseriti dall’utente, separati da virgola e senza spazi),
 effettuare la conversione dei valori in interi e stampare in ordine minimo e massimo (separati da virgola).
 Gli interi inseriti possono anche assumere valori negativi.
*/
public class Esercizio5 {
    public static int[] parseNumbers(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci stringa: ");
        String s = scanner.next();
        String[] split = s.split(",");
        int[] arr = new int[split.length];
        for(int i = 0; i < split.length; i++){
            arr[i] = Integer.parseInt(split[i]);
        }
        return arr;
    }

    public static void computeMinAndMax(){
        int[] arr = parseNumbers();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Minimo: " + arr[0] + "\nMassimo: " + arr[arr.length - 1]);
    }
}
