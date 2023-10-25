package files.mappadirighe;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MappaRighe {

    Map<String, List<String>> mappa_kv = new HashMap<>();
    List<String> sottolista;
    public void mappa(Path pathRighe){

        try (BufferedReader br = Files.newBufferedReader(pathRighe)) {
            String line;
            // legge una riga del file e passa alla successiva finché ce ne sono da leggere nel file buffer
            while ((line = br.readLine()) != null) {
                sottolista = new ArrayList<>();
                String[] riga_kv = line.split(":");
                for(String element : riga_kv[1].split(",")){
                    sottolista.add(element);
                    //System.out.println(element);
                }
                mappa_kv.put(riga_kv[0],sottolista);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "MappaRighe{" +
                "mappa_kv=" + mappa_kv +
                '}';
    }
}
