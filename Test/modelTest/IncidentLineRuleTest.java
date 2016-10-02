package modelTest;

import Model.CornerValues;
import Model.Position;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class IncidentLineRuleTest {
    private HashMap<Position, CornerValues> cornerValuesSet;

    @Before
    public void setUp() {
        cornerValuesSet = new HashMap<>();
        CornerValues cornerValues = new CornerValues();
        cornerValues.setUpperLeft(2);
        cornerValues.setUpperRight(1);
        cornerValues.setDownLeft(3);
        cornerValues.setDownRight(4);
        Position position = new Position(2,2);
        cornerValuesSet.put(position, cornerValues);
    }

    @Test
    public void testSomething(){
        assertTrue(true);
    }
}