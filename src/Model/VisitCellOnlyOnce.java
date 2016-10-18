package Model;

import java.util.ArrayList;
import java.util.List;

public class VisitCellOnlyOnce extends Rule {

    private static final int CELL_POS = 0;
    private static final int LEFT = 1;
    private static final int RIGHT = 2;
    private static final int UP = 3;
    private static final int DOWN = 4;


    @Override
    public boolean isValid(List<Cell> cells) {
        int[] value = cells.get(CELL_POS).getValue();
        return validateLeftRight(value) ||validateUpDown(value)||
                validateUpRight(value) || validateRightDown(value) ||
                validateLeftUp(value)|| validateDownLeft(value);
    }

    private boolean validateUpRight(int[] value) {
        return (value[UP] == 1 && value[RIGHT] == 1)&&
                (value[DOWN] == 0 && value[LEFT] == 0);
    }

    private boolean validateDownLeft(int[] value) {
        return !(value[DOWN] == 1 && value[LEFT] == 1) &&
                (value[UP] == 0 && value[RIGHT] == 0);
    }

    private boolean validateLeftUp(int[] value) {
        return  (value[UP] == 1 && value[LEFT] == 1)&&
                (value[DOWN] == 0 && value[RIGHT] == 0);
    }

    private boolean validateRightDown(int[] value) {
        return  (value[DOWN] == 1 && value[RIGHT] == 1) &&
                (value[UP] == 0 && value[LEFT] == 0);
    }

    private boolean validateUpDown(int[] value) {
        return (value[UP] == 1 && value[DOWN] == 1) &&
                (value[LEFT] == 0 && value[RIGHT] == 0);
    }

    private boolean validateLeftRight(int[] value) {
       return (value[LEFT] == 1 && value[RIGHT] == 1) &&
        (value[DOWN] == 0 && value[UP] == 0);
    }
}
