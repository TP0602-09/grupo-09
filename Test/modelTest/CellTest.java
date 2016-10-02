package modelTest;

import model.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Created by Lucía on 29/9/2016.
 *
 */
public class CellTest {

    private Cell editable;
    private Cell data;

    @Before
    public void createItems() {
        editable = new EditableCell(new Position(1,1));
        data = new DataCell(new Position(2,2));
    }

    @Test
    public void setValueTest() {
        editable.setValue(3);
        assertEquals(3, editable.getValue());

        data.setValue(4);
        assertEquals(4, data.getValue());
    }

}
