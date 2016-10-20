package ar.fiuba.tdd.template.tp1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NumberInternalJoinsRule extends JoinRule {

    @Override
    public boolean isValidSector(Sector sector) {
        List<BoardElement> elements = sector.getBoardElements();
        int value = sector.getValue();
        int count = 0;

        Set<Join> joinsPossibles = makeAllJoinsPossibles(elements);

        for (Join join : joins) {
            if (joinsPossibles.contains(join)) {
                count += 1;
            }
        }

        return value >= count;
    }

    private Set<Join> makeAllJoinsPossibles(List<BoardElement> elements) {

        Set<Join> joinsPossibles = new HashSet<>();

        for (BoardElement firstElement : elements) {
            joinsPossibles.addAll(elements.stream().map(secondElement -> new Join(firstElement, secondElement)).collect(Collectors.toList()));
        }

        return joinsPossibles;
    }
}
