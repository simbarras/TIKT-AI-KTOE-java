import Controller.Ctrl;
import Workers.Game;
import Workers.HumanPlayer;
import bot.Bot;

public class app {
    public static void main(String[] args) {
        Game game = new Game();
        HumanPlayer p1 = new HumanPlayer(1, "Simon");
        Bot p2 = new Bot(2, "bot", game);
        Ctrl ctrl = new Ctrl(game, p1, p2);
        try {
            ctrl.letsPlay();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
