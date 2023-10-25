//ESERCIZI GIORNO 03/10/2023

import esercizio6.Impianto;
import esercizio1.Contatore;
import esercizio2.Cerchio;
import esercizio2.Quadrato;
import esercizio3.Colore;
import esercizio4.Lampadina;
import esercizio5.Interruttore;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*
        Contatore pasquale = new Contatore(20);
        System.out.println(pasquale.getContatore());
        pasquale.Incrementa();
        pasquale.Incrementa();
        System.out.println(pasquale.getContatore());
        pasquale.reset();
        System.out.println(pasquale.getContatore());
        pasquale.reset(100);
        System.out.println(pasquale.getContatore());

        Contatore sara = new Contatore();
        System.out.println(sara.getContatore());
        sara.Incrementa();
        sara.Incrementa();
        System.out.println(sara.getContatore());*/

        /*
        Quadrato quadrato = new Quadrato(2);
        quadrato.perimetro();
        quadrato.stampaQuadrato();*/

        /*
        Scanner scanner = new Scanner(System.in);
        int valore = scanner.nextInt();

        Cerchio cerchio = new Cerchio(valore);
        System.out.println(cerchio.circonferenza());
        System.out.println(cerchio.area());

        System.out.println("Colore: "+ cerchio.getColore());
        Colore blu = new Colore(255,42,98);
        cerchio.setColore(blu);
        System.out.println("Colore: "+ cerchio.getColore());*/

        Lampadina lampadina1 = new Lampadina();
        Lampadina lampadina2 = new Lampadina();
        /*System.out.println(lampadina.getStato()); //Spento
        lampadina.click();
        System.out.println(lampadina.getStato()); //Acceso
        lampadina.click();
        System.out.println(lampadina.getStato()); //Spento
        lampadina.click();
        System.out.println(lampadina.getStato()); //Accesa
        lampadina.click();
        System.out.println(lampadina.getStato()); //Rotto*/

        Interruttore interruttore = new Interruttore(lampadina1);
        interruttore.aggiungiLampadina(lampadina2);
        interruttore.click(); //accende
        interruttore.click();//spegne
        interruttore.click();//accende

        Impianto.stacca();
        interruttore.click(); //spento
        Impianto.riattacca();
        interruttore.click();//rompe




    }
}