package ar.fiuba.tdd.template.tp1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;

/**
 * Created by ljulia on 10/11/2016.
 */
public class MultiplyNumbersEqXRuleTest {

    @Test
    public void nonEqXMultOfNumbersTest() {
        List<BoardElement> elements = new ArrayList<>();
        Cell cell = new Cell();
        cell.setValue(1);
        elements.add(cell);
        cell = new Cell();
        cell.setValue(10);
        elements.add(cell);
        cell = new Cell();
        cell.setValue(2);
        elements.add(cell);
        Sector sector = new Sector(elements, 2);
        MultiplyNumbersEqXRule rule = new MultiplyNumbersEqXRule();
        assertFalse(rule.isValidSector(sector));
    }
}
