package TicTacToe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AIEasy implements AI {
    public int[] nextMove(String[][] board) {
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
        Random rand = new Random();
        int choose = rand.nextInt(choices.size());
        return choices.get(choose);
    }

}
