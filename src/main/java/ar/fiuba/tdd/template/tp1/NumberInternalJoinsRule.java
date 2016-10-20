package ar.fiuba.tdd.template.tp1;

import java.util.ArrayList;
import java.util.List;

public class NumberInternalJoinsRule extends JoinRule {

    @Override
    public boolean isValidSector(Sector sector) {
        List<BoardElement> elements = sector.getBoardElements();
        int value = sector.getValue();
        int count = 0;

        List<Join> joinsPossibles = makeAllJoinsPossibles(elements);

        for (Join join : joins) {
            if (joinsPossibles.contains(join)) {
                count += 1;
            }
        }

        return value >= count;
    }

    private List<Join> makeAllJoinsPossibles(List<BoardElement> elements) {

        List<Join> joinsPossibles = new ArrayList<Join>();

        for (BoardElement firstElement : elements) {
            for (BoardElement secondElement : elements) {
                Join join = new Join(firstElement, secondElement);
                if (!joinsPossibles.contains(join)) {
                    joinsPossibles.add(join);
                }
            }
        }

        return joinsPossibles;
    }
}
