import java.util.Arrays;

public class Esercizio3 {
    public static int sommaArray(int[] arr, int length){
        int somma = 0;

        if(length < 0)
            return 0;
        else
            somma += arr[length] + sommaArray(arr, length-1);
        return somma;
    }
}
