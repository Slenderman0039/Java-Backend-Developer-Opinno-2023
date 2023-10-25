import java.util.Arrays;

/*  Due stringhe a e b sono dette anagrammi se contengono gli stessi caratteri con le stesse frequenze.
    Ad esempio, gli anagrammi di CAT sono CAT, ACT, TAC, TCA, ATC, e CTA.Date due stringhe
    a e b in input, stampare «anagrammi» se sono anagrammi (case-insensitive), «non anagrammi» altrimenti.
 */
public class Esercizio4 {
    public static void anagrammi(String a, String b){

        if(a.length() == b.length()){
            a = a.toUpperCase();
            b = b.toUpperCase();
            int[] arr_A = new int[26];
            int[] arr_B = new int[26];

            for(int i = 0; i < 26; i++){
                arr_A[i] = 0;
                arr_B[i] = 0;
            }

            for(int i = 0; i < a.length(); i++){
                arr_A[a.charAt(i) - 'A']++;
            }

            for(int i = 0; i < a.length(); i++){
                arr_B[b.charAt(i) - 'A']++;
            }

            System.out.println(Arrays.toString(arr_A));
            System.out.println(Arrays.toString(arr_B));

            if(Arrays.equals(arr_A, arr_B)){
                System.out.println("anagrammi");
                return;
            }

        }
            System.out.println("non anagrammi");
    }
}
