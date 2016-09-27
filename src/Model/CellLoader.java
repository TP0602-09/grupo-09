package Model;

import java.util.HashMap;

/**
 * Created by Lucía on 27/9/2016.
 */
public class CellLoader {
    private static CellLoader ourInstance = new CellLoader();

    public static CellLoader getInstance() {
        return ourInstance;
    }

    private CellLoader() {}

    public HashMap<Position,Cell> loadCells() {
        return new HashMap<Position, Cell>();
    }
}
