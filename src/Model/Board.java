package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Lucía on 24/9/2016.
 */
public class Board {

    private int rows;
    private int columns;
    private HashMap<Position,Cell> cells;
    private ArrayList<Sector> sectors;

    public Board(int rows, int cols, HashMap<Position,Cell> cells, ArrayList<Sector> sectors) {
        this.rows = rows;
        this.columns = cols;
        this.cells = cells;
        this.sectors = sectors;
    }

    public int getRows() {
        return this.rows;
    }

    public HashMap<Position,Cell> getCells() { return this.cells; }

}
