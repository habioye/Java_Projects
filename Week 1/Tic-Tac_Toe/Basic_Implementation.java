
public class Basic_Implementation {
    private void DisplayBoard(String[][] board) {
        int length = board.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(board[i][j] + " |");
            }
            for (int j = 0; j < length; j++) {
                System.out.print("__");
            }
        }

    }

    private boolean DetectWin(String[][] board) {
        // Horizontal Win
        for (int i = 0; i < board.length; i++) {
            String start = board[i][0];
            int same = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != start) {
                    break;
                }
                same += 1;
            }
            if (same == board.length) {
                return true;
            }

        }

        // Vertical Win
        for (int i = 0; i < 10; i++) {
            String start = board[i][0];
            int same = 0;

        }

    }

    }

    public static void main(String[] args) {
        String[][] board = new String[3][3];
        boolean first = true;
        int length = board.length;

        while (true) {

        }

    }
}
