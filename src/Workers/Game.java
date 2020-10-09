package Workers;

public class Game {
    private int[][] boardGame;
    private boolean isAWinner;

    public void load() {
        this.boardGame = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        this.isAWinner = false;
    }

    public boolean play(int x, int y, int player) {
        boolean result = false;
        if (this.boardGame[y][x] == 0) {
            this.boardGame[y][x] = player;
            result = true;
        }
        return result;
    }

    public boolean checkWinner() {
        int oneLine = 0, twoLine = 0;
        int[] oneCol = new int[3], twoCol = new int[3];
        check:
        for (int y = 0; y < boardGame.length; y++) {
            for (int x = 0; x < boardGame[y].length; x++) {
                int val = boardGame[y][x];
                if (val == 1) {
                    oneLine++;
                    if (++oneCol[x] == 3) {
                        isAWinner = true;
                        break check;
                    }
                } else if (val == 2) {
                    twoLine++;
                    if (++twoCol[x] == 3) {
                        isAWinner = true;
                        break check;
                    }
                }
            }
            if (oneLine == 3) {
                isAWinner = true;
                break check;
            } else if (twoLine == 3) {
                isAWinner = true;
                break check;
            }
            oneLine = 0;
            twoLine = 0;
        }
        if (!isAWinner) {
            if (boardGame[1][1] != 0 &&
                    ((boardGame[0][0] == boardGame[1][1] && boardGame[1][1] == boardGame[2][2]) ||
                            (boardGame[0][2] == boardGame[1][1] && boardGame[1][1] == boardGame[2][0])))
                isAWinner = true;
        }
        return this.isAWinner;
    }

    public int[][] getBoardGame() {
        return boardGame;
    }
}
