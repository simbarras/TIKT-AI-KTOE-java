import Controller.Ctrl;
import Workers.Game;
import Workers.Bot;
import Workers.HumanPlayer;

public class app {
    public static void main(String[] args) {
        Game game = new Game();

        //Human player
        HumanPlayer p1 = new HumanPlayer(1, "Roman");

        //First bot: bot selecting the first free case
        Bot p2 = new Bot(2, "first-bot", game, 0);

        //Random bot: bot selecting randomly a case
        Bot p3 = new Bot(1, "random-bot", game, 1);

        //Hot bot: bot selecting a case with a list of hotcase
        Bot p4 = new Bot(2, "hot-bot", game, 2);

        //Multi bot: bot using randomly the different selecting option
        Bot p5 = new Bot(2, "multi-bot", game, 3);

        Ctrl ctrl = new Ctrl(game, p1, p5);
        try {
            ctrl.letsPlay();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
