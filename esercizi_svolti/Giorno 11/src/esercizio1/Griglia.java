package esercizio1;

public class Griglia {

    private Casella[][] griglia;

    public Griglia(){
        griglia = new Casella[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                griglia[i][j] = new Casella();
            }
        }
    }

    public void setCella(Coordinate c, Casella.Stato stato){
        griglia[c.getX()][c.getY()].setStato(stato);
    }

    /*public boolean registraColpo(Casella c){
        if(c.getStato() == Casella.Stato.COLPITO){
            System.out.println("Casella già colpita");
            return false;
        }

        c.setPlayed(true);

    }*/

    public String toString(){
        String s = "";

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                if(!griglia[i][j].isPlayed()){
                    s += "[ ? ] ";
                }

                else{
                    if(griglia[i][j].getStato() == Casella.Stato.COLPITO){
                        s += "[ X ]";
                    } else{
                        if(griglia[i][j].getStato() == Casella.Stato.VUOTO){
                            s += "[ O ]";
                        }
                    }
                }
            }

            s += "\n"; //Fine riga
        }

        return s;
    }
}