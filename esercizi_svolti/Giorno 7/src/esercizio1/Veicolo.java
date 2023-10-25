package esercizio1;
public class Veicolo {
    private String targa;
    private int numPosti;

    public Veicolo(String targa, int numPosti){
        this.targa = targa;
        this.numPosti = numPosti;
    }

    public Veicolo(){}

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public int getNumPosti() {
        return numPosti;
    }

    public void setNumPosti(int numPosti) {
        this.numPosti = numPosti;
    }

    @Override
    public String toString(){
        return this.targa + ":";
    }
}
