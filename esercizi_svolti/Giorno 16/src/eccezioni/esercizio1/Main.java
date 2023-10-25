package eccezioni.esercizio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n_1 = scanner.nextInt();
        int n_2 = scanner.nextInt();

        try{
            System.out.println(n_1 / n_2);
        }
        catch(ArithmeticException exc){
            System.out.println(exc);
        }

        //System.out.println(n_1 / n_2);
    }
}