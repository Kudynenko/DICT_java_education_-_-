package TicTacToe;

import java.util.Scanner;

public class GameLogic {
    private final char[][] board = new char[3][3];
    private final Scanner scanner = new Scanner(System.in);
    private char currentPlayer = 'X';

    public GameLogic() {
        for (char[] row : board) {
            java.util.Arrays.fill(row, '_');
        }
    }

    public void play() {
        printBoard();
        while (true) {
            makeMove();
            printBoard();
            if (hasWinner()) {
                System.out.println(currentPlayer + " wins");
                break;
            }
            if (isDraw()) {
                System.out.println("Draw");
                break;
            }
            currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
        }
    }

    private void printBoard() {
        System.out.println("---------");
        for (char[] row : board) {
            System.out.print("| ");
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    private void makeMove() {
        while (true) {
            System.out.println("Enter the coordinates:");
            String[] input = scanner.nextLine().trim().split(" ");
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

            if (board[x - 1][y - 1] != '_') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            board[x - 1][y - 1] = currentPlayer;
            break;
        }
    }

    private boolean hasWinner() {
        return checkLines(currentPlayer);
    }

    private boolean isDraw() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == '_') return false;
            }
        }
        return true;
    }

    private boolean checkLines(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (allEqual(symbol, board[i][0], board[i][1], board[i][2])) return true;
            if (allEqual(symbol, board[0][i], board[1][i], board[2][i])) return true;
        }
        return allEqual(symbol, board[0][0], board[1][1], board[2][2]) ||
                allEqual(symbol, board[0][2], board[1][1], board[2][0]);
    }

    private boolean allEqual(char symbol, char a, char b, char c) {
        return a == symbol && b == symbol && c == symbol;
    }
}