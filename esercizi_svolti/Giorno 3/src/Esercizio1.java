// QUESTA SCHEDA DI ESERCIZI PARTE DALL'ESERCIZIO 4 DEL BLOCCO 02-02_ABC_in-Java

//Scrivete una funzione che dato un array di valori ne restituisce una copia dove i numeri dispari sono stati moltiplicati per 2.

public class Esercizio1 {
    public static int[] oddToEven(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 != 0)
                arr[i] *= 2;
        }
        return arr;
    }
}
