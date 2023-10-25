import java.util.ArrayList;

public class Esercizio2 {
    public static void isPrime(int n){
        ArrayList<Integer> numeriPrimi = new ArrayList<Integer>();

        for(int i = 1; i <= n; i++){        //Il numero che stiamo controllando
            boolean flag = true;

            for(int j = 2; j <= i/2; j++){
                if(i % j == 0){                 //10 / 5 = 2 ---- 10 % 5 = 0
                    //System.out.println(i + "non è primo");
                    flag = false;
                }
            }
            if(flag == true) {
                numeriPrimi.add(i);
                //System.out.println(i + "è primo");
            }
        }
        System.out.println("Numeri primi fino a " + n + ": " + numeriPrimi.toString());
    }
}
