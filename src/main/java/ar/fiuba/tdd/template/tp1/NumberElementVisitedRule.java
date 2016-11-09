package ar.fiuba.tdd.template.tp1;

import java.util.ArrayList;
import java.util.List;

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
                    break;
                }
            }
        }
        return value >= count;
    }

/*    private List<Join> makeJoins(List<BoardElement> elements) {
        BoardElement first;
        BoardElement second;
        List<Join> joins = new ArrayList<>();
        for(int i = 0; i < elements.size(); i ++) {
            first = elements.get(i);
            for (int j = i + 1; j < elements.size(); j ++) {
                second = elements.get(j);
                joins.add(new Join(first, second));
            }
        }
        return joins;
    }*/
}
