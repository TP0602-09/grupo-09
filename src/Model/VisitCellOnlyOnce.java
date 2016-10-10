package Model;

import java.util.List;

public class VisitCellOnlyOnce extends Rule {

    private static final int CELL_POS = 0;
    private static final int LEFT = 1;
    private static final int RIGHT = 2;
    private static final int UP = 3;
    private static final int DOWN = 4;

    private static VisitCellOnlyOnce ourInstance = null;

    public static VisitCellOnlyOnce getInstance() {
        if (ourInstance == null) {
            ourInstance = new VisitCellOnlyOnce();
        }
        return ourInstance;
    }

    private VisitCellOnlyOnce() {

    }

    @Override
    public boolean isValid(List<Cell> cells) {
        Cell cell = cells.get(CELL_POS);
        if (cell.getValue()[LEFT] == 1 && cell.getValue()[RIGHT] == 1) {
            return cell.getValue()[DOWN] == 0 && cell.getValue()[UP] == 0;
        }
        if (cell.getValue()[UP] == 1 && cell.getValue()[DOWN] == 1) {
            return cell.getValue()[LEFT] == 0 && cell.getValue()[RIGHT] == 0;
        }
        if (cell.getValue()[UP] == 1 && cell.getValue()[RIGHT] == 1) {
            return cell.getValue()[DOWN] == 0 && cell.getValue()[LEFT] == 0;
        }

        if (cell.getValue()[DOWN] == 1 && cell.getValue()[RIGHT] == 1) {
            return cell.getValue()[UP] == 0 && cell.getValue()[LEFT] == 0;
        }
        if (cell.getValue()[UP] == 1 && cell.getValue()[LEFT] == 1) {
            return cell.getValue()[DOWN] == 0 && cell.getValue()[RIGHT] == 0;
        }
        return !(cell.getValue()[DOWN] == 1 && cell.getValue()[LEFT] == 1) || cell.getValue()[UP] == 0 && cell.getValue()[RIGHT] == 0;
    }
}
