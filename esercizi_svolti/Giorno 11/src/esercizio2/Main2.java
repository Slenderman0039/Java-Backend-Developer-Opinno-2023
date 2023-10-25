package esercizio2;

import java.util.Scanner;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;



public class Main2 {

    public static void main(String[] args) {

        //GENERO IL LABIRINTO

        Labirinto labirinto = new Labirinto();

        //OTTIMIZZO IL PERCORSO

        char[][] matrice = MatriceAdiacenzaLabirinto.fromMatrixtoCharMatrix(labirinto.getLabirinto());
        int[][] matriceAdiacenza = MatriceAdiacenzaLabirinto.creaMatriceAdiacenza(matrice);

        int source = -1; // Nodo di partenza (P)
        int destination = -1; // Nodo di destinazione (E)

        int n = matrice.length;
        int m = matrice[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrice[i][j] == 'P') {
                    source = i * m + j;
                } else if (matrice[i][j] == 'E') {
                    destination = i * m + j;
                }
            }
        }
        if (source != -1 && destination != -1) {
            boolean isPathPossible = MatriceAdiacenzaLabirinto.esistePercorso(matriceAdiacenza, source, destination);
            System.out.println("Percorso tra P e E? " + isPathPossible);
            //se isPathPossible è false allora rigenera il percorso.
            if(isPathPossible == false){
                System.out.println("Rigenero il percorso");
            }

        }




        //Labirinto.print2D(labirinto.getLabirinto());
        //System.out.println("Gioco del labirinto");
        Scanner scanner = new Scanner(System.in);

        String opzione = "";

        do{
            System.out.println(labirinto.stampaLabirinto());
            opzione = scanner.next();
            labirinto.muoviPersonaggio(opzione.charAt(0));
            //while(!labirinto.muoviMostro());
            System.out.println(labirinto.getGiocatore().getPosizione().toString());
        }while(opzione.charAt(0) != 'x');
    }
}