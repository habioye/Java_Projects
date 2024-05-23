package TicTacToe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AIEasy implements AI {
    public Data nextMove(String[][] board, boolean first) {
        AI ai = new AIEasy();
        List<int[]> choices = ai.getChoices(board);
        Random rand = new Random();
        int choose = rand.nextInt(choices.size());
        Data data = new Data();
        data.arr = choices.get(choose);
        return data;
    }

}
