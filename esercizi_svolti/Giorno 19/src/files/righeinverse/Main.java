package files.righeinverse;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        LeggiRigheInverse leggiRigheInverse = new LeggiRigheInverse();
        //leggiRigheInverse.leggiFileAlContrario(Paths.get("Giorno 19","files", "righeinverse", "righe.txt"));
       // System.out.println(Paths.get("Giorno 19","righeinverse","righe.txt").toAbsolutePath());
        leggiRigheInverse.leggiFileAlContrario(Paths.get("Giorno 19","src","files","righeinverse","righe.txt").toAbsolutePath());
    }

}
