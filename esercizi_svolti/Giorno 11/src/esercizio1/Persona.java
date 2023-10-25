package esercizio1;

import java.util.Scanner;

public class Persona extends Giocatore{


    public Persona(String nome){ super(nome); }

    public Coordinate inserisciCoordinate(){

        Scanner scanner = new Scanner(System.in);
        int x, y;

        System.out.print("Coordinata x: ");
        x = scanner.nextInt();

        System.out.print("Coordinata y: ");
        y = scanner.nextInt();

        return new Coordinate(x, y);
    }

    public void gioca(Coordinate c){}

}
