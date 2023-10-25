package eccezioni.esercizio3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try{
            int n = scanner.nextInt();
            if(n < 0) throw new ValoreNegativoException();
            else System.out.println("Numero positivo");
        }

        catch(ValoreNegativoException exc){
            System.out.println(exc.getMessage());
        }
    }
}
