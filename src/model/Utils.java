package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucía on 4/10/2016.
 */
public class Utils {
    private static Utils ourInstance = new Utils();

    public static Utils getInstance() {
        return ourInstance;
    }

    private Utils() {
    }

    public List<Integer> extractValues(List<Cell> cells) {
        List<Integer> values = new ArrayList<Integer>();
        for (Cell cell : cells) {
            if (cell.hasValue()) {
                values.add(cell.getValue());
            }
        }
        return values;
    }
}
