package TicTacToe;

import java.util.ArrayList;
import java.util.List;

public interface AI {
    public class Data {
        public int[] arr;
        public int value;
    }
//    public int[] nextMove(String[][] board);
    public Data nextMove(String[][] board, boolean first);
    default List<int[]> getChoices(String[][] board) {
        List<int[]> choices = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].equals(" ")) {
                    int[] arr = new int[2];
                    arr[0] = i;
                    arr[1] = j;
                    choices.add(arr);
                }
            }
        }
        return choices;
    }
}