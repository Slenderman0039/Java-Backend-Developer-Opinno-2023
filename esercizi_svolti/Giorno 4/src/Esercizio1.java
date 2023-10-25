// Scrivete una funzione ricorsiva che vada in stack overflow
public class Esercizio1 {
    public static int stackOverflow(int n){
        int somma = 0;
        if (n == 0)
            return 0;
        else{
            somma += stackOverflow(n + 1) + stackOverflow(n + 2) + stackOverflow(n + 3);
        }
        return somma;
    }
}
