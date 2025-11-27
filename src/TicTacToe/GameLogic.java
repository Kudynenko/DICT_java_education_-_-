package TicTacToe;

import java.util.Scanner;

public class GameLogic {
    private final Scanner scanner = new Scanner(System.in);

    public void stage4() {
        System.out.println("Enter cells:");
        char[] arr = scanner.nextLine().toCharArray();
        printBoard(arr);

        while (true) {
            System.out.println("Enter the coordinates:");
            String[] input = scanner.nextLine().split(" ");
            if (input.length != 2 || !input[0].matches("\\d+") || !input[1].matches("\\d+")) {
                System.out.println("You should enter numbers!");
                continue;
            }

            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            if (x < 1 || x > 3 || y < 1 || y > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            int index = (x - 1) * 3 + (y - 1);
            if (arr[index] != '_') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            arr[index] = 'X';
            break;
        }

        printBoard(arr);
    }

    private void printBoard(char[] cells) {
        System.out.println("---------");
        for (int i = 0; i < 9; i += 3) {
            System.out.println("| " + cells[i] + " " + cells[i+1] + " " + cells[i+2] + " |");
        }
        System.out.println("---------");
    }
}