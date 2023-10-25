package esercizio2;

public class Prenotazione {

    public enum Postazione {
        INTERNO,
        ESTERNO;
    }

    private String codice;
    private Postazione postoAssegnato;

    public Prenotazione(String codice){
        this.codice = codice;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public Postazione getPostoAssegnato() {
        return postoAssegnato;
    }

    public void setPostoAssegnato(Postazione postoAssegnato) {
        this.postoAssegnato = postoAssegnato;
    }

    @Override
    public String toString(){
        return this.codice + ", Posto assegnato " + this.getPostoAssegnato();
    }
}
