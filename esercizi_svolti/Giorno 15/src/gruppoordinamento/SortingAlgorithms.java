package gruppoordinamento;

import java.util.Random;

public class SortingAlgorithms {

    public static void insertionSort(int arr[]){

            int n = arr.length;

            for (int i = 1; i < n; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
                arr[j + 1] = key;
            }
    }

    public static void bubbleSort(int arr[]){

        int n = arr.length;

        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
    }

    public static void generateRandomArray(int arr[], int n){

        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(1000);
        }

    }
}