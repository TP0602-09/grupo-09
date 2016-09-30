package modelTest;

import Model.DoubleCell;
import Model.EditableCell;
import Model.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EditableCellTest {

    private Position position;

    @Before
    public void setUp() {
        position = new Position(3, 9);
    }

    @Test
    public void testCreateEditableCell() {
        EditableCell editableCell = new EditableCell(position);
        assertEquals(3, editableCell.getPosition().getX());
        assertEquals(9, editableCell.getPosition().getY());
        assertEquals(0, editableCell.getValue());
    }

    @Test
    public void testSetValue() {
        EditableCell editableCell = new EditableCell(position);
        assertEquals(0, editableCell.getValue());
        editableCell.setValue(4);
        assertEquals(4, editableCell.getValue());
    }

    @Test
    public void testSetArrayValue() {
        EditableCell editableCell = new EditableCell(position);
        assertEquals(0, editableCell.getValue());
        int[] array = {2, 3};
        editableCell.setValue(array);
        assertEquals(2, editableCell.getValue());
    }
}
