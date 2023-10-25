package esercizio1;

public abstract class Giocatore {

    private String nome;
    private int numMosse;

    public Giocatore(String giocatore){
        this.nome = nome;
        this.numMosse = 0;
    }

    public Giocatore(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public abstract Coordinate inserisciCoordinate();
    public abstract void gioca(Coordinate c);

    public void incrementaMossa(){ this.numMosse++; }

    public String toString(){
        return nome + "Mosse: " + numMosse;
    }
}
