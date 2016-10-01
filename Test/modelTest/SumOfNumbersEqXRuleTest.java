package modelTest;

import Model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SumOfNumbersEqXRuleTest {

    @Before
    public void setUp() {

    }

    @Test
    public void testRuleValidateWithValidData() {
        ArrayList<Cell> cells = new ArrayList<>();
        DataCell cell1 = new DataCell(new Position(1, 1));
        EditableCell cell2 = new EditableCell(new Position(1, 2));
        EditableCell cell3 = new EditableCell(new Position(1, 3));
        cell1.setValue(3);
        cell2.setValue(1);
        cell3.setValue(2);
        cells.add(cell1);
        cells.add(cell2);
        cells.add(cell3);
        assertTrue(SumOfNumbersEqXRule.getInstance().isValid(cells));

    }

    @Test
    public void testRuleValidateWithInvalidData() {
        ArrayList<Cell> cells = new ArrayList<>();
        DataCell cell1 = new DataCell(new Position(1, 1));
        EditableCell cell2 = new EditableCell(new Position(1, 2));
        EditableCell cell3 = new EditableCell(new Position(1, 3));
        cell1.setValue(1);
        cell2.setValue(6);
        cell3.setValue(2);
        cells.add(cell1);
        cells.add(cell2);
        cells.add(cell3);
        assertFalse(SumOfNumbersEqXRule.getInstance().isValid(cells));
    }
}
