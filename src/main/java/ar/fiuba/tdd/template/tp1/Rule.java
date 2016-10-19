package ar.fiuba.tdd.template.tp1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucía on 16/10/2016.
 */
public abstract class Rule {

    public boolean areSectorsValid(Board board) {
        List<Sector> sectors = board.getSectors();
        for (Sector aSector : sectors) {
            if (!validSectorSpecificRule(aSector)) {
                return false;
            }
        }
        return true;
    }

    public abstract boolean validSectorSpecificRule(Sector sector);

    public ArrayList<Integer> extractCellValues(Sector sector) {
        ArrayList<Integer> values = new ArrayList<Integer>();
        for (BoardElement aCell: sector.getBoardElements()) {
            Cell cell = (Cell) aCell;
            if (cell.hasValue()) {
                values.add(cell.getValue());
            }
        }
        return values;
    }
}


