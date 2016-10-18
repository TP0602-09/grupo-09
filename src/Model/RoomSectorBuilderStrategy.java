package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class RoomSectorBuilderStrategy extends SectorBuilderStrategy {
    private static final int ROOM_ID = 5;

    @Override
    public List<List<Cell>> getSectorsToValidate(Cell cell,
                                            HashMap<Position, Cell> cells) {
        int roomId = cell.getValue()[ROOM_ID];
        List<Cell> cellsInRoom = new ArrayList<>();
        List<List<Cell>> rooms = new ArrayList<>();
        cellsInRoom.addAll(cells.values().stream().filter(aCell ->
                aCell.getValue()[ROOM_ID] == roomId).
                collect(Collectors.toList()));
        rooms.add(cellsInRoom);
        return rooms;
    }

}
