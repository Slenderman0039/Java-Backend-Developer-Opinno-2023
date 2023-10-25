package esercizio2;

import java.util.LinkedList;
import java.util.Queue;

public class MatriceAdiacenzaLabirinto {

    public static char[][] fromMatrixtoCharMatrix(Entity[][] matrix){
        char[][] matrixchar = new char[matrix.length][matrix.length];
        for(int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix.length;j++){
                matrixchar[i][j] = matrix[i][j].toString().charAt(0);
            }
        }
        return matrixchar;
    }


    public static int[][] creaMatriceAdiacenza(char[][] labirinto) {
        int n = labirinto.length;
        int m = labirinto[0].length;
        int size = n * m;
        int[][] adjMatrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                adjMatrix[i][j] = Integer.MAX_VALUE;
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Sopra, Sotto, Sinistra, Destra

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int source = i * m + j;

                if (labirinto[i][j] == 'W') {
                    // Se Ã¨ un muro, non ci sono percorsi possibili
                    continue;
                }

                for (int[] dir : directions) {
                    int newRow = i + dir[0];
                    int newCol = j + dir[1];

                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                        int dest = newRow * m + newCol;

                        if (labirinto[newRow][newCol] != 'W') {
                            adjMatrix[source][dest] = 1;
                        }
                    }
                }
            }
        }

        return adjMatrix;
    }

    public static boolean esistePercorso(int[][] adjMatrix, int start, int end) {
        int n = adjMatrix.length;
        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            if (currentNode == end) {
                return true; // Trovato un percorso alla destinazione
            }

            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (adjMatrix[currentNode][neighbor] == 1 && !visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        return false; // Nessun percorso trovato alla destinazione
    }
}