package TicTacToe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AIMedium implements AI {
    private static boolean near(String[][] board,int[] coor, String search) {
        if (coor[0] >0 && board[coor[0]-1][coor[1]].equals(search)) {
            return true;
        }
        if (coor[1]> 0 && board[coor[0]][coor[1]-1].equals(search)) {
            return true;
        }

        if (coor[0] < board.length-1 && board[coor[0]+1][coor[1]].equals(search)) {
            return true;
        }
        return false;


    }
    public Data nextMove(String[][] board, boolean first) {
        DetectWin detectWin = new DetectWin();
        Data data = new Data();
        String search;
        if (first) {
            search = "X";
        } else {
            search = "O";
        }
        List<int[]> choices = (new AIMedium()).getChoices(board);
        for (int[] coor: choices) {
            if (near(board,coor,search)){
                data.arr = coor;
                return data;
            }
        }
        Random rand = new Random();
        data.arr = choices.get(rand.nextInt(choices.size()));
        return data;

    }

}
