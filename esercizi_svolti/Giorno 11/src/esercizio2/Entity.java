package esercizio2;

public abstract class Entity {

    private Coordinate posizione;

    public Entity(Coordinate posizione){ this.posizione = posizione; }

    public Entity(int x, int y){
        this.setPosizione(x, y);
    }

    public abstract String toString();

    public Coordinate getPosizione() {
        return posizione;
    }

    public void setPosizione(int x, int y) {
        this.posizione.setX(x);
        this.posizione.setY(y);
    }

    public void setPosizione(Coordinate c){
        this.posizione = c;
    }
}
