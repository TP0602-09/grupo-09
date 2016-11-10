package ar.fiuba.tdd.template.tp1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;

/**
 * Created by ljulia on 10/11/2016.
 */
public class AllDifferentRuleTest {

    @Test
    public void nonAllDifferentTest() {
        List<BoardElement> elements = new ArrayList<>();
        Cell cell = new Cell();
        cell.setValue(1);
        elements.add(cell);
        cell = new Cell();
        cell.setValue(2);
        elements.add(cell);
        cell = new Cell();
        cell.setValue(1);
        elements.add(cell);
        Sector sector = new Sector(elements);
        AllDifferentRule rule = new AllDifferentRule();
        assertFalse(rule.isValidSector(sector));
    }
}
