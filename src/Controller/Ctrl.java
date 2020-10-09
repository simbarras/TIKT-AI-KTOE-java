package Controller;

import Workers.Player;
import proglib.SimpleIO;
import Workers.Game;

public class Ctrl {
    private Game refGame;
    private Player[] players;

    public Ctrl(Game refGame, Player p1, Player p2) {
        this.refGame = refGame;
        players = new Player[2];
        players[0] = p2;
        players[1] = p1;
    }

    public void letsPlay() throws Exception {
        refGame.load();
        boolean winner = false;
        int tour = 1, winnerRef = 0;
        while (!winner && tour <= 9) {
            System.out.println("Tour " + tour);
            int[] val = players[tour % 2].play();
            if (!refGame.play(val[0], val[1], val[2])) {
                continue;
            }
            affiche();
            winner = refGame.checkWinner();
            if (winner) {
                winnerRef = tour % 2;
            }
            tour++;
        }
        if (winner) {
            System.out.println("The winner is player" + players[winnerRef].getRef() + ": " + players[winnerRef].getName());
        } else {
            System.out.println("There is no winner");
        }
    }


    private void affiche() {
        int[][] boardGame = refGame.getBoardGame();
        for (int i = 0; i < boardGame.length; i++) {
            System.out.println("-------");
            for (int j = 0; j < boardGame[i].length; j++) {
                System.out.print("|" + boardGame[i][j]);
            }
            System.out.println("|");

        }
    }
}
