package Model;

import java.util.List;

public class SumOfNumbersEqXRule extends Rule {
    private static SumOfNumbersEqXRule ourInstance = new SumOfNumbersEqXRule();

    public static SumOfNumbersEqXRule getInstance() {
        return ourInstance;
    }

    private SumOfNumbersEqXRule() {
    }

    private static final int RESULT_CELL_INDEX = 0;

    @Override
    public boolean isValid(List<Cell> cells) {
        DataCell resultCell = (DataCell) cells.get(RESULT_CELL_INDEX);
        Integer result = resultCell.getValue();
        cells.remove(RESULT_CELL_INDEX);
        Integer sum = 0;

        for (Cell cell : cells) {
            sum += cell.getValue();
        }

        return !(sum > result);
    }
}
