package MatrixProcessing;

public class MatrixUtils {
    public static double determinant(double[][] A) {
        int n = A.length;
        if (n != A[0].length) return Double.NaN;

        if (n == 1) return A[0][0];
        if (n == 2) return A[0][0] * A[1][1] - A[0][1] * A[1][0];

        double det = 0;
        for (int col = 0; col < n; col++) {
            det += Math.pow(-1, col) * A[0][col] * determinant(minor(A, 0, col));
        }
        return det;
    }

    // Допоміжний метод для мінору
    private static double[][] minor(double[][] A, int row, int col) {
        int n = A.length;
        double[][] result = new double[n - 1][n - 1];
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (i == row) continue;
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (j == col) continue;
                result[r][c++] = A[i][j];
            }
            r++;
        }
        return result;
    }
}
