
import java.util.Arrays;
import java.util.Scanner;

public class Basic_Implementation {
    private static void DisplayBoard(String[][] board) {
        int length = board.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(board[i][j] + " |");
            }
            System.out.print("\n");
            // for (int j = 0; j < length; j++) {
            System.out.println("___".repeat(board.length));
            // }
        }

    }

    private static boolean DetectWin(String[][] board) {
        String empty = " ";
        String start;
        int same;
        // Horizontal Win
        for (int i = 0; i < board.length; i++) {
            start = board[i][0];
            if (start == empty)
                continue;

            same = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != start)
                    break;

                same += 1;
            }
            if (same == board.length) {
                return true;
            }

        }

        // Vertical Win
        for (int j = 0; j < 10; j++) {
            start = board[0][j];
            if (start == empty)
                continue;
            same = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] != start) {
                    break;

                }
                same += 1;
            }
            if (same == board.length)
                return true;

        }

        // Diagonal Win
        start = board[0][0];
        if (start != empty) {
            same = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i][i] != start) {
                    break;
                }
                same += 1;
            }
            if (same == board.length) {
                return true;
            }
        }

        start = board[board.length - 1][0];
        same = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[board.length - 1 - i][i] != start) {
                break;
            }
            same += 1;
        }

        if (same == board.length) {
            return true;
        }

        return false;

    }

    public static void main(String[] args) {
        String[][] board = new String[3][3];
        for (String[] row : board) {
            Arrays.fill(row, " ");
        }
        boolean first = true;
        int length = board.length;

        System.out.println("Tic-Tac-Toe");
        System.out.println("------------------------------");
        DisplayBoard(board);

        int positions = length * length;
        Scanner scanner = new Scanner(System.in);
        int x, y;

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
            System.out.println("Current Board");
            DisplayBoard(board);
            if (DetectWin(board)) {
                if (first) {
                    System.out.println("Player 1 Won!");
                } else {
                    System.out.println("Player 2 Won!");
                }
                return;
            }
            positions = -1;
            if (positions == 0) {
                System.out.println("The game is a Draw!");
                return;
            }

        }

    }
}
