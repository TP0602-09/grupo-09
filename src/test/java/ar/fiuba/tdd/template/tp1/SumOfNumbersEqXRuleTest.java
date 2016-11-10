package ar.fiuba.tdd.template.tp1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;

/**
 * Created by ljulia on 10/11/2016.
 */
public class SumOfNumbersEqXRuleTest {

    @Test
    public void nonEqXSumOfNumbersTest() {
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
        Sector sector = new Sector(elements, 3);
        SumOfNumbersEqXRule rule = new SumOfNumbersEqXRule();
        assertFalse(rule.isValidSector(sector));
    }
}
