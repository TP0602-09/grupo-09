package Model;

/**
 * Created by Ignacio on 25/9/2016.
 */
/*
public class KakuroBoardFactory extends BoardFactory {
    private static  final String ROWS = "rows";
    private static  final String COLUMNS = "columns";
    private static final String CELLS = "cells";
    private static final String GAME = "columns";
    private static final String TYPE = "type";
    private static final String DOUBLE = "Double";
    private static final String POS = "pos";
    private static final String VALUE_R = "value_r";
    private static final String VALUE_C = "value_c";
    private static final String KAKURO_PATH = "../../../resources/Model/kakuro/kakuro_enunciado.json";

    @Override
    public Board create() {

        Reader reader;
        try {
            JSONObject gameObject = getGameObject();
            int rows =(int)gameObject.get(ROWS);
            int columns = (int) gameObject.get(COLUMNS);
            JSONArray cellsObjects = (JSONArray)gameObject.get(CELLS);
            ArrayList cells = new ArrayList();
            buildCells(cellsObjects, cells);
            return new Board(rows,columns,cells);
        }catch(IOException e) { e.printStackTrace();} catch (ParseException e) {
            e.printStackTrace();
        }


        return null;
    }

    private void buildCells(JSONArray cellsObjects, ArrayList cells) {
        for(Object cell:cellsObjects){
            JSONObject cellObject = (JSONObject)cell;
            if (cellObject.get(TYPE).equals(DOUBLE)) {
                JSONArray posObject = (JSONArray)cellObject.get(POS);
                Position position = new Position((int)posObject.get(0),
                        (int)posObject.get(0));
                int valueRow = (int)cellObject.get(VALUE_R);
                int valueColumn = (int)cellObject.get(VALUE_C);
                DoubleCell doubleCell = new DoubleCell(position);
                // TODO OJO EL DOUBLE CELL DEBE TENER 2 VALORES NO UNO
                doubleCell.setValue(valueRow);
                cells.add(doubleCell);
            }


        }
    }

    private JSONObject getGameObject() throws IOException, ParseException {
        Reader reader;
        reader = new FileReader(new File(KAKURO_PATH));
        JSONParser parser = new JSONParser();
        Object rootObject = parser.parse(reader);
        JSONObject root = (JSONObject)rootObject;
        return (JSONObject) root.get(GAME);
    }
}
*/