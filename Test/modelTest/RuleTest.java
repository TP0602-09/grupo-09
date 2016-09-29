package modelTest;

import Model.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

/**
 * Created by Lucía on 29/9/2016.
 */
public class RuleTest {

    private ArrayList<Cell> rowCells;
    private ArrayList<Cell> colCells;
    private Rule allDifferentRule;


    @Before
    public void setUp() {
        rowCells = new ArrayList<Cell>();
        colCells = new ArrayList<Cell>();

        for (int i = 1; i < 10; i ++) {
            Cell rowCell = new EditableCell(new Position(i, 1));
            rowCell.setValue(0);
            rowCells.add(rowCell);
        }
        for (int i = 1; i < 10; i ++) {
            Cell colCell = new EditableCell(new Position(1, i));
            colCell.setValue(0);
            colCells.add(colCell);
        }

        rowCells.get(3).setValue(4);
        rowCells.get(6).setValue(1);
        rowCells.get(8).setValue(7);

        colCells.get(3).setValue(4);
        colCells.get(6).setValue(1);
        colCells.get(8).setValue(7);

        allDifferentRule = AllDifferentRule.getInstance();
    }

    @Test
    public void validateRowTest() {
        assertTrue(allDifferentRule.isValid(rowCells));
    }

    @Test
    public void validateColTest() {
        assertTrue(allDifferentRule.isValid(colCells));
    }

    @Test
    public void rowIsInvalid() {
        rowCells.get(0).setValue(4);
        assertFalse(allDifferentRule.isValid(rowCells));
    }

    @Test
    public void colsIsInvalid() {
        colCells.get(0).setValue(4);
        assertFalse(allDifferentRule.isValid(colCells));
    }
}
