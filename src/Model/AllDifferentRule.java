package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Lucía on 28/9/2016.
 */
public class AllDifferentRule extends Rule {
    private static AllDifferentRule ourInstance = new AllDifferentRule();

    public static AllDifferentRule getInstance() {
        return ourInstance;
    }

    private AllDifferentRule() {
    }

    @Override
    public void validate(ArrayList<Cell> cells) throws InvalidMoveException {
        List<Integer> values = extractValues(cells);

        Set<Integer> set = new HashSet<Integer>(values);

        if (set.size() < values.size()) { throw new InvalidMoveException(); }
    }

    private List<Integer> extractValues(ArrayList<Cell> cells) {
        List<Integer> values = new ArrayList<Integer>();
        for (Cell cell: cells) {
            if (cell.hasValue()) {
                values.add(cell.getValue());
            }
        }
        return values;
    }
}
