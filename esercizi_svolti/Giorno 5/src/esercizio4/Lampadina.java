package esercizio4;

/*
Progettare una classe Lampadina che rappresenti una lampadina elettrica
La lampadina può essere accesa, spenta o rotta
Espone due metodi
stato() che indica lo stato corrente della lampadina
click() che cambia lo stato da accesa a spenta o da spenta ad accesa, oppure rompe la lampadina
Una lampadina si rompe dopo un numero di click definito dal produttore.


La classe deve contenere uno o più campi che ne descrivano lo stato
Un costruttore
I metodi indicati sopra
 */


public class Lampadina {

    private int rottura=3;
    private int stato;
    //0 = spenta
    //1 = accesa
    //2 = rotta

    public Lampadina(){
        stato = 0;
    }

    public void click(){
        switch (stato){
            case 0:
                if(rottura<=0){
                    stato=2;
                    System.out.println("La lampadina si è rotta");
                    break;
                }
                rottura--;
                stato=1;
                System.out.println("Ho acceso la lampadina");
                break;
            case 1:
                if(rottura<=0){
                    stato=2;
                    System.out.println("La lampadina si è rotta");
                    break;
                }
                rottura--;
                stato=0;
                System.out.println("Ho spento la lampadina");
                break;
            case 2:
                System.out.println("La lampadina è rotta");
                break;
        }
    }


    public int getStatoInt(){
        return stato;
    }
    public int getRottura(){
        return rottura;
    }
    public void setStato(int stato){
        this.stato = stato;
    }

    public void decrementaRottura(){
        rottura--;
    }


    public String getStato(){
        if(stato==0){
            return "Spenta";
        }else if(stato==1){
            return "Accesa";
        }else{
            return "Lampadina rotta";
        }
    }



}
