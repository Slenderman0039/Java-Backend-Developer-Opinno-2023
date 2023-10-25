package esercizio1;

import java.util.Scanner;

public class BattagliaNavale {

    private Giocatore player1, player2;
    private Griglia griglia1, griglia2;

    public int initialize(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Un giocatore\n2. Due giocatori\n 3. Battaglia tra CPU");
        return scanner.nextInt();
    }

    public void createPlayers(){

        Scanner scanner = new Scanner(System.in);

        if (initialize() == 1){
            System.out.print("Nome: ");
            player1 = new Persona(scanner.next());
            player2 = new Computer();
        }

        else if(initialize() == 2){
            System.out.print("Giocatore 1: ");
            player1 = new Persona(scanner.next());

            System.out.print("Giocatore 2: ");
            player2 = new Persona(scanner.next());
        }

        else{
            player1 = new Computer();
            player2 = new Computer();
        }
    }

    public void createGriglie(){
        griglia1 = new Griglia();
        griglia2 = new Griglia();

        //IMPOSTO LE NAVI IN POSIZIONI DEFAULT


    }
}
