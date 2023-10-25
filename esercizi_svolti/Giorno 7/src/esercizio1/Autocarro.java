package esercizio1;

public class Autocarro extends Veicolo{
    private int capCarico;

    public Autocarro(String targa, int numPosti, int capCarico){
        super(targa, numPosti);
        this.capCarico = capCarico;
    }

    public int getCapCarico() {
        return capCarico;
    }

    public void setCapCarico(int capCarico) {
        this.capCarico = capCarico;
    }

    @Override
    public String toString(){
        return super.toString() + this.getCapCarico();
    }

}
