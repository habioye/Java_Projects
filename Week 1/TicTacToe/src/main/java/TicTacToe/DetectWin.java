package TicTacToe;

class Detect_Win {
    // private String empty = " ";
    // Horizontal Win
    private static boolean horizontalWin(String[][] board) {
        String empty = " ";
        String start;
        int same;
        for (String[] board1 : board) {
            start = board1[0];
            if (start.equals(empty))
                continue;
            same = 0;
            for (int j = 0; j < board.length; j++) {
                if (!board1[j].equals(start)) {
                    break;
                }
                same += 1;
            }
            if (same == board.length) {
                return true;
            }
        }
        return false;
    }

    // Vertical Win
    private static boolean verticalWin(String[][] board) {
        String empty = " ";
        String start;
        int same;
        for (int j = 0; j < board.length; j++) {
            start = board[0][j];
            if (start.equals(empty))
                continue;
            same = 0;
            for (int i = 0; i < board.length; i++) {
                if (!board[i][j].equals(start)) {
                    break;

                }
                same += 1;
            }
            if (same == board.length)
                return true;

        }
        return false;
    }

    // Diagonal Win
    private static boolean diagonalWin(String[][] board) {
        String empty = " ";
        String start;
        int same;
        start = board[0][0];
        if (!start.equals(empty)) {
            same = 0;
            for (int i = 0; i < board.length; i++) {
                if (!board[i][i].equals(start)) {
                    break;
                }
                same += 1;
            }
            if (same == board.length) {
                return true;
            }
        }

        start = board[board.length - 1][0];
        if (!start.equals(empty)) {
            same = 0;
            for (int i = 0; i < board.length; i++) {
                if (!board[board.length - 1 - i][i].equals(start)) {
                    break;
                }
                same += 1;
            }

            if (same == board.length) {
                return true;
            }
        }
        return false;
    }

    // Detects if the board contains a win based on
    // horizontal/vertical/diagonal tic-tac-toe win condiditions
    public static boolean winDetected(String[][] board) {
        // Horizontal Win
        if (horizontalWin(board)) {
            return true;
        }

        // Vertical Win
        if (verticalWin(board)) {
            return true;
        }

        // Diagonal Win
        if (diagonalWin(board)) {
            return true;
        }

        return false;

    }

}