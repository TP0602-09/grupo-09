package Control;

import Model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mariagustina on 22/09/16.
 */
public class EngineController {

    private ViewController viewController;
    private Game game;
    private static final ArrayList<Rule> rulesSudoku;
    static {
        rulesSudoku = new ArrayList<Rule>();
        rulesSudoku.add(AllDifferentRule.getInstance());
    }
    private static final ArrayList<Rule> rulesKakuro;
    static {
        rulesKakuro = new ArrayList<Rule>();
        rulesKakuro.add(AllDifferentRule.getInstance());
        rulesKakuro.add(SumOfNumbersEqXRule.getInstance());
    }
    private static final Map<String, Game> juegos;
    static {
        juegos = new HashMap<String, Game>();
        juegos.put("SUDOKU", new GameSudoku(rulesSudoku));
        juegos.put("KAKURO", new GameKakuro(rulesKakuro));
    }

    public EngineController(String gameType) {
        this.game = createGame(gameType);
        this.game.startGame();
        this.initializeViews();

    }

    private void initializeViews(){
        int numberOfRows = this.game.getBoard().getRows();
        this.viewController = new ViewController(numberOfRows);
        HashMap<Position, Cell> cellsArray = game.getBoard().getCells();
        this.viewController.setCells(cellsArray);
        this.viewController.render();

    }

    public Game createGame(String gameType) {
        return juegos.get(gameType);
    }
}
