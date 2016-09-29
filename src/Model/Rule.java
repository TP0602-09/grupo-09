package Model;

import java.util.List;

/**
 * Created by Lucía on 24/9/2016.
 */
public abstract class Rule {
    public abstract boolean isValid(List<Cell> cells);
}
