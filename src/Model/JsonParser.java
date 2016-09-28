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

public class JsonParser {


    private static final String ROWS = "rows";
    private static final String COLUMNS = "columns";
    private static final String CELLS = "cells";
    private static final String GAME = "game";
    private static final String TYPE = "type";
    private static final String DOUBLE = "Double";
    private static final String POS = "pos";
    private static final String VALUE = "value";
    private static final String VALUE_R = "value_r";
    private static final String VALUE_C = "value_c";
    private static final String DAT = "dat";
    private static final String NAME = "name";
    private static JsonParser INSTANCE = null;

    public static JsonParser instance() {
        if (INSTANCE == null) {
            INSTANCE = new JsonParser();
        }
        return INSTANCE;
    }

    private ArrayList<HashMap<String, Object>> cells;
    private int rows;
    private int columns;
    private String gameName;
    private Reader reader;
    private String jsonPath;


    private JsonParser() {
        rows = 0;
        columns = 0;
        gameName = null;
        reader = null;
        jsonPath = null;
        cells = null;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public String getGameName() {
        return gameName;
    }

    public ArrayList<HashMap<String, Object>> getCells() {
        return cells;
    }

    public void loadJson(String path) {
        if ((jsonPath != null && !jsonPath.equals(path)) ||
                (jsonPath == null && path != null)) {
            this.jsonPath = path;
            try {
                reader = new FileReader(new File(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void parseElements(String path) {
        JSONObject gameObject;
        try {
            gameObject = getGameObject(path);
            parseGameName(gameObject);
            parseRowsAndColumnsValues(gameObject);
            JSONArray cellsObjects = (JSONArray)
                    (gameObject != null ? gameObject.get(CELLS) : null);
            cells = new ArrayList<HashMap<String, Object>>();
            buildCells(cellsObjects);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void parseGameName(JSONObject gameObject) {
        gameName = ((String) gameObject.get(NAME));
    }

    private void parseRowsAndColumnsValues(JSONObject gameObject) {
        rows = ((Long) gameObject.get(ROWS)).intValue();
        columns = ((Long) gameObject.get(COLUMNS)).intValue();
    }

    private void buildCells(JSONArray cellsObjects) {
        for (Object cell : cellsObjects) {
            JSONObject cellObject = (JSONObject) cell;
            JSONArray posObject = (JSONArray) cellObject.get(POS);
            ArrayList<String> array = parsePosition(posObject);
            HashMap<String, Object> cellMap = new HashMap<String, Object>();
            parseTYpeAndValue(cellObject, array, cellMap);
            parseDouble(cellObject, cellMap);
            cells.add(cellMap);
        }
    }

    private void parseTYpeAndValue(JSONObject cellObject,
                                   ArrayList<String> array, HashMap<String, Object> cellMap) {
        cellMap.put(POS, array);
        cellMap.put(TYPE, cellObject.get(TYPE).toString());
        if (cellObject.get(TYPE).equals(DAT))
            cellMap.put(VALUE, cellObject.get(VALUE).toString());
    }

    private void parseDouble(JSONObject cellObject, HashMap<String, Object> cellMap) {
        if (cellObject.get(TYPE).equals(DOUBLE)) {
            cellMap.put(VALUE_C, cellObject.get(VALUE_C));
            cellMap.put(VALUE_R, cellObject.get(VALUE_R));
        }
    }

    private ArrayList<String> parsePosition(JSONArray posObject) {
        ArrayList<String> array = new ArrayList<String>();
        array.add(posObject.get(0).toString());
        array.add(posObject.get(1).toString());
        return array;
    }


    private JSONObject getGameObject(String path) throws ParseException {
        setupReaderIfNull(path);
        if (reader != null) {
            try {
                JSONObject root = createJsonRoot();
                return (JSONObject) root.get(GAME);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private JSONObject createJsonRoot() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object rootObject = parser.parse(reader);
        return (JSONObject) rootObject;
    }

    private void setupReaderIfNull(String path) {
        if (reader == null) {
            loadJson(path);
        }
    }
}