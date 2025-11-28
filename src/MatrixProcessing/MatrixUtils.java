package MatrixProcessing;

public class MatrixUtils {
    public static double[][] multiply(double[][] A, double[][] B) {
        int n1 = A.length, m1 = A[0].length;
        int n2 = B.length, m2 = B[0].length;

        if (m1 != n2) return null;

        double[][] C = new double[n1][m2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m2; j++) {
                for (int k = 0; k < m1; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }
}
