package modelTest;

import Model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class IncidentLineRuleTest {
    private HashMap<Position, CornerValues> cornerValuesSet;
    private Position position;

    @Before
    public void setUp() {
        cornerValuesSet = new HashMap<>();
        CornerValues cornerValues = new CornerValues();
        cornerValues.setUpperLeft(2);
        cornerValues.setUpperRight(4);
        cornerValues.setDownLeft(3);
        cornerValues.setDownRight(4);
        position = new Position(2, 2);
        cornerValuesSet.put(position, cornerValues);
    }

    @Test
    public void testUpperLeftIncidentLinesShouldReturnTrue() {
        IncidentLineRule rule = IncidentLineRule.getInstance(cornerValuesSet);
        ArrayList<Cell> cells = new ArrayList<>();
        EditableCell aCell = new EditableCell(new Position(2, 2));
        aCell.setValue(1);
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
        IncidentLineRule rule = IncidentLineRule.getInstance(cornerValuesSet);
        ArrayList<Cell> cells = new ArrayList<>();
        EditableCell aCell = new EditableCell(new Position(2, 2));
        aCell.setValue(2);
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
        IncidentLineRule rule = IncidentLineRule.getInstance(cornerValuesSet);
        ArrayList<Cell> cells = new ArrayList<>();
        EditableCell aCell = new EditableCell(new Position(2, 2));
        aCell.setValue(1);
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
        IncidentLineRule rule = IncidentLineRule.getInstance(cornerValuesSet);
        ArrayList<Cell> cells = new ArrayList<>();
        EditableCell aCell = new EditableCell(new Position(2, 2));
        aCell.setValue(2);
        cornerValuesSet.get(position).setUpperRight(2);
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
        IncidentLineRule rule = IncidentLineRule.getInstance(cornerValuesSet);
        ArrayList<Cell> cells = new ArrayList<>();
        EditableCell aCell = new EditableCell(new Position(2, 2));
        aCell.setValue(2);
        cornerValuesSet.get(position).setDownLeft(2);
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



