package Model;

import java.util.List;


public class LinesInRoomsNotExcedded extends Rule {

    private static LinesInRoomsNotExcedded ourInstance = null;
    private static final int ROOM_CELL = 0;
    private static final int ROOM_SIZE = 0;
    private static final int LEFT = 1;
    private static final int RIGHT = 2;
    private static final int UP = 3;
    private static final int DOWN = 4;

    public static LinesInRoomsNotExcedded getInstance() {
        if (ourInstance == null) {
            ourInstance = new LinesInRoomsNotExcedded();
        }
        return ourInstance;
    }


    private LinesInRoomsNotExcedded() {

    }

    @Override
    public boolean isValid(List<Cell> cells) {
        int value = cells.get(ROOM_CELL).getValue()[ROOM_SIZE];
        cells.remove(cells.get(ROOM_CELL));
        int count = 0;
        for (Cell cell : cells) {
            count += ((cell.getValue()[LEFT] + cell.getValue()[RIGHT] +
                    cell.getValue()[UP] + cell.getValue()[DOWN]) % 2);
        }
        return count > value;
    }
}