package Model;

import java.util.ArrayList;

/**
 * Created by Lucía on 24/9/2016.
 */
public abstract class Rule {
    public abstract boolean validateSection(ArrayList<Cell> cells);
}
