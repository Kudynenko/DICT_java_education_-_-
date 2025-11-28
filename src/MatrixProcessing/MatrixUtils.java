package MatrixProcessing;

public class MatrixUtils {
    public static double[][] multiplyByConstant(double[][] A, double k) {
        int n = A.length, m = A[0].length;
        double[][] C = new double[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                C[i][j] = A[i][j] * k;
        return C;
    }
}
