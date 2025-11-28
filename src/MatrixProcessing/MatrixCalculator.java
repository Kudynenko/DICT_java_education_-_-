package MatrixProcessing;

import java.util.Scanner;

public class MatrixCalculator {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 4 -> { // транспонування
                    System.out.println("1. Main diagonal");
                    System.out.println("2. Side diagonal");
                    System.out.println("3. Vertical line");
                    System.out.println("4. Horizontal line");
                    int type = scanner.nextInt();
                    double[][] A = readMatrix();
                    double[][] T = MatrixUtils.transpose(A, type);
                    if (T == null) System.out.println("Invalid choice!");
                    else printMatrix(T);
                }
                case 0 -> { return; } // вихід
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("4. Transpose matrix");
        System.out.println("0. Exit");
        System.out.print("Your choice: ");
    }

    private static double[][] readMatrix() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        double[][] matrix = new double[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                matrix[i][j] = scanner.nextDouble();
        return matrix;
    }

    private static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}