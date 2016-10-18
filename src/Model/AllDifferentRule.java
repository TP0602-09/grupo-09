package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllDifferentRule extends Rule {

    @Override
    public boolean isValid(List<Cell> cells) {
        List<Integer> values = extractValues(cells);

        Set<Integer> set = new HashSet<>(values);

        return !(set.size() < values.size());
    }

    private List<Integer> extractValues(List<Cell> cells) {
        List<Integer> values = new ArrayList<>();
        for (Cell cell : cells) {
            if (cell.getValue()[0] != 0) {
                values.add(cell.getValue()[0]);
            }
        }
        return values;
    }
}
