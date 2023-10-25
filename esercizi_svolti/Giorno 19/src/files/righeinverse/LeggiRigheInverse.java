package files.righeinverse;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeggiRigheInverse {


    List<String> righe = new ArrayList<>();

    public void leggiFileAlContrario(Path pathRighe) {        // Paths.get("Giorno 19\files\righeinverse\righe.txt")

        // Per leggere il file righe.txt

        try (BufferedReader br = Files.newBufferedReader(pathRighe)) {
            String line;
            // legge una riga del file e passa alla successiva finché ce ne sono da leggere nel file buffer
            while ((line = br.readLine()) != null) {
                righe.add(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Per scrivere il file righeInverse.txt

        // Creo il file se non esiste

        Path pathRigheInverse = Paths.get("Giorno 19","src", "files", "righeinverse", "righeInverse.txt");
        try{
            if (!(Files.exists(pathRigheInverse)))
                Files.createFile(pathRigheInverse);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> righeInverse = new ArrayList<>();
        for(int i = 0; i < righe.size(); i++){
            righeInverse.add(righe.get(righe.size() - i - 1));
        }

        try (BufferedWriter bw = Files.newBufferedWriter(pathRigheInverse)) {

            for (String s : righeInverse) {
                bw.write(s);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
