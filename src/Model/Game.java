package Model;

import java.util.HashMap;
import java.util.List;

public class Game {

    private Board board;
    protected CellLoader cellLoader;
    private JsonParser jsonParser;
    private List<Rule> rules;

    public Game(List<Rule> rules) {
        this.jsonParser = JsonParser.instance();
        this.cellLoader = CellLoader.getInstance();
        this.rules = rules;
    }

    public void addValidCell(Cell cell){
        this.board.addCell(cell);
        if (this.hasWon()){
            System.out.println("FELICIDADES USTED HA GANADO EL JUEGO!!!");
        }
    }

    private boolean hasWon(){
        HashMap<Position, Cell> cells = this.board.getCells();
        for (Position pos : cells.keySet()) {
            Cell cell = cells.get(pos);
            if (cell.getValue() == 0){
                return false;
            }
        }
        return true;
    }

    public void startConfiguration() {

        HashMap<Position, Cell> cells = cellLoader.loadCells(jsonParser.getCells());

        int rows = jsonParser.getRows();
        int cols = jsonParser.getColumns();
        HashMap<Position, Cell> allCells = cellLoader.fillWithEditableCell(cells, rows, cols);

        this.board = new Board(rows, cols, allCells);
    }

    public void startGame() {
        System.out.println("Welcome");
        startConfiguration();
    }

    public Board getBoard() {
        return this.board;
    }

    public boolean isValid(Cell cell) {
        List<List<Cell>> sectors = this.board.getSectorsToValidate(cell);

        for (List<Cell> sector : sectors) {
            for (Rule rule : this.rules) {
                if (!rule.isValid(sector))
                    return false;
            }
        }
        return true;
    }


}
