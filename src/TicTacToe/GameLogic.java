package TicTacToe;

import java.util.Scanner;

public class GameLogic {
    private final Scanner scanner = new Scanner(System.in);

    public void stage2() {
        System.out.println("Enter cells:");
        String cells = scanner.nextLine();
        printBoard(cells.toCharArray());
    }

    private void printBoard(char[] cells) {
        System.out.println("---------");
        for (int i = 0; i < 9; i += 3) {
            System.out.println("| " + cells[i] + " " + cells[i+1] + " " + cells[i+2] + " |");
        }
        System.out.println("---------");
    }
}
