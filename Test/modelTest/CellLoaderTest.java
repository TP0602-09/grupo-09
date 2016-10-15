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
