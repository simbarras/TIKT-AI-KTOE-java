package bot;

import Workers.Game;
import Workers.HumanPlayer;
import Workers.Player;

public class Bot extends HumanPlayer implements Player {
    private Game refGame;

    public Bot(int ref, String name, Game refGame) {
        super(ref, name);
        this.refGame = refGame;
    }

    @Override
    public int[] play() throws Exception {
        int[] coor = algoFirstCoor();
        return new int[] {coor[0], coor[1], super.ref};
    }

    private int[] algoFirstCoor() throws Exception {
        int[][] boardGame = refGame.getBoardGame();
        if (boardGame[1][1] == 0) return new int[]{1, 1};
        else {
            for (int i = 0; i < boardGame.length; i++) {
                for (int j = 0; j < boardGame[i].length; j++) {
                    if(boardGame[i][j]==0)return new int[] {j, i};
                }
            }
        }
        throw new Exception("No place to play");
    }

    @Override
    public int getRef() {
        return ref;
    }

    @Override
    public String getName() {
        return name;
    }
}
