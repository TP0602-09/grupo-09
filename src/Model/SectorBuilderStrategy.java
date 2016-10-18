package Model;

import java.util.HashMap;
import java.util.List;


public abstract class SectorBuilderStrategy {
    public abstract List<List<Cell>> getSectorsToValidate(
            Cell cell, HashMap<Position, Cell> cells);

}
