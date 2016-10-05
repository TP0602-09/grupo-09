package model;

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
        List<Integer> values = utils.extractValues(cells);

        Set<Integer> set = new HashSet<Integer>(values);

        return !(set.size() < values.size());
    }
}
