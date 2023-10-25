package esercizio1;

public class Computer extends Giocatore{

    private int counterId;
    private final int id;

    public Computer(){
        this.id = counterId++;
        this.setNome("CPU " + this.id);
    }

    @Override
    public Coordinate inserisciCoordinate() { return new Coordinate((int) (Math.random() * 5), (int) (Math.random() * 5)); }

    public void gioca(Coordinate c){

    }
}
