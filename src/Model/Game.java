package Model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mariagustina on 22/09/16.
 */
public class Game {

    private Board board;
    private CellLoader cellLoader;
    private SectorLoader sectorLoader;
    private JsonParser jsonParser;

    public void Game(){
        this.jsonParser = JsonParser.instance();
        this.cellLoader = CellLoader.getInstance();
        this.sectorLoader = SectorLoader.getInstance();
    }

    public void startConfiguration(){
        HashMap<Position,Cell> cells = cellLoader.loadCells(jsonParser.getCells());
        ArrayList<Sector> sectors = sectorLoader.loadSectors();

        this.board = new Board(9,9,cells, sectors);
    }
    public void startGame(){
        System.out.println("Welcome");
        startConfiguration();
    }

    public Board getBoard() {
        return this.board;
    }
}
