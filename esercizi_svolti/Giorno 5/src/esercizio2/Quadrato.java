package esercizio2;

import esercizio3.Colore;

/*
Progettare una classe Quadrato, che permetta di
Istanziare la classe con la dimensione del lato del quadrato
Ottenere il perimetro del quadrato
Stampare il quadrato sulla console
 */
public class Quadrato {

    private double lato;
    private Colore colore = Colore.NERO; //attributo impostato di default


    public Quadrato(double lato){
        this.lato = lato;
    }

    public void perimetro(){
        System.out.println("Il perimetro è: "+(lato*4));
    }

    public void stampaQuadrato(){
        System.out.println("Il lato è: " + lato + "\n");
        perimetro();
    }

    public void setColore(Colore colore){
        this.colore = colore;
    }
    public Colore getColore(){
        return this.colore;
    }

}
