package esercizio2;

public class PrenotazioneDiGruppo extends PrenotazioneSingola{
    private int numeroPosti;

    public PrenotazioneDiGruppo(String codice, Postazione preferenza, int numeroPosti) {
        super(codice, preferenza);
        this.numeroPosti = numeroPosti;
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }

    public void setNumeroPosti(int numeroPosti) {
        this.numeroPosti = numeroPosti;
    }

    @Override
    public String toString(){
        return super.toString() + ", N. Persone " + this.numeroPosti;
    }
}