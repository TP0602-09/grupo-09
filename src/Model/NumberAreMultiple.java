package Model;

import org.omg.CORBA.*;

import java.lang.Object;
import java.util.List;

public class NumberAreMultiple extends Rule {

    @Override
    public boolean isValid(List<Cell> cells) {
        int value = cells.get(0).getValue()[0];
        int count = cells.get(0).getValue()[1];
        cells.remove(cells.get(0));
        if (cells.size() == value - 1) {
            return isMultiplicationValid(cells, value);
        }
        return numberIsValidMultiple(cells, value);
    }


    private boolean numberIsValidMultiple(List<Cell> cells, int value) {
        for (Cell cell : cells) {
            if (cell.getValue()[0] % value != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isMultiplicationValid(List<Cell> cells, int value) {
        int x = 1;
        for (Cell cell : cells) {
            x *= cell.getValue()[0];
        }
        return x == value;
    }
}
