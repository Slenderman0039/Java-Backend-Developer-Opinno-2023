package esercizio3;

/*
Progettare una classe Colore, che permette di

Rappresentare un colore con i valori RGB (0-255)
Esporre due costanti, BIANCO e NERO

Aggiungere il colore alle classi Quadrato e Cerchio
Che di default sia NERO
Che sia modificabile
 */

public class Colore {
/*
    public final static String BIANCO = "(255,255,255)";
    public final static String NERO = "(0,0,0)";

    public String RGB(int R,int G,int B){
       String r = String.valueOf(R);
       String g =  String.valueOf(G);
       String b = String.valueOf(B);
        return "("+r+","+g+","+b+")";
    } */

    private int r;
    private int g;
    private int b;
    public static final Colore BIANCO = new Colore(255,255,255);
    public static final Colore NERO = new Colore(0,0,0);

    public Colore(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
