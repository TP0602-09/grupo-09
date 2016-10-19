package ar.fiuba.tdd.template.tp1;

import java.util.ArrayList;

public abstract class OperationOfNumbersEqXRule extends Rule {
    @Override
    public boolean validSectorSpecificRule(Sector sector) {
        ArrayList<Integer> values = this.extractCellValues(sector);
        int op = operation(values);
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
