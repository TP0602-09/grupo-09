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
            int x = cell.getPosition().getX();
            int y = cell.getPosition().getY();
            int positionInMap = (x-1)*(this.game.getBoard().getRows()) + y;
            cellsViewArray.put(positionInMap,cell);
        }

        //HashMap<Position, Cell> cellsArray = game.getBoard().getCells();
        this.viewController.setCells(cellsViewArray);
        this.viewController.render();
    }

    public void imprimirCelda(Cell cell) {


        Position pos = cell.getPosition();
        System.out.print("Value: ");
        System.out.print(cell.getValue());
        System.out.print(" Posicion: [ ");
        System.out.print(pos.getX());
        System.out.print(" , ");
        System.out.print(pos.getY());
        System.out.println(" ]");

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
