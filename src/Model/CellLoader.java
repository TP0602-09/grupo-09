package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by Lucía on 27/9/2016.
 */
public class CellLoader {
    private static CellLoader ourInstance = new CellLoader();

    public static CellLoader getInstance() {
        return ourInstance;
    }

    private CellLoader() {}

    public HashMap<Position,Cell> loadCells(ArrayList<HashMap<String, Object>> cellsArray) {
        HashMap<Position,Cell> cells = new HashMap<Position, Cell>();

        for (HashMap<String, Object> cellMap : cellsArray) {
            Cell cell = formatCell(cellMap);
            Position pos = cell.getPosition();
            cells.put(pos, cell);
        }

        return cells;
    }

    private Cell formatCell(HashMap<String, Object> cellMap) {
        Position pos = formatPosition((ArrayList<String>) cellMap.get("pos"));
        String type = (String) cellMap.get("type");
        Cell cell = createCell(pos, type, cellMap);
        return cell;
    }

    private Position formatPosition(ArrayList<String> posArray) {
        return new Position(Integer.parseInt(posArray.get(1)), Integer.parseInt(posArray.get(0)));
    }

    private Cell createCell(Position pos, String type, HashMap<String, Object> cellMap) {
        Cell cell;
        if ("dat".equals(type)) {
            cell = new DataCell(pos);
            cell.setValue(Integer.parseInt((String) cellMap.get("value")));
            return cell;
        } else if ("Double".equals(type)) {
            cell = new DoubleCell(pos);
            cell.setValue(Integer.parseInt((String) cellMap.get("value_r")),
                    Integer.parseInt((String) cellMap.get("value_c")));
            return cell;
        } else {
            return null;
        }
    }

    public HashMap<Position,Cell> fillWithEditableCell(HashMap<Position,Cell> cells, int rows, int cols) {
        HashMap<Position,Cell> allCells = getMissingPositions(cells.keySet(), rows, cols);
        allCells.putAll(cells);
        return allCells;
    }

    private HashMap<Position,Cell> getMissingPositions(Set<Position> positions, int rows, int cols) {
        HashMap<Position,Cell> newcells = new HashMap<Position,Cell>();

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                Position pos = new Position(i, j);
                if (!positionFound(positions, pos)) {
                    Cell cell = new EditableCell(pos);
                    cell.setValue(0);
                    newcells.put(pos, cell);
                }
            }
        }

        return newcells;
    }

    private boolean positionFound(Set<Position> positions, Position pos) {
        for (Position aPos : positions) {
            if (aPos.equals(pos)) return true;
        }
        return false;
    }
}
