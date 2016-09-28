package Model;

import java.util.ArrayList;

/**
 * Created by Lucía on 28/9/2016.
 */
public class SumOfNumbersEqXRule extends Rule {
    private static SumOfNumbersEqXRule ourInstance = new SumOfNumbersEqXRule();

    public static SumOfNumbersEqXRule getInstance() {
        return ourInstance;
    }

    private SumOfNumbersEqXRule() {
    }

    private static final int RESULT_CELL_INDEX = 0;

    @Override
    public void validate(ArrayList<Cell> cells) throws InvalidMoveException {
        DataCell resultCell = (DataCell) cells.get(RESULT_CELL_INDEX);
        Integer result = resultCell.getValue();
        cells.remove(RESULT_CELL_INDEX);
        Integer sum = 0;

        for (Cell cell: cells) {
            sum += cell.getValue();
        }

        if (sum > result) throw new InvalidMoveException();
    }
}
