import java.util.Arrays;
import java.util.Random;

public class MatrixMultiplicationNoThread {

    public static void main(String[] args) {
        int[][] matrixA = generateMatrix(1000, 1000);
        int[][] matrixB = generateMatrix(1000, 1000);

        int[][] result = new int[matrixA.length][matrixB[0].length];

        System.out.println("Iniciando...");
        System.out.println("Sem Threads");

        long startTime = System.currentTimeMillis();

        multiplyMatrices(matrixA, matrixB, result);

        long endTime = System.currentTimeMillis();

        long executionTime = endTime - startTime;

        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("Tempo de execução: " + executionTime + " milisegundos");
    }

    private static void multiplyMatrices(int[][] matrixA, int[][] matrixB, int[][] result) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
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
