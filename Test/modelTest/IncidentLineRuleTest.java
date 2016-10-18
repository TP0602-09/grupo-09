package modelTest;

import Model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class IncidentLineRuleTest {

    private Position position;

    @Before
    public void setUp() {
        position = new Position(2, 2);
    }

    @Test
    public void testUpperLeftIncidentLinesShouldReturnTrue() {
        IncidentLineRule rule = new IncidentLineRule();
        ArrayList<Cell> cells = new ArrayList<>();
        EditableCell aCell = new EditableCell(new Position(2, 2));
        int[] array = {1,2,4,3,4};
        aCell.setValue(array);
        cells.add(aCell);
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                EditableCell cell = new EditableCell(new Position(i, j));
                if (i == 2 && j == 2) {
                    continue;
                }
                cell.setValue(1);
                cells.add(cell);
            }
        }
        assertTrue(rule.isValid(cells));
    }


    @Test
    public void testDownLeftIncidentLinesShouldReturnTrue() {
        IncidentLineRule rule = new IncidentLineRule();

        ArrayList<Cell> cells = new ArrayList<>();
        EditableCell aCell = new EditableCell(new Position(2, 2));
        int[] array = {2,2,4,3,4};
        aCell.setValue(array);
        cells.add(aCell);
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                EditableCell cell = new EditableCell(new Position(i, j));
                if (i == 2 && j == 2) {
                    continue;
                }
                cell.setValue(1);
                cells.add(cell);
            }
        }
        assertTrue(rule.isValid(cells));
    }

    @Test
    public void testMoreUpperLeftIncidentLinesShouldReturnFalse() {
        IncidentLineRule rule = new IncidentLineRule();
        ArrayList<Cell> cells = new ArrayList<>();
        EditableCell aCell = new EditableCell(new Position(2, 2));
        int[] array = {1,2,4,3,4};
        aCell.setValue(array);
        cells.add(aCell);
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                EditableCell cell = new EditableCell(new Position(i, j));
                if (i == 2 && j == 2) {
                    continue;
                }
                cell.setValue(2);
                cells.add(cell);
            }
        }
        assertFalse(rule.isValid(cells));
    }

    @Test
    public void testMoreUpperRightIncidentLinesShouldReturnFalse() {
        IncidentLineRule rule = new IncidentLineRule();
        ArrayList<Cell> cells = new ArrayList<>();
        EditableCell aCell = new EditableCell(new Position(2, 2));
        int[] array = {2,2,2,3,4};
        aCell.setValue(array);
        cells.add(aCell);
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                EditableCell cell = new EditableCell(new Position(i, j));
                if (i == 2 && j == 2) {
                    continue;
                }
                cell.setValue(1);
                cells.add(cell);
            }
        }
        assertFalse(rule.isValid(cells));
    }

    @Test
    public void testMoreDownLeftIncidentLinesShouldReturnFalse() {
        IncidentLineRule rule = new IncidentLineRule();
        ArrayList<Cell> cells = new ArrayList<>();
        EditableCell aCell = new EditableCell(new Position(2, 2));
        int[] array = {2,2,4,2,4};
        aCell.setValue(array);
        cells.add(aCell);
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                EditableCell cell = new EditableCell(new Position(i, j));
                if (i == 2 && j == 2) {
                    continue;
                }
                cell.setValue(1);
                cells.add(cell);
            }
        }
        assertFalse(rule.isValid(cells));
    }
}



