package model;

import java.util.List;

public abstract class Rule {
    public abstract boolean isValid(List<Cell> cells);
}
