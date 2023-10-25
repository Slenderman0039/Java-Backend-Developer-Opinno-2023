package posizione;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Posizione {

    private double longitudine, latitudine;

    public String toString(){ return longitudine + " : " + latitudine; }
}
