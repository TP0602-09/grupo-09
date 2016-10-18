package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class CellLoader {


    public HashMap<Position,Cell> loadCells(List<HashMap<String, Object>> cellsArray) {
        HashMap<Position,Cell> cells = new HashMap<>();

        for (HashMap<String, Object> cellMap : cellsArray) {
            Cell cell = formatCell(cellMap);
            Position pos = cell.getPosition();
            cells.put(pos, cell);
        }

        return cells;
    }

    private Cell formatCell(HashMap<String, Object> cellMap) {
        @SuppressWarnings("unchecked")
        Position pos = formatPosition((ArrayList<String>) cellMap.get("pos"));
        String type = (String) cellMap.get("type");
        @SuppressWarnings("unchecked")
        Cell cell = createCell(pos, type, cellMap);
        return cell;
    }

    private Position formatPosition(List<String> posArray) {
        return new Position(Integer.parseInt(posArray.get(1)), Integer.parseInt(posArray.get(0)));
    }

    private Cell createCell(Position pos, String type, HashMap<String, Object> cellMap) {
        Cell cell;
        if ("dat".equals(type)) {
            cell = new DataCell(pos);
            cell.setValue(Integer.parseInt(cellMap.get("value").toString()));
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

    HashMap<Position,Cell> fillWithEditableCell(HashMap<Position,Cell> cells, int rows, int cols) {
        HashMap<Position,Cell> allCells = getMissingPositions(cells.keySet(), rows, cols);
        allCells.putAll(cells);
        return allCells;
    }

    private HashMap<Position,Cell> getMissingPositions(Set<Position> positions, int rows, int cols) {
        HashMap<Position,Cell> newCells = new HashMap<>();

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                Position pos = new Position(i, j);
                if (!positionFound(positions, pos)) {
                    Cell cell = new EditableCell(pos);
                    cell.setValue(0);
                    newCells.put(pos, cell);
                }
            }
        }

        return newCells;
    }

    private boolean positionFound(Set<Position> positions, Position pos) {
        for (Position aPos : positions) {
            if (aPos.equals(pos)) return true;
        }
        return false;
    }
}
