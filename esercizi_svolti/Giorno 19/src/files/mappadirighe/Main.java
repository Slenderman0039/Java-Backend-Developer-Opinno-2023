package files.mappadirighe;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        MappaRighe mappaRighe = new MappaRighe();
        Path path = Paths.get("Giorno 19","src","files","mappadirighe","righe.txt").toAbsolutePath();
        mappaRighe.mappa(path);
        System.out.println(mappaRighe.toString());

    }
}
