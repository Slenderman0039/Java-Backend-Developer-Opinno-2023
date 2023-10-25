package esercizio2;

public class SpazioVuoto extends Entity{

    public SpazioVuoto(Coordinate posizione) { super(posizione); }

    public SpazioVuoto(int x, int y){
        super(x, y);
    }

    public String toString(){ return "-"; }
}
