package esercizio2;

/*
Istanziare la classe con un costruttore che accetta un parametro
Ottenere la circonferenza del cerchio
Ottenere l’area del cerchio
 */

import esercizio3.Colore;

public class Cerchio {

    private double raggio;  //Attributo
    private Colore colore = Colore.NERO; //attributo impostato di default
    public Cerchio(double raggio){  //Costruttore parametrizzato
        this.raggio = raggio;   //assegnamo all'attributo il valore
    }

    public double circonferenza(){
        return 2*Math.PI*raggio;
    }

    public double area(){

        return Math.PI*raggio*raggio;
    }

    public void setColore(Colore colore){
        this.colore = colore;
    }
    public Colore getColore(){
        return this.colore;
    }

}
