package esercizio1;

public class Automobile extends Veicolo{
    private int numPorte;

    public Automobile(String targa, int numPosti, int numPorte){
        super(targa, numPosti);
        this.numPorte = numPorte;
    }

    public int getNumPorte() {
        return numPorte;
    }

    public void setNumPorte(int numPorte) {
        this.numPorte = numPorte;
    }

    @Override
    public String toString(){
        return super.toString() + this.numPorte;
    }


}