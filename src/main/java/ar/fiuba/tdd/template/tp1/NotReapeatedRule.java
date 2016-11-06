package ar.fiuba.tdd.template.tp1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Ignacio on 6/11/2016.
 */
public class NotReapeatedRule extends Rule {
    private static final int BLACK = 0;

    @Override
    public boolean isValidSector(Sector sector) {
        List<BoardElement> boardElements = sector.getBoardElements();

        for (BoardElement boardElement:boardElements) {
            DoubleValueCell doubleValueCell = (DoubleValueCell) boardElement;
            if (doubleValueCell.getDoubleValue() == BLACK) {
                boardElements.remove(boardElement);
            }
        }
        Set<BoardElement> boardElementSet = new HashSet<>(boardElements);
        return boardElements.size() == boardElementSet.size();

    }
}
