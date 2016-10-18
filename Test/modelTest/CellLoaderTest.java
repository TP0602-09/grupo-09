package modelTest;

import Model.Cell;
import Model.CellLoader;
import Model.Position;
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

        validData = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            HashMap<String, Object> map = new HashMap<>();
            ArrayList<String> array = new ArrayList<>();
            array.add(String.valueOf(i));
            array.add(String.valueOf(i));
            map.put("pos", array);
            map.put("type", "dat");
            map.put("value", i);
            validData.add(map);
        }

        invalidData = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            HashMap<String, Object> map = new HashMap<>();
            ArrayList<String> array = new ArrayList<>();
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
        CellLoader cellLoader = new  CellLoader();
        HashMap<Position, Cell> map = cellLoader.loadCells(validData);
        Iterator<Position> iterator = map.keySet().iterator();
        int i = 1;
        while (iterator.hasNext()) {
            Position position = iterator.next();
            assertEquals(i, position.getX());
            assertEquals(i, position.getY());
            assertEquals(position, map.get(position).getPosition());
            i++;
        }
    }

    @Test
    public void testLoadCellsWithInValidData() {
        CellLoader cellLoader = new CellLoader();
        try{
            cellLoader.loadCells(invalidData);
            fail();
        }catch (NullPointerException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testLoadCellsWithNullData() {
        CellLoader cellLoader = new CellLoader();
        try{
            cellLoader.loadCells(null);
            fail();
        }catch (NullPointerException e) {
            assertTrue(true);
        }
    }
}
