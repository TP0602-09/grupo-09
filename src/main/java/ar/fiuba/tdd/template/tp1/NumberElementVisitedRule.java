package ar.fiuba.tdd.template.tp1;

import java.util.List;

/**
 * Created by Agata on 19/10/2016.
 */
public class NumberElementVisitedRule extends JoinRule {

    @Override
    public boolean isValidSector(Sector sector) {
        List<BoardElement> elements = sector.getBoardElements();
        int value = sector.getValue();
        int count = 0;

        for (BoardElement element : elements) {
            for (Join join : joins) {
                if (join.hasBoardElement(element)) {
                    count += 1;
                }
            }
        }
        return value >= count;
    }
}
