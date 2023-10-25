package esercizio1;
/*
Progettare una classe Contatore che permetta di
Istanziare la classe con un valore iniziale
Istanziare la classe senza un valore iniziale
Incrementare il conteggio attuale
Ottenere il conteggio attuale
Resettare il conteggio a zero
Resettare il conteggio ad un altro valore
*/

public class Contatore {

    private int contatore;

    public Contatore(){
       contatore = 0;
    }

    public Contatore(int iniziale){
        contatore = iniziale;
    }

    public void Incrementa(){
        this.contatore++;
    }

    public int getContatore(){
        return contatore;
    }

    public void reset(){
        contatore = 0;
    }
    public void reset(int valore){
        contatore = valore;
    }





}
