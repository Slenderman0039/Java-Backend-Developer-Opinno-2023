/*  Scrivete una funzione che dato in input due numeri n ed m, crea un array lungo m che in ogni cella
    ha il valore di indice della cella moltiplicato per n */
public class Esercizio2 {
    public static int[] moltiplica(int n, int m){
        int[] arr = new int[m];
        for(int i = 0; i < m; i++)
            arr[i] = i*n;
        return arr;
    }
}
