package TicTacToe;

import java.util.Scanner;

public class GameLogic {
    private final Scanner scanner = new Scanner(System.in);

    public void stage3() {
        System.out.println("Enter cells:");
        String cells = scanner.nextLine();
        char[] arr = cells.toCharArray();
        printBoard(arr);

        String result = analyzeState(arr);
        System.out.println(result);
    }

    private void printBoard(char[] cells) {
        System.out.println("---------");
        for (int i = 0; i < 9; i += 3) {
            System.out.println("| " + cells[i] + " " + cells[i+1] + " " + cells[i+2] + " |");
        }
        System.out.println("---------");
    }

    private String analyzeState(char[] arr) {
        boolean xWins = checkWinner(arr, 'X');
        boolean oWins = checkWinner(arr, 'O');
        int countX = countSymbol(arr, 'X');
        int countO = countSymbol(arr, 'O');

        if (xWins && oWins || Math.abs(countX - countO) > 1) return "Impossible";
        if (xWins) return "X wins";
        if (oWins) return "O wins";
        if (new String(arr).contains("_")) return "Game not finished";
        return "Draw";
    }

    private boolean checkWinner(char[] arr, char symbol) {
        int[][] lines = {
                {0,1,2},{3,4,5},{6,7,8},
                {0,3,6},{1,4,7},{2,5,8},
                {0,4,8},{2,4,6}
        };
        for (int[] line : lines) {
            if (arr[line[0]] == symbol && arr[line[1]] == symbol && arr[line[2]] == symbol) return true;
        }
        return false;
    }

    private int countSymbol(char[] arr, char symbol) {
        int count = 0;
        for (char c : arr) {
            if (c == symbol) count++;
        }
        return count;
    }
}