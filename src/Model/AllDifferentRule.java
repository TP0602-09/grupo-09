package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllDifferentRule extends Rule {
    private static AllDifferentRule ourInstance = new AllDifferentRule();

    public static AllDifferentRule getInstance() {
        return ourInstance;
    }

    private AllDifferentRule() {
    }

    @Override
    public boolean isValid(List<Cell> cells) {
        List<Integer> values = extractValues(cells);

        Set<Integer> set = new HashSet<>(values);

        return !(set.size() < values.size());
    }

    private List<Integer> extractValues(List<Cell> cells) {
        List<Integer> values = new ArrayList<>();
        for (Cell cell : cells) {
            if (cell.hasValue()) {
                values.add(cell.getValue()[0]);
            }
        }
        return values;
    }
}
