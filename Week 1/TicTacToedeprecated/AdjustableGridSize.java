import java.util.Arrays;
import java.util.Scanner;

public class Adjustable_Grid_Size {

    // Implements a Tic-Tac-Toe Game based on the current state
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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

        Display_Board.DisplayBoard(board);

        int positions = length * length;
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
            DisplayBoard(board);
            if (Detect_Win.winDetected(board)) {
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
