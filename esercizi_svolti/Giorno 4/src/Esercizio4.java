public class Esercizio4 {
    public static void palindromoRicorsivo(String s, int i, int j){
        if(i > j){
            System.out.println("È palindroma");
            return;
        }

        if(s.charAt(i) != s.charAt(j)){
            System.out.println("Non è palindroma");
            return;
        }
        else{
            //System.out.println(s.charAt(i) + " è uguale a " + s.charAt(j));
            palindromoRicorsivo(s, i+1, j-1);
        }
    }
}

