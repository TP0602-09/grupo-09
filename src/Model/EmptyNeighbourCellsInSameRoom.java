package Model;

import java.util.List;

public class EmptyNeighbourCellsInSameRoom extends Rule {
    private static final int CELL_POS = 0;
    private static final int ROOM_ID = 5;


    @Override
    public boolean isValid(List<Cell> cells) {
        int roomId = cells.get(CELL_POS).getValue()[ROOM_ID];
        cells.remove(cells.get(CELL_POS));
        for (Cell cell : cells) {
            if (cell.getValue()[ROOM_ID] != roomId) {
                return false;
            }
        }
        return true;
    }
}
