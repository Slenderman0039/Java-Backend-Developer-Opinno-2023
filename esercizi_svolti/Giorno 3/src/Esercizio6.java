/*  Scrivete una funzione che data una matrice quadrata in input, restituisce la somma della diagonale da sinistra
    a destra.
    Scrivete una seconda funzione che presa una matrice quadrata e un booleano a seconda del valore del
    booleano restituisce o la somma della diagonale da sinistra a destra o quella da destra a sinistra.
    Hint: usate la prima funzione nella seconda!
*/
import java.util.Scanner;
public class Esercizio6 {
    public static int diagonaleSinistra(){
        int[][] matrix = {{1, 7, 0, -1}, {-1, 3, 8, 5}, {2, 0, -2, 4}, {6, 1, 5, 9}};
        int sum = 0;
        for(int i = 0; i < 4; i++){
            sum += matrix[i][i];
        }
        return sum;
    }
    public static int diagonaleDestra(){
        int[][] matrix = {{1, 7, 0, -1}, {-1, 3, 8, 5}, {2, 0, -2, 4}, {6, 1, 5, 9}};
        int sum = 0;
        for(int i = 0; i < 4; i++){
            sum += matrix[i][3-i];
        }
        return sum;
    }
}
