package ar.fiuba.tdd.template.tp1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AllDifferentRule extends Rule {

    @Override
    public boolean isValidSector(Sector sector) {
        ArrayList<Integer> values = this.extractCellValues(sector);
        if (values.isEmpty()) {
            return true;
        }
        Set<Integer> set = new HashSet<>(values);
        return !(set.size() < values.size());
    }
}
