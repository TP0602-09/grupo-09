package ar.fiuba.tdd.template.tp1;

import java.util.ArrayList;

/**
 * Created by Lucía on 19/10/2016.
 */
public abstract class OperationOfNumbersEqXRule extends Rule {
    @Override
    public boolean validSectorSpecificRule(Sector sector) {
        ArrayList<Integer> values = this.extractCellValues(sector);
        Integer op = operation(values);
        if (isComplete(sector, values)) {
            return op == sector.getValue();
        } else {
            return op <= sector.getValue();
        }
    }

    public abstract Integer operation(ArrayList<Integer> values);

    private boolean isComplete(Sector sector, ArrayList<Integer> values) {
        return (values.size() == sector.getBoardElements().size());
    }
}
