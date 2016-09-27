package Model;

import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucía on 27/9/2016.
 */
public class Sector {
    private Position begin;
    private Position end;
    private List<Rule> rules;

    public void validateRules(Cell cell, Position pos) throws InvalidMoveException {
        for (Rule rule: rules) {
            rule.validate(this.toArrayOfCells());
        }
    }

    private ArrayList<Cell> toArrayOfCells() {
        //TODO armar la lista de celdas
        return new ArrayList<Cell>();
    }
}
