package MatrixProcessing;

public class MatrixUtils {
    private final int rows;
    private final int cols;
    private final double[][] data;

    public MatrixUtils(double[][] data) {
        if (data == null || data.length == 0 || data[0].length == 0)
            throw new IllegalArgumentException("Invalid data");
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (data[i].length != cols) throw new IllegalArgumentException("Jagged array");
            this.data[i] = data[i].clone();
        }
    }

    public MatrixUtils add(MatrixUtils other) {
        if (other == null || rows != other.rows || cols != other.cols) return null;
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[i][j] = this.data[i][j] + other.data[i][j];
        return new MatrixUtils(result);
    }

    public MatrixUtils multiplyByConstant(double k) {
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[i][j] = this.data[i][j] * k;
        return new MatrixUtils(result);
    }

    public MatrixUtils multiply(MatrixUtils other) {
        if (other == null || this.cols != other.rows) return null;
        double[][] result = new double[this.rows][other.cols];
        for (int i = 0; i < this.rows; i++)
            for (int j = 0; j < other.cols; j++)
                for (int k = 0; k < this.cols; k++)
                    result[i][j] += this.data[i][k] * other.data[k][j];
        return new MatrixUtils(result);
    }

    public MatrixUtils transpose(int type) {
        double[][] result;
        switch (type) {
            case 1 -> {
                result = new double[cols][rows];
                for (int i = 0; i < rows; i++)
                    for (int j = 0; j < cols; j++)
                        result[j][i] = data[i][j];
            }
            case 2 -> {
                result = new double[cols][rows];
                for (int i = 0; i < rows; i++)
                    for (int j = 0; j < cols; j++)
                        result[cols - 1 - j][rows - 1 - i] = data[i][j];
            }
            case 3 -> {
                result = new double[rows][cols];
                for (int i = 0; i < rows; i++)
                    for (int j = 0; j < cols; j++)
                        result[i][cols - 1 - j] = data[i][j];
            }
            case 4 -> {
                result = new double[rows][cols];
                for (int i = 0; i < rows; i++)
                    for (int j = 0; j < cols; j++)
                        result[rows - 1 - i][j] = data[i][j];
            }
            default -> { return null; }
        }
        return new MatrixUtils(result);
    }

    public double determinant() {
        if (rows != cols) return Double.NaN;
        if (rows == 1) return data[0][0];
        if (rows == 2) return data[0][0] * data[1][1] - data[0][1] * data[1][0];
        double det = 0;
        for (int col = 0; col < cols; col++)
            det += Math.pow(-1, col) * data[0][col] * minor(0, col).determinant();
        return det;
    }

    private MatrixUtils minor(int row, int col) {
        double[][] result = new double[rows - 1][cols - 1];
        int r = 0;
        for (int i = 0; i < rows; i++) {
            if (i == row) continue;
            int c = 0;
            for (int j = 0; j < cols; j++) {
                if (j == col) continue;
                result[r][c++] = data[i][j];
            }
            r++;
        }
        return new MatrixUtils(result);
    }

    public MatrixUtils inverse() {
        if (rows != cols) return null;
        double det = determinant();
        if (det == 0) return null;
        double[][] adj = new double[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                double sign = ((i + j) % 2 == 0) ? 1 : -1;
                adj[j][i] = sign * minor(i, j).determinant();
            }
        double[][] inv = new double[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                inv[i][j] = adj[i][j] / det;
        return new MatrixUtils(inv);
    }

    public void print() {
        for (double[] row : data) {
            for (double val : row) {
                System.out.printf("%.2f ", val);
            }
            System.out.println();
        }
    }
}
