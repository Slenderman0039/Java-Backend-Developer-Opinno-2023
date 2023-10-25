package eccezioni.esercizio2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String s = scanner.next();

        try{
            int stringToInt = Integer.parseInt(s);
            System.out.println("Stringa convertita a numero");
        }
        catch(NumberFormatException exc){
            System.out.println(exc);
        }
    }
}