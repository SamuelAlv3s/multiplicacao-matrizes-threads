class MatrixMultiplier implements Runnable {

    private int[][] matrixA;
    private int[][] matrixB;
    private int[][] result;
    private int startIndex;
    private int endIndex;

    public MatrixMultiplier(int[][] matrixA, int[][] matrixB, int[][] result, int startIndex, int endIndex) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.result = result;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            for (int j = 0; j < matrixB[0].length; j++) {
                for (int k = 0; k < matrixA[0].length; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
    }
}
