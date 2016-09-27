/**
 * Created by Ignacio on 25/9/2016.
 */
package Model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;


public class KakuroBoardFactory extends BoardFactory {
    private static final String ROWS = "rows";
    private static final String COLUMNS = "columns";
    private static final String CELLS = "cells";
    private static final String GAME = "game";
    private static final String TYPE = "type";
    private static final String DOUBLE = "Double";
    private static final String POS = "pos";
    private static final String VALUE_R = "value_r";
    private static final String VALUE_C = "value_c";
    private static final String KAKURO_PATH = "resources/Model/kakuro/kakuro_enunciado.json";

    @Override
    public Board create() {

        Reader reader;
        try {
            JSONObject gameObject = getGameObject();
            int rows = ((Long) gameObject.get(ROWS)).intValue();
            int columns = ((Long) gameObject.get(COLUMNS)).intValue();
            JSONArray cellsObjects = (JSONArray) gameObject.get(CELLS);
            ArrayList<HashMap> cells = new ArrayList();
            buildCells(cellsObjects, cells);
            return new Board(rows, columns, cells);
        } catch (ParseException | NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void buildCells(JSONArray cellsObjects, ArrayList cells) {
        for (Object cell : cellsObjects) {
            JSONObject cellObject = (JSONObject) cell;
            JSONArray posObject = (JSONArray) cellObject.get(POS);
            ArrayList<String> array = parsePosition(posObject);
            HashMap map = parseTYpeAndValue(cellObject, array);
            cells.add(map);
        }


    }

    private HashMap parseTYpeAndValue(JSONObject cellObject, ArrayList<String> array) {
        HashMap map = new HashMap();
        map.put(POS, array);
        map.put(TYPE, cellObject.get(TYPE).toString());
        //TODO OJO que Double cell tiene 2 valores posibles
        map.put("value", cellObject.get(VALUE_R).toString());
        return map;
    }

    private ArrayList<String> parsePosition(JSONArray posObject) {
        ArrayList<String> array = new ArrayList<>();
        array.add(posObject.get(0).toString());
        array.add(posObject.get(1).toString());
        return array;
    }


    private JSONObject getGameObject() throws ParseException {
        try {
            Reader reader;
            reader = new FileReader(new File(KAKURO_PATH));
            JSONParser parser = new JSONParser();
            Object rootObject = parser.parse(reader);
            JSONObject root = (JSONObject) rootObject;
            return (JSONObject) root.get(GAME);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
