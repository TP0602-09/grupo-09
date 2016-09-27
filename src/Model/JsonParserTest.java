package Model;


/*import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;*/

public class JsonParserTest {
    private static final String KAKURO_PATH = "resources/Model/kakuro/kakuro_enunciado.json";
    private static final String SUDOKU_PATH = "resources/Model/sudoku/sudoku_enunciado.json";

   /* Test del Json
   public static void main(String[] args) {
        JsonParser parser = JsonParser.instance().instance();
        assert parser != null;
        parser.parseElements(SUDOKU_PATH);
        ArrayList<HashMap> array = parser.getCells();
        assert array != null;
        int rows = parser.getRows();
        assert rows != 0;
        int columns = parser.getColumns();
        assert columns != 0;
        String name = parser.getGameName();
        assert name != null;
        Iterator<HashMap> iterator = array.iterator();
        while (iterator.hasNext()) {
            HashMap map = iterator.next();
            Iterator<String> mapIterator = map.keySet().iterator();
            while (mapIterator.hasNext()) {
                String key = mapIterator.next();
                System.out.println
                        ( "key: " + key + " value: " + map.get(key));
            }

        }
    }*/
}