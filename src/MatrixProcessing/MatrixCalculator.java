package MatrixProcessing;

import java.util.Scanner;

public class MatrixCalculator {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 5 -> {
                    double[][] A = readMatrix();
                    if (A.length != A[0].length) {
                        System.out.println("The operation cannot be performed.");
                    } else {
                        double det = MatrixUtils.determinant(A);
                        System.out.println(det);
                    }
                }
                case 0 -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("5. Calculate a determinant");
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
}