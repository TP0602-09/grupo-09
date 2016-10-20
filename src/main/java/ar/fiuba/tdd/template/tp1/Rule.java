package ar.fiuba.tdd.template.tp1;

import java.util.ArrayList;
import java.util.List;

public abstract class Rule {

    public boolean isValidBoard(Board board) {
        List<Sector> sectors = board.getSectors();
        for (Sector sector : sectors) {
            if (!isValidSector(sector) {
                return false;
            }
        }
        return true;
    }

    public abstract boolean isValidSector(Sector sector);

    public ArrayList<Integer> extractCellValues(Sector sector) {
        ArrayList<Integer> values = new ArrayList<>();
        for (BoardElement oneCell: sector.getBoardElements()) {
            Cell cell = (Cell) oneCell;
            if (cell.hasValue()) {
                values.add(cell.getValue());
            }
        }
        return values;
    }
}