package Model;

import java.util.HashMap;
import java.util.List;


public class NullSectorBuilderStrategy extends SectorBuilderStrategy {
    @Override
    public List<List<Cell>> getSectorsToValidate(Cell cell, HashMap<Position, Cell> cells) {
        return null;
    }
}
