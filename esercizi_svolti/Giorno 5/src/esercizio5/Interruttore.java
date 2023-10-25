package esercizio5;

/*
Progettare una classe Interruttore che rappresenta un interruttore per la lampadina fatta precedentemente
Ogni interruttore è collegato ad una lampadina e ne regola accensione e spegnimento
Definite quali campi, metodi e costruttori siano opportuni
Creare un metodo di test che istanzia due interruttori e li collega alla stessa lampadina e poi
offre all’utente ripetutamente la possibilità di clickare uno dei due interruttori oppure di
terminare l’esecuzione

 */


import esercizio6.Impianto;
import esercizio4.Lampadina;

import java.util.ArrayList;

public class Interruttore {

    private Lampadina lampadina;
    private Lampadina lampadina1;

    private ArrayList<Lampadina> lampadine = new ArrayList<Lampadina>();

    public Interruttore(Lampadina lampadina){
        this.lampadina = lampadina;
        lampadine.add(lampadina);
    }

    public Interruttore(Lampadina lampadina,Lampadina lampadina1){
        this.lampadina = lampadina;
        this.lampadina1 = lampadina1;
        lampadine.add(lampadina);
        lampadine.add(lampadina1);
    }

    public void aggiungiLampadina(Lampadina lampadina1){
        this.lampadina1 = lampadina1;
        lampadine.add(lampadina1);
    }

    public void click() {
        int numero = 0;
        for (Lampadina lampadina : lampadine) {
            if (Impianto.getCorrente()) {
                numero++;
                switch (lampadina.getStatoInt()) {
                    case 0:
                        if (lampadina.getRottura() <= 0) {
                            lampadina.setStato(2);
                            System.out.println("La lampadina " + numero + " si è rotta");
                            break;
                        }
                        lampadina.decrementaRottura();
                        lampadina.setStato(1);
                        System.out.println("Ho acceso la lampadina " + numero);
                        break;
                    case 1:
                        if (lampadina.getRottura() <= 0) {
                            lampadina.setStato(2);
                            System.out.println("La lampadina " + numero + " si è rotta");
                            break;
                        }
                        lampadina.decrementaRottura();
                        lampadina.setStato(0);
                        System.out.println("Ho spento la lampadina " + numero);
                        break;
                    case 2:
                        System.out.println("La lampadina " + numero + " è rotta");
                        break;
                }
            }else{
                System.out.println("Manca corrente");
                lampadina.setStato(0);
            }
        }
    }
}
