package esercizio2;



public class PrenotazioneSingola extends Prenotazione{

    private Postazione preferenza;

    public PrenotazioneSingola(String codice, Postazione preferenza){
        super(codice);
        this.preferenza = preferenza;
    }

    public Postazione getPreferenza() {
        return preferenza;
    }

    public void setPreferenza(Postazione preferenza) {
        this.preferenza = preferenza;
    }

    @Override
    public String toString(){
        return super.toString() + ": Preferenza " + this.getPreferenza();
    }
}
