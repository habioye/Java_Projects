package TicTacToe;

import java.util.Arrays;
import java.util.Scanner;

public class BasicImplementation {
    // Implements a Tic-Tac-Toe Game based on the current state
    public static void main(String[] args) {
        String[][] board = new String[3][3];
        for (String[] row : board) {
            Arrays.fill(row, " ");
        }
        boolean first = true;
        int length = board.length;

        System.out.println("Tic-Tac-Toe");
        System.out.println("------------------------------");
        DisplayBoard.DisplayBoard(board);

        int positions = length * length;
        Scanner scanner = new Scanner(System.in);
        int x, y;
        // Main game loop switches between the players and updates and displays
        // the board with correct positions.
        while (true) {
            System.out.println("Select a position (x, y)");
            if (first) {
                System.out.println("It is currently player1's turn");
            } else {

                System.out.println("It is currently player2's turn");
            }

            x = scanner.nextInt();
            y = scanner.nextInt();
            if (x < 0 || x >= board.length || y < 0 || y >= board.length) {
                throw new IllegalArgumentException("Invalid position");
            }
            if (board[x][y] != " ") {
                System.out.println("You selected the a filled space!");
                continue;
            }
            if (first) {
                board[x][y] = "X";
            } else {
                board[x][y] = "O";
            }
            System.out.println("Current Board");
            DisplayBoard.DisplayBoard(board);
            DetectWin detectWin = new DetectWin();
            if (detectWin.winDetected(board).detect) {
                if (first) {
                    System.out.println("Player 1 Won!");
                } else {
                    System.out.println("Player 2 Won!");
                }
                return;
            }
            positions -= 1;
            if (positions == 0) {
                System.out.println("The game is a Draw!");
                return;
            }
            first = !first;

        }

    }
}
