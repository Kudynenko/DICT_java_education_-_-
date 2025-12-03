package MatrixProcessing;

import java.util.Scanner;

public class MatrixCalculator {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = readInt();

            switch (choice) {
                case 1 -> {
                    MatrixUtils A = readMatrix();
                    MatrixUtils B = readMatrix();
                    MatrixUtils C = A.add(B);
                    if (C == null) System.out.println("The operation cannot be performed.");
                    else C.print();
                }
                case 2 -> {
                    MatrixUtils A = readMatrix();
                    double k = readDouble();
                    A.multiplyByConstant(k).print();
                }
                case 3 -> {
                    MatrixUtils A = readMatrix();
                    MatrixUtils B = readMatrix();
                    MatrixUtils C = A.multiply(B);
                    if (C == null) System.out.println("The operation cannot be performed.");
                    else C.print();
                }
                case 4 -> {
                    System.out.println("1. Main diagonal");
                    System.out.println("2. Side diagonal");
                    System.out.println("3. Vertical line");
                    System.out.println("4. Horizontal line");
                    int type = readInt();
                    MatrixUtils A = readMatrix();
                    MatrixUtils T = A.transpose(type);
                    if (T == null) System.out.println("Invalid choice!");
                    else T.print();
                }
                case 5 -> {
                    MatrixUtils A = readMatrix();
                    double det = A.determinant();
                    if (Double.isNaN(det)) System.out.println("The operation cannot be performed.");
                    else System.out.println(det);
                }
                case 6 -> {
                    MatrixUtils A = readMatrix();
                    MatrixUtils inv = A.inverse();
                    if (inv == null) System.out.println("This matrix doesn't have an inverse.");
                    else inv.print();
                }
                case 0 -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("1. Add matrices");
        System.out.println("2. Multiply matrix by a constant");
        System.out.println("3. Multiply matrices");
        System.out.println("4. Transpose matrix");
        System.out.println("5. Calculate a determinant");
        System.out.println("6. Inverse matrix");
        System.out.println("0. Exit");
        System.out.print("Your choice: ");
    }

    private static MatrixUtils readMatrix() {
        int n = readInt();
        int m = readInt();
        double[][] data = new double[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                data[i][j] = readDouble();
        return new MatrixUtils(data);
    }

    private static int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter an integer: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static double readDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Please enter a number: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}
