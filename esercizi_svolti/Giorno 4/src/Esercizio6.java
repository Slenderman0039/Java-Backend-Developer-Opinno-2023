public class Esercizio6 {
    public static void stampaPerfetti(int n){
        int somma = 0;
        for(int i = 1; i < n; i++){             //i = il numero che stiamo esaminando
            for(int j = 1; j < i; j++){         //j serve per controllare se è un divisore
                if(i % j == 0)
                    somma += j;
            }
            if(somma == i)
                System.out.print(i + " ");
            somma = 0;
        }
    }
}


