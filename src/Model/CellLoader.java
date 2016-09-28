package Model;

import java.util.ArrayList;
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
}
