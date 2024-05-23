package TicTacToe;

import java.util.Arrays;
import java.util.Scanner;
// import javax.print.DocFlavor;

public class TimedMoves {
    private static void technicalwin(boolean first) {
        if (first) {
            System.out.println("Player 2 Wins!");
        } else {
            System.out.println("Player 1 Wins!");
        }
    }

    // Implements a Tic-Tac-Toe Game based on the current state
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        InputTimer inputtimer;

        int timerduration = 10000;
        System.out.println("Tic-Tac-Toe");
        System.out.println("------------------------------");
        System.out.println("Please Enter the Grid Size");
        int size = scanner.nextInt();

        String[][] board = new String[size][size];
        for (String[] row : board) {
            Arrays.fill(row, " ");
        }
        boolean first = true;
        int length = board.length;

        DisplayBoard.DisplayBoard(board);

        int positions = length * length;
        int x, y;
        String input = "invalid";
        // Main game loop switches between the players and updates and displays
        // the board with correct positions.
        while (true) {
            inputtimer = new InputTimer();

            System.out.println("Select a position (x, y)");
            if (first) {
                System.out.println("It is currently player1's turn");
            } else {
                System.out.println("It is currently player2's turn");
            }
            try {
//                System.out.println("before input");
//                try {
                    input = inputtimer.getInput(timerduration);
//                } catch (Exception e) {
//                    System.out.println(e);
//                }
//                System.out.println("After input");
                // ran out of time
                if (input.equals("invalid")) {
                    System.out.println("You ran out of time");
                    technicalwin(first);
                    return;
                }
            } catch (Exception e) {
                technicalwin(first);
                return;
            }
//            input.strip();
            String[] values = input.split(" ");
            if (values.length != 2) {
//                System.out.println(values.toString());
                System.out.println("Wrong amount of inputs");
                technicalwin(first);
                return;
            }
            try {
                x = Integer.parseInt(values[0]);
                y = Integer.parseInt(values[1]);

            } catch (Exception e) {
                System.out.println("Invalid position given");
                technicalwin(first);
                continue;
            }


            if (x < 0 || x >= board.length || y < 0 || y >= board.length) {
                throw new IllegalArgumentException("Invalid position");
            }
            if (!" ".equals(board[x][y])) {
                System.out.println("You selected the a filled space!");
                technicalwin(first);
                return;
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
                technicalwin(!first);
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
