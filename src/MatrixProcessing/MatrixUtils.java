package MatrixProcessing;

public class MatrixUtils {
    public static double[][] transpose(double[][] A, int type) {
        int n = A.length, m = A[0].length;
        double[][] result;

        switch (type) {
            case 1 -> {
                result = new double[m][n];
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < m; j++)
                        result[j][i] = A[i][j];
            }
            case 2 -> {
                result = new double[m][n];
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < m; j++)
                        result[m - 1 - j][n - 1 - i] = A[i][j];
            }
            case 3 -> {
                result = new double[n][m];
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < m; j++)
                        result[i][m - 1 - j] = A[i][j];
            }
            case 4 -> {
                result = new double[n][m];
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < m; j++)
                        result[n - 1 - i][j] = A[i][j];
            }
            default -> result = null;
        }
        return result;
    }
}
