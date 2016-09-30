package modelTest;

import Model.DataCell;
import Model.Position;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DataCellTest {
    private Position position;

    @Before
    public void setUp() {
        position = new Position(3,9);
    }

    @Test
    public void testCreateDataCell() {
        DataCell dataCell = new DataCell(position);
        assertEquals(3,dataCell.getPosition().getX());
        assertEquals(9,dataCell.getPosition().getY());
        assertEquals(0,dataCell.getValue());
    }

    @Test
    public void testSetValue() {
        DataCell dataCell = new DataCell(position);
        assertEquals(0,dataCell.getValue());
        dataCell.setValue(4);
        assertEquals(4,dataCell.getValue());
    }

    @Test
    public void testSetArrayValue() {
        DataCell dataCell = new DataCell(position);
        assertEquals(0,dataCell.getValue());
        int[] array = {2,3};
        dataCell.setValue(array);
        assertEquals(2,dataCell.getValue());
    }
}
