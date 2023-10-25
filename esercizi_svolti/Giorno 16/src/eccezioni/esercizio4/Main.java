package eccezioni.esercizio4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try{
            String s = scanner.next();
            if(s == "") throw new NullPointerException();
            int stringToInt = Integer.parseInt(s);
            System.out.println("Stringa convertita a numero");
        }
        catch(NumberFormatException exc){
            System.out.println(exc);
        }
        catch(NullPointerException exc){
            System.out.println(exc);
        }
    }
}