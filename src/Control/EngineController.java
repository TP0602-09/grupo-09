package Control;

import Model.Game;
import Model.GameKakuro;
import Model.GameSudoku;

/**
 * Created by mariagustina on 22/09/16.
 */
public class EngineController {

    public EngineController(String gameType) {
        Game game = createGame(gameType);
        game.startGame();

    }

    public Game createGame(String gameType) {

        if(gameType == null) {
            return null;
        }

        if(gameType.equalsIgnoreCase("SUDOKU")) {
            return new GameSudoku();

        } else if(gameType.equalsIgnoreCase("KAKURO")) {
            return new GameKakuro();
        }

        return null;
    }
}
