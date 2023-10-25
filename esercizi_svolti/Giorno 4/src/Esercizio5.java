import java.util.Arrays;
import java.util.ArrayList;
public class Esercizio5 {
    public static int[] tartaglia(int n){
        int[] arr = new int[n+1];
        arr[0] = 1;

        if(n == 0){
            System.out.println(Arrays.toString(arr));
            return arr;
        }

        else{
            arr[n] = 1;
            int[] arr_precedente = tartaglia(n-1);
            for(int j = 1; j < n; j++){
                arr[j] = arr_precedente[j] + arr_precedente[j-1];
                //System.out.println(arr[j] + " = " + arr_precedente[j] + " + " + arr_precedente[j-1]);
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static void tartaglia(){
        int n = 7;
        ArrayList<int[]> list = new ArrayList<>();
        int[] array = {1};
        int[] array2 = {1,1};
        list.add(array);
        list.add(array2);
        for(int i=2;i<=n;i++){
            int[] riga = new int[i+1];
            System.out.println("<-------->");
            for(int j=0;j<riga.length; j++){
                if(j==0){
                    System.out.println("QUI1");
                    riga[j] = 1;
                } else if(j==riga.length-1){
                    System.out.println("QUI2");
                    riga[j] = 1;
                }else{
                    System.out.println("QUI3");
                    riga[j] = list.get(i-1)[j-1] + list.get(i-1)[j];
                }
            }
            list.add(riga);
        }
        for(int q=0;q<list.size();q++){
            System.out.println(Arrays.toString(list.get(q)));
        }
    }
}
