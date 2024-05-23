package TicTacToe;

class DetectWin {
    class WinData {
        public boolean detect;
        public boolean first;
    }
    // private String empty = " ";
    // Horizontal Win
    private WinData horizontalWin(String[][] board) {
        String empty = " ";
        String start;
        int same;
        WinData winData = new WinData();
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
                if (start == "X") {
                    winData.first = true;

                } else {
                    winData.first = false;
                }
                winData.detect = true;
                return winData;
            }
        }
        winData.detect = false;
        return winData;
    }

    // Vertical Win
    private WinData verticalWin(String[][] board) {
        String empty = " ";
        String start;
        WinData winData = new WinData();
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
            if (same == board.length){
                if (start == "X") {
                    winData.first = true;
                } else {
                    winData.first = false;
                }
                winData.detect = true;
                return winData;
            }

        }
        winData.detect = false;
        return winData;

    }

    // Diagonal Win
    private WinData diagonalWin(String[][] board) {
        String empty = " ";
        String start;
        int same;
        start = board[0][0];
        WinData winData = new WinData();
        if (!start.equals(empty)) {
            same = 0;
            for (int i = 0; i < board.length; i++) {
                if (!board[i][i].equals(start)) {
                    break;
                }
                same += 1;
            }
            if (same == board.length) {
                if (start.equals("X")) {
                    winData.first = true;
                } else {
                    winData.first = false;
                }
                winData.detect = true;
                return winData;
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
                if (start.equals("X")) {
                    winData.first = true;
                } else {
                    winData.first = false;
                }
                winData.detect = true;
                return winData;
            }
        }
        winData.detect = false;
        return winData;
    }

    // Detects if the board contains a win based on
    // horizontal/vertical/diagonal tic-tac-toe win condiditions
    public WinData winDetected(String[][] board) {
        WinData winData = new WinData();
        winData = horizontalWin(board);
        // Horizontal Win
        if (winData.detect) {
            return winData;
        }

        winData = verticalWin(board);
        // Vertical Win
        if (winData.detect) {
            return winData;
        }

        winData = diagonalWin(board);


        // Diagonal Win
        if (winData.detect) {
            return winData;
        }
        winData.detect = false;
        return winData;

    }

}