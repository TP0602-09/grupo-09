package ar.fiuba.tdd.template.tp1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;

/**
 * Created by ljulia on 10/11/2016.
 */
public class ConsecutiveNumberRuleTest {

    @Test
    public void testNonConsecutiveNumbers() {
        List<BoardElement> elements = new ArrayList<>();
        Cell cell = new Cell();
        cell.setValue(1);
        elements.add(cell);
        cell = new Cell();
        cell.setValue(3);
        elements.add(cell);
        Sector sector = new Sector(elements);
        ConsecutiveNumbersRule rule = new ConsecutiveNumbersRule();
        assertFalse(rule.isValidSector(sector));
    }
}
