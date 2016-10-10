package Model;

import java.util.List;

public class BorderCountRule extends Rule {
    private static BorderCountRule ourInstance = null;

    public static BorderCountRule getInstance() {
        if (ourInstance == null) {
            ourInstance = new BorderCountRule();
        }
        return ourInstance;
    }

    private BorderCountRule() {

    }

    @Override
    public boolean isValid(List<Cell> cells) {
        for (Cell cell : cells) {
            if (!isValid(cell)) return false;
        }
        return true;
    }

    private boolean isValid(Cell cell) {
        int borderCount = cell.getValue()[0];
        return borderCount == -1 || borderCount == cell.getValue()[1] + cell.getValue()[2] + cell.getValue()[3] + cell.getValue()[4];
    }
}
