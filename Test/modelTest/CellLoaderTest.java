package modelTest;

import model.Cell;
import model.CellLoader;
import model.Position;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import static org.junit.Assert.*;

public class CellLoaderTest {
    private ArrayList<HashMap<String, Object>> validData;
    private ArrayList<HashMap<String, Object>> invalidData;

    @Before
    public void setUp() {

        validData = new ArrayList<HashMap<String, Object>>();
        for (int i = 1; i < 9; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            ArrayList<String> array = new ArrayList<String>();
            array.add(String.valueOf(i));
            array.add(String.valueOf(i));
            map.put("pos", array);
            map.put("type", "dat");
            map.put("value", i);
            validData.add(map);
        }

        invalidData = new ArrayList<HashMap<String, Object>>();
        for (int i = 1; i < 9; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            ArrayList<String> array = new ArrayList<String>();
            array.add(String.valueOf(i));
            array.add(String.valueOf(i));
            map.put("pkk", array);
            map.put("type", "kkt");
            map.put("vaue", i);
            invalidData.add(map);
        }

    }

    @Test
    public void testLoadCellsWithValidData() {
        CellLoader cellLoader = CellLoader.getInstance();
        HashMap<Position, Cell> map = cellLoader.loadCells(validData);
        Iterator<Position> iterator = map.keySet().iterator();
        int i = 1;
        while (iterator.hasNext()) {
            Position position = iterator.next();
            assertEquals(i, position.getX());
            assertEquals(i, position.getY());
            assertEquals(position, map.get(position).getPosition());
            assertEquals(i, map.get(position).getValue());
            i++;
        }
    }

    @Test
    public void testLoadCellsWithInValidData() {
        CellLoader cellLoader = CellLoader.getInstance();
        try{
            cellLoader.loadCells(invalidData);
            fail();
        }catch (NullPointerException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testLoadCellsWithNullData() {
        CellLoader cellLoader = CellLoader.getInstance();
        try{
            cellLoader.loadCells(null);
            fail();
        }catch (NullPointerException e) {
            assertTrue(true);
        }
    }
}
