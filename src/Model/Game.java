package Model;

import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mariagustina on 22/09/16.
 */
public class Game {

    private Board board;
    private CellLoader cellLoader;
    private SectorLoader sectorLoader;
    private JsonParser jsonParser;
    private List<Rule> rules;

    public Game(ArrayList<Rule> rules){
        this.jsonParser = JsonParser.instance();
        this.cellLoader = CellLoader.getInstance();
        this.sectorLoader = SectorLoader.getInstance();
        this.rules = rules;
    }

    public void startConfiguration(){
        HashMap<Position,Cell> cells = cellLoader.loadCells(jsonParser.getCells());
        int rows = jsonParser.getRows();
        int cols = jsonParser.getColumns();
        HashMap<Position,Cell> allCells = cellLoader.fillWithEditableCell(cells, rows, cols);
        ArrayList<Sector> sectors = sectorLoader.loadSectors();



        this.board = new Board(rows, cols, cells, sectors);
    }
    public void startGame(){
        System.out.println("Welcome");
        startConfiguration();
    }

    public Board getBoard() {
        return this.board;
    }
}
