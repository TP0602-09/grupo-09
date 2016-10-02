package modelTest;

import model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class AllDifferentRuleTest {

    @Before
    public void setUp() {

    }


    @Test
    public void testValidateRuleWithValideData() {
        ArrayList<Cell> cells = new ArrayList<Cell>();
        DataCell cell1 = new DataCell(new Position(1, 1));
        EditableCell cell2 = new EditableCell(new Position(1, 2));
        EditableCell cell3 = new EditableCell(new Position(1, 3));
        cell1.setValue(8);
        cell2.setValue(2);
        cell3.setValue(3);
        cells.add(cell1);
        cells.add(cell2);
        cells.add(cell3);
        assertTrue(AllDifferentRule.getInstance().isValid(cells));
    }

    @Test
    public void testValidateRuleWithInvalideData() {
        ArrayList<Cell> cells = new ArrayList<Cell>();
        DataCell cell1 = new DataCell(new Position(1, 1));
        EditableCell cell2 = new EditableCell(new Position(1, 2));
        EditableCell cell3 = new EditableCell(new Position(1, 3));
        cell1.setValue(2);
        cell2.setValue(2);
        cell3.setValue(3);
        cells.add(cell1);
        cells.add(cell2);
        cells.add(cell3);
        assertFalse(AllDifferentRule.getInstance().isValid(cells));
    }

}
