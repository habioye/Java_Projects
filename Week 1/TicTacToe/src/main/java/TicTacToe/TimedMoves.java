package TicTacToe;

import java.util.Arrays;
import java.util.Scanner;
// import javax.print.DocFlavor;

public class TimedMoves {
    // private final BufferReader getInput = new BufferedReader(new
    // InputStreamReader(System.in));
    // private final ExecutorService executors =
    // Executors.newVirtualThreadPerTaskExecutor();

    // void waitForInput() {
    // try {
    // while (!getInput.ready()) {
    // Thread.sleep(16);
    // input = getInput.readLine();
    // executors.shutdownNow();
    // }
    // } catch (Exception e) {
    // throw new RuntimeException(e);
    // }
    // }

    // void timerCountdown() {
    // IntStream.range(1, 10).mapToObj(i -> i).toList().reverse().forEach(i -> {
    // try {
    // Thread.sleep(1000);
    // System.out.printf("Time Left: %d",i);
    // } catch(Exception e) {
    // throw new RuntimeException(e);
    // };
    // })
    // }

    // private InputTimer (int timorutDuration) throws InterruptedException {
    // input = "invalid";
    // Executors.submit(waitForInput());
    // Executors.submit(waitForInput());

    // if (input.equal)

    // }

    // Display Board contents in tic-tac-toe format
    // private static void TicTacToe.DisplayBoard(String[][] board) {
    // int length = board.length;
    // for (int i = 0; i < length; i++) {
    // System.out.print(" ");
    // for (int j = 0; j < length; j++) {
    // System.out.print(board[i][j] + " | ");
    // }
    // System.out.print("\n");
    // // for (int j = 0; j < length; j++) {
    // System.out.println("----".repeat(board.length));
    // // }
    // }

    // }

    // // Detects if the board contains a win based on
    // // horizontal/vertical/diagonal tic-tac-toe win condiditions
    // private static boolean DetectWin(String[][] board) {
    // String empty = " ";
    // String start;
    // int same;
    // // Horizontal Win
    // for (int i = 0; i < board.length; i++) {
    // start = board[i][0];
    // if (start == empty)
    // continue;

    // same = 0;
    // for (int j = 0; j < board.length; j++) {
    // if (board[i][j] != start)
    // break;

    // same += 1;
    // }
    // if (same == board.length) {
    // return true;
    // }

    // }

    // // Vertical Win
    // for (int j = 0; j < board.length; j++) {
    // start = board[0][j];
    // if (start == empty)
    // continue;
    // same = 0;
    // for (int i = 0; i < board.length; i++) {
    // if (board[i][j] != start) {
    // break;

    // }
    // same += 1;
    // }
    // if (same == board.length)
    // return true;

    // }

    // // Diagonal Win
    // start = board[0][0];
    // if (start != empty) {
    // same = 0;
    // for (int i = 0; i < board.length; i++) {
    // if (board[i][i] != start) {
    // break;
    // }
    // same += 1;
    // }
    // if (same == board.length) {
    // return true;
    // }
    // }

    // start = board[board.length - 1][0];
    // if (start != empty) {
    // same = 0;
    // for (int i = 0; i < board.length; i++) {
    // if (board[board.length - 1 - i][i] != start) {
    // break;
    // }
    // same += 1;
    // }

    // if (same == board.length) {
    // return true;
    // }
    // }

    // return false;

    // }

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
                System.out.println("before input");
                try {
                    input = inputtimer.getInput(timerduration);
                } catch (Exception e) {
                    System.out.println(e);
                }
                System.out.println("After input");
                // ran out of time
                if (input.equals("invalid")) {
                    System.out.println("You ran out of time");

                    if (first) {
                        System.out.println("Player 2 Wins!");
                    } else {
                        System.out.println("Player 1 Wins!");
                    }
                    return;
                }
            } catch (Exception e) {

                if (first) {
                    System.out.println("Player 2 Wins!!!!!!!");
                } else {
                    System.out.println("Player 1 Wins!!!!!!!");
                }
                return;
            }
//            input.strip();
            String[] values = input.split(" ");
            if (values.length != 2) {
                System.out.println(values.toString());
                System.out.println("Wrong amount of inputs");
                continue;
            }
            try {
                x = Integer.parseInt(values[0]);
                y = Integer.parseInt(values[1]);

            } catch (Exception e) {
                System.out.println("Invalid position given");
                continue;
            }


            if (x < 0 || x >= board.length || y < 0 || y >= board.length) {
                throw new IllegalArgumentException("Invalid position");
            }
            if (!" ".equals(board[x][y])) {
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
