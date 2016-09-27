package Model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mariagustina on 22/09/16.
 */
public abstract class Game {

    private Board board;
    private CellLoader cellLoader;
    private SectorLoader sectorLoader;

    public  abstract void Game();
    public void startConfiguration(){
        getInstanceOfLoaders();
        HashMap<Position,Cell> cells = cellLoader.loadCells();
        ArrayList<Sector> sectors = sectorLoader.loadSectors();

        this.board = new Board(9,9,cells, sectors);
    }
    public abstract void startGame();

    private void getInstanceOfLoaders() {
        this.cellLoader = CellLoader.getInstance();
        this.sectorLoader = SectorLoader.getInstance();
    }

}
