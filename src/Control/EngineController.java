package Control;

import Model.Game;
import Model.GameKakuro;
import Model.GameSudoku;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mariagustina on 22/09/16.
 */
public class EngineController {

    private static final Map<String, Game> juegos;
    static
    {
        juegos = new HashMap<String, Game>();
        juegos.put("SUDOKU", new GameSudoku());
        juegos.put("KAKURO", new GameKakuro());
    }

    public EngineController(String gameType) {
        Game game = createGame(gameType);
        game.startGame();

    }

    public Game createGame(String gameType) {
        return juegos.get(gameType);
    }
}
