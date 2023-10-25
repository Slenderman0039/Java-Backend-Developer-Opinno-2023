package esercizio1;
import java.util.ArrayList;

public class DistributoreDiBevande {

    private double saldo, resto;
    private int numProdotti;
    ArrayList<Prodotto> prodotti;

    public DistributoreDiBevande(int numProdotti){
        this.numProdotti = numProdotti;
        prodotti = new ArrayList<>();
        for (int i = 0; i < this.numProdotti; i++) {
            prodotti.add(i, null);
        }
        this.saldo = 0;
        this.resto = 0;
    }

    public double saldoAttuale() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getResto() {
        saldo = 0;
        return resto;
    }

    public void setResto(double resto) {
        this.resto = resto;
    }

    public int getNumProdotti() {
        return numProdotti;
    }

    public void caricaProdotto(Prodotto p){
        for(int i = 0; i < this.numProdotti; i++){
            if(prodotti.get(i) == null){
                prodotti.set(i, p);
                return;
            }
        }
    }

    public void inserisciImporto(double importo){ this.saldo += importo; }

    public Prodotto scegliProdotto(String codice){
        for (int i = 0; i < this.numProdotti; i++) {
            if(prodotti.get(i) instanceof Prodotto){
                if(codice.equalsIgnoreCase(prodotti.get(i).getCodice())){
                    if(this.saldo >= prodotti.get(i).getPrezzo()){
                        this.saldo -= prodotti.get(i).getPrezzo();
                        this.resto = this.saldo;

                        Prodotto tmp = prodotti.get(i);
                        prodotti.set(i, null);
                        return tmp;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String toString(){
        String s = "";

        for(Object i : prodotti){
            if(i instanceof Prodotto){
                Prodotto i2 = (Prodotto)i;
                s += i2.toString() + "\n";
            }
        }

        /*for(int i = 0; i < this.numProdotti; i++) {
            if(prodotti.get(i) instanceof Prodotto){
                s += prodotti.get(i).toString() + "\n";
            }
        }*/
        return s;
    }
}