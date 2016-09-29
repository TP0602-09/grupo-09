package modelTest;

import Model.Position;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Lucía on 29/9/2016.
 */
public class PositionTest {

    private Position position;

    @Before
    public void createPosition() {
        position = new Position(3,5);
    }

    @Test
    public void equalsPositionTest() {
        Position newPos = new Position(3,5);
        assertEquals(newPos, position);
    }
}
