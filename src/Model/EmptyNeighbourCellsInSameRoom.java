package Model;

import java.util.Iterator;
import java.util.List;

public class EmptyNeighbourCellsInSameRoom extends Rule {
    private static final int CELL_POS = 0;
    private static final int ROOM_ID = 5;
    private static EmptyNeighbourCellsInSameRoom ourInstance = null;

    public static EmptyNeighbourCellsInSameRoom getInstance() {
        if (ourInstance == null) {
            ourInstance = new EmptyNeighbourCellsInSameRoom();
        }
        return ourInstance;
    }

    private EmptyNeighbourCellsInSameRoom() {
    }


    @Override
    public boolean isValid(List<Cell> cells) {
        int roomId = cells.get(CELL_POS).getValue()[ROOM_ID];

        for (Cell cell : cells) {
            if (cell.getValue()[ROOM_ID] != roomId) {
                return false;
            }
        }
        return true;
    }
}
