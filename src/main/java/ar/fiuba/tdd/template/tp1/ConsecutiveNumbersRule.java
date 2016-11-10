package ar.fiuba.tdd.template.tp1;

import java.util.ArrayList;

/**
 * Created by ljulia on 10/11/2016.
 */
public class ConsecutiveNumbersRule extends Rule {
    @Override
    public boolean isValidSector(Sector sector) {
        int maxValue = sector.getBoardElements().size();
        for (BoardElement elem : sector.getBoardElements()) {
            Cell cell = (Cell) elem;
            if (cell.getValue() > maxValue) {
                return false;
            }
        }
        return true;
    }
}
