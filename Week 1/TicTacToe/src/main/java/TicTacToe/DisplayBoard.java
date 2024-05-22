package TicTacToe;

public class DisplayBoard {
    // Display Board contents in tic-tac-toe format
    public static void DisplayBoard(String[][] board) {
        int length = board.length;
        for (int i = 0; i < length; i++) {
            System.out.print(" ");
            for (int j = 0; j < length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.print("\n");
            // for (int j = 0; j < length; j++) {
            System.out.println("----".repeat(board.length));
            // }
        }

    }
}