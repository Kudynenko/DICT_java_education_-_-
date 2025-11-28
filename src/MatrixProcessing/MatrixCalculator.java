package MatrixProcessing;

import java.util.Scanner;

public class MatrixCalculator {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 2 -> {
                    double[][] A = readMatrix();
                    double k = scanner.nextDouble();
                    double[][] C = MatrixUtils.multiplyByConstant(A, k);
                    printMatrix(C);
                }
                case 0 -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("2. Multiply matrix by a constant");
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