package ar.fiuba.tdd.template.tp1;

/**
 * Created by Lucía on 17/10/2016.
 */
public class Main {

    public static void main() {
        GameReader gameReader = GameReader.getInstance();
        try {
            GameData gameData = gameReader.readGameConfiguration();
            Board board = new Board(gameData.getRows(), gameData.getColumns(), gameData.getSectors());
            Game game = new Game(board, gameData.getInputType(), gameData.getUnionType());
            game.play();
            System.out.print("Thanks for playing");
        } catch (GameNotFoundException e) {
            System.out.print("The game hat not been found");
        }
    }
}
