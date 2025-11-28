package MatrixProcessing;

public class MatrixUtils {
    public static double[][] add(double[][] A, double[][] B) {
        int n = A.length, m = A[0].length;
        if (n != B.length || m != B[0].length) return null;

        double[][] C = new double[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                C[i][j] = A[i][j] + B[i][j];
        return C;
    }
}
