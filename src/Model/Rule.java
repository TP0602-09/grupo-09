package model;

import java.util.List;

public abstract class Rule {

    protected Utils utils = Utils.getInstance();

    public abstract boolean isValid(List<Cell> cells);
}
