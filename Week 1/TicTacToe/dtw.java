class DetectWin_deprecated {
    private String empty = " ";

    // Horizontal Win
    private static boolean horizontalWin(String[][] board) {
        // String empty = " ";
        String start;
        int same;
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
        return false;
    }

    // Vertical Win
    private static boolean verticalWin(String[][] board) {
        for (int j = 0; j < board.length; j++) {
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
        return false;
    }

    // Diagonal Win
    private static boolean diagonalWin(String[][] board) {
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
        if (start != empty) {
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
        }
    }

    // Detects if the board contains a win based on
    // horizontal/vertical/diagonal tic-tac-toe win condiditions
    private static boolean winDetected(String[][] board) {
        String empty = " ";
        String start;
        int same;
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