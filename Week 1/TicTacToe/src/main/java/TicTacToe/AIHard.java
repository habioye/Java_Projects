package TicTacToe;

import javax.xml.stream.FactoryConfigurationError;
import java.util.List;

public class AIHard implements AI {

    public boolean drawdetection(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length;j++) {
                if (board[i][j] == " ") return false;
            }
        }
        return true;
    }
    public Data nextMove(String[][] board, boolean first) {
        DetectWin detectWin = new DetectWin();
        DetectWin.WinData winData = detectWin.winDetected(board);
        Data drawData = new Data();

        Data data = new Data();
        if (winData.detect) {
            if (winData.first) {
                data.value = 10;
            } else {
                data.value = -10;
            }
            return data;
        }
        if (drawdetection(board)) {
            data.value = 0;
            return data;
        }
        AI ai = new AIHard();
        List<int[]> choices = ai.getChoices(board);
        String search;
        int maxVal = -100;
        int minVal = 100;
        if (first) {
            search = "X";
            data.value = -100;

        } else {
            search = "O";
            data.value = 100;
        }

        for (int[] coor: choices) {

            board[coor[0]][coor[1]] = search;
            if (drawdetection(board)) {
                if (first) {
                    if (data.value < 0) {
                        data.value = 0;
                        data.arr = coor;


                    }
                } else {
                    if (data.value > 0) {
                        data.value = 0;
                        data.arr = coor;
                    }
                }

                return data;
            }
            Data searchdata = nextMove(board,!first);
            if (first) {
                if (data.value < searchdata.value) {
                    data.value = searchdata.value;
                    data.arr = searchdata.arr;

                }
            } else {
                if (data.value > searchdata.value) {
                    data.value = searchdata.value;
                    data.arr = searchdata.arr;
                }

            }
            board[coor[0]][coor[0]] = " ";
        }




        return data;


    }
}