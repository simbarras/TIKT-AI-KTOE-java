package Workers;

import Workers.Game;
import Workers.HumanPlayer;
import Workers.Player;

public class Bot extends HumanPlayer {
    private Game refGame;
    private int aiType;
    private int[][] boardGame;

    public Bot(int ref, String name, Game refGame, int aiType) {
        super(ref, name);
        this.refGame = refGame;
        this.aiType = aiType;
    }

    @Override
    public int[] play() throws Exception {
        this.boardGame = refGame.getBoardGame();
        int[] coor = {0, 0, 0};
        switch (aiType) {
            case 0:
                coor = algoFirstCoor();
                break;
            case 1:
                coor = algoRandomCoor();
                break;
            case 2:
                coor = algoHotCoor();
                break;
            case 3:
                int i = (int) (Math.random() * 3);
                switch (i) {
                    case 0:
                        coor = algoFirstCoor();
                        break;
                    case 1:
                        coor = algoRandomCoor();
                        break;
                    case 2:
                        coor = algoHotCoor();
                        break;
                }
                break;
            default:
                throw new Exception("No an AI type");
        }
        return new int[]{coor[0], coor[1], super.ref};
    }

    private int[] algoFirstCoor() throws Exception {
        for (int i = 0; i < boardGame.length; i++) {
            for (int j = 0; j < boardGame[i].length; j++) {
                if (boardGame[i][j] == 0) return new int[]{j, i};
            }
        }
        throw new Exception("No place to play");
    }

    private int[] algoRandomCoor() throws Exception {
        while (true) {
            int x = (int) (Math.random() * 3);
            int y = (int) (Math.random() * 3);
            if (boardGame[y][x] == 0) return new int[]{x, y};
        }
    }

    private int[] algoHotCoor() throws Exception {
        //TODO
        if (boardGame[1][1] == 0) return new int[]{1, 1};
        if (boardGame[0][0] == 0) return new int[]{0, 0};
        if (boardGame[2][2] == 0) return new int[]{2, 2};
        if (boardGame[0][2] == 0) return new int[]{2, 0};
        if (boardGame[2][0] == 0) return new int[]{0, 2};
        if (boardGame[0][1] == 0) return new int[]{1, 0};
        if (boardGame[0][1] == 0) return new int[]{1, 0};
        if (boardGame[2][1] == 0) return new int[]{1, 2};
        if (boardGame[1][0] == 0) return new int[]{0, 1};
        if (boardGame[1][2] == 0) return new int[]{2, 1};
        return null;
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
