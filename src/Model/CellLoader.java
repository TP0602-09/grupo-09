package model;

import java.util.HashMap;
import java.util.List;

public class CellLoader {
    private static CellLoader ourInstance = new CellLoader();

    public static CellLoader getInstance() {
        return ourInstance;
    }

    private CellLoader() {}

    public HashMap<Position,Cell> loadCells(List<Cell> cellsArray) {
        HashMap<Position,Cell> cells = new HashMap<Position, Cell>();

        for (Cell aCell : cellsArray) {
            Position pos = aCell.getPosition();
            cells.put(pos, aCell);
        }

        return cells;
    }
}
