import java.util.Scanner;
public class Esercizio8 {
    public static void conta(){
        int vocali = 0, consonanti = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci la frase: ");
        String s = scanner.nextLine();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u')
                vocali++;
            else consonanti++;
        }
        System.out.println("Il numero di vocali: " + vocali);
        System.out.println("Il numero di consonanti: " + consonanti);
    }
}
