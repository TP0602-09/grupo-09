package Control;

import Model.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mariagustina on 22/09/16.
 */
public class EngineController {

    private ViewController viewController;
    private Game game;
    private static final Map<String, Game> juegos;
    static
    {
        juegos = new HashMap<String, Game>();
        juegos.put("SUDOKU", new GameSudoku());
        juegos.put("KAKURO", new GameKakuro());
    }

    public EngineController(String gameType) {
        this.game = createGame(gameType);
        this.game.startGame();
        this.initializeViews();

    }

    private void initializeViews(){
        int numberOfRows = this.game.getBoard().getRows();
        this.viewController = new ViewController(numberOfRows);
        HashMap<Position, Cell> cellsArray = new HashMap<Integer, Cell>(game.getBoard().getCells());
        this.viewController.setCells(cellsArray);
        this.viewController.render();

    }

    public Game createGame(String gameType) {
        return juegos.get(gameType);
    }
}
