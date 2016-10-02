package modelTest;

import model.DoubleCell;
import model.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class DoubleCellTest {

    private Position position;

    @Before
    public void setUp() {
        position = new Position(3, 9);
    }

    @Test
    public void testCreateDoubleCell() {
        DoubleCell doubleCell = new DoubleCell(position);
        assertEquals(3, doubleCell.getPosition().getX());
        assertEquals(9, doubleCell.getPosition().getY());
        assertEquals(0, doubleCell.getValue());
    }

    @Test
    public void testSetArrayValue() {
        DoubleCell doubleCell = new DoubleCell(position);
        assertEquals(0, doubleCell.getValue());
        int[] array = {2, 3};
        doubleCell.setValue(array);
        assertEquals(0, doubleCell.getValue());
    }
}
