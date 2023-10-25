package gruppoordinamento;

public class MainBubble {
    public static void main(String[] args) {

        int[] arr_dieci = new int[10];
        int[] arr_mille = new int[1000];
        int[] arr_milione = new int[1000000];

        int[] arr_dieci_contrario = new int[10];
        int[] arr_mille_contrario = new int[1000];
        int[] arr_milione_contrario = new int[1000000];
        long startTime, estimatedTime;

        SortingAlgorithms.generateRandomArray(arr_dieci, 10);
        //System.out.println(Arrays.toString(arr_dieci));

        SortingAlgorithms.generateRandomArray(arr_mille, 1000);
        //System.out.println(Arrays.toString(arr_mille));

        SortingAlgorithms.generateRandomArray(arr_milione, 1000000);
        //System.out.println(Arrays.toString(arr_milione));


        System.out.println("-----Bubble Sort Array[10]-----");


        //CASO MEDIO: ARRAY GENERATO RANDOMICAMENTE

        startTime = System.nanoTime();
        SortingAlgorithms.bubbleSort(arr_dieci);
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("#CASO MEDIO#\nArray Generato randomicamente: " + estimatedTime + "(ns)");


        //CASO MIGLIORE: L'ARRAY È GIA ORDINATO

        startTime = System.nanoTime();
        SortingAlgorithms.bubbleSort(arr_dieci);
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("#CASO MIGLIORE#\nArray già ordinato: " + estimatedTime + "(ns)");


        //CASO PEGGIORE: ARRAY ORDINATO AL CONTRARIO
        ;
        for (int i = 0; i < 10; i++) {
            arr_dieci_contrario[i] = arr_dieci[9 - i];
        }

        startTime = System.nanoTime();
        SortingAlgorithms.bubbleSort(arr_dieci_contrario);
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("#CASO PEGGIORE#\nArray ordinato al contrario: " + estimatedTime + "(ns)");


        System.out.println("\n\n");

        System.out.println("-----Bubble Sort Array[1.000]-----");


        //CASO MEDIO: ARRAY GENERATO RANDOMICAMENTE

        startTime = System.nanoTime();
        SortingAlgorithms.bubbleSort(arr_mille);
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("#CASO MEDIO#\nArray Generato randomicamente: " + estimatedTime + "(ns)");


        //CASO MIGLIORE: L'ARRAY È GIA ORDINATO

        startTime = System.nanoTime();
        SortingAlgorithms.bubbleSort(arr_mille);
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("#CASO MIGLIORE#\nArray già ordinato: " + estimatedTime + "(ns)");


        //CASO PEGGIORE: ARRAY ORDINATO AL CONTRARIO

        for (int i = 0; i < 1000; i++) {
            arr_mille_contrario[i] = arr_mille[999 - i];
        }

        startTime = System.nanoTime();
        SortingAlgorithms.bubbleSort(arr_mille_contrario);
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("#CASO PEGGIORE#\nArray ordinato al contrario: " + estimatedTime + "(ns)");


        System.out.println("\n\n");

        System.out.println("-----Bubble Sort Array[1.000.000]-----");


        //CASO MEDIO: ARRAY GENERATO RANDOMICAMENTE

        startTime = System.nanoTime();
        SortingAlgorithms.bubbleSort(arr_milione);
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("#CASO MEDIO#\nArray Generato randomicamente: " + estimatedTime + "(ns)");


        //CASO MIGLIORE: L'ARRAY È GIA ORDINATO

        startTime = System.nanoTime();
        SortingAlgorithms.bubbleSort(arr_milione);
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("#CASO MIGLIORE#\nArray già ordinato: " + estimatedTime + "(ns)");


        //CASO PEGGIORE: ARRAY ORDINATO AL CONTRARIO

        for (int i = 0; i < 1000000; i++) {
            arr_milione_contrario[i] = arr_milione[999999 - i];
        }

        startTime = System.nanoTime();
        SortingAlgorithms.bubbleSort(arr_milione_contrario);
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("#CASO PEGGIORE#\nArray ordinato al contrario: " + estimatedTime + "(ns)");
    }
}
