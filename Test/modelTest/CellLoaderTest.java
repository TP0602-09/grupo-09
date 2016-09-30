package modelTest;

import Model.Cell;
import Model.CellLoader;
import Model.Position;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class CellLoaderTest {
    private ArrayList<HashMap<String, Object>> list;

    @Before
    public void setUp() {

        list = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            HashMap<String,Object> map = new HashMap<>();
            ArrayList<String> array = new ArrayList<>();
            array.add(String.valueOf(i));
            array.add(String.valueOf(i));
            map.put("pos", array);
            map.put("type", "dat");
            map.put("value", i);
            list.add(map);
        }

    }

    @Test
    public void testLoadCellsWithValidData() {
        CellLoader cellLoader = CellLoader.getInstance();
        HashMap<Position, Cell> map = cellLoader.loadCells(list);
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

}
