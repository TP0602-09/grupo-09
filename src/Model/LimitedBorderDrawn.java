package Model;

import java.util.List;


public class LimitedBorderDrawn extends Rule {

    @Override
    public boolean isValid(List<Cell> cells) {
        for (Cell cell : cells) {
            if (!isValid(cell)) return false;
        }
        return true;
    }

    private boolean isValid(Cell cell) {
        int borderCount = cell.getValue()[0];
        return borderCount == -1 ||
                borderCount >= cell.getValue()[1] +
                        cell.getValue()[2] +
                        cell.getValue()[3] +
                        cell.getValue()[4];
    }
}
