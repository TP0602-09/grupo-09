package Model;

import sun.dc.pr.PRError;

import java.util.List;

public class BorderCountRule extends Rule {
    private static final int BORDER_COUNT = -1;
    private static final int BORDER_COUNT_INDEX = 0;
    private static final int LEFT = 1;
    private static final int RIGHT = 2;
    private static final int UP = 3;
    private static final int DOWN = 4;

    @Override
    public boolean isValid(List<Cell> cells) {
        for (Cell cell : cells) {
            if (!isValid(cell)) return false;
        }
        return true;
    }

    private boolean isValid(Cell cell) {
        int borderCount = cell.getValue()[BORDER_COUNT_INDEX];
        return borderCount == BORDER_COUNT ||
                borderCount == cell.getValue()[LEFT] +
                cell.getValue()[RIGHT] +
                cell.getValue()[UP] +
                cell.getValue()[DOWN];
    }
}
