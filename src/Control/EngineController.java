package Control;

import Model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
        Iterator it = cellsArray.entrySet().iterator();
        HashMap<Integer,Cell> cellsViewArray = initializeViewBoard();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            Cell cell = (Cell)pair.getValue();
            System.out.println(cell);
            int x = cell.getPosition().getX();
            int y = cell.getPosition().getY();
            System.out.print(x);
            System.out.print(y);
            int positionInMap = x*(this.game.getBoard().getRows()-1) + y;
            System.out.println(positionInMap);
            cellsViewArray.put(positionInMap,cell);
        }

        //HashMap<Position, Cell> cellsArray = game.getBoard().getCells();
        this.viewController.setCells(cellsViewArray);
        this.viewController.render();
    }

    public HashMap<Integer,Cell> initializeViewBoard(){
        HashMap<Integer,Cell> cellsViewArray = new HashMap<Integer,Cell>();
        int counter = 1;
        for(int i = 1; i<=this.game.getBoard().getRows(); i++){
            for(int j = 1; j<=this.game.getBoard().getRows(); j++){
                Position pos = new Position(i,j);
                EditableCell ec = editableCell(pos);
                cellsViewArray.put(counter,ec);
                counter++;
                System.out.print(ec);
            }
        }
        return cellsViewArray;
    }

    public EditableCell editableCell(Position position){
        return new EditableCell(position);
    }

    public Game createGame(String gameType) {
        return juegos.get(gameType);
    }
}
