import java.util.Arrays;
import java.util.Random;

public class MatrixMultiplication {

    public static void main(String[] args) {
        int[][] matrixA = generateMatrix(1000, 1000);

        int[][] matrixB = generateMatrix(1000, 1000);

        int numThreads = 4;

        int[][] result = new int[matrixA.length][matrixB[0].length];

        Thread[] threads = new Thread[numThreads];

        int rowsPerThread = matrixA.length / numThreads;
        int remainingRows = matrixA.length % numThreads;

        int startIndex = 0;

        System.out.println("Iniciando...");
        System.out.println("Threads: " + numThreads);
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < numThreads; i++) {
            int endIndex = startIndex + rowsPerThread + (i < remainingRows ? 1 : 0);
            threads[i] = new Thread(new MatrixMultiplier(matrixA, matrixB, result, startIndex, endIndex));
            threads[i].start();
            startIndex = endIndex;
        }

        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();

        long executionTime = endTime - startTime;

        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("Tempo de execução: " + executionTime + " milisegundos");
    }

    private static int[][] generateMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }

        return matrix;
    }

}
