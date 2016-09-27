package Model;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SudokuBoardFactory extends BoardFactory {
    private static final String VALUE = "value";
    private static final String ROWS = "rows";
    private static final String COLUMNS = "columns";
    private static final String CELLS = "cells";
    private static final String GAME = "game";
    private static final String TYPE = "type";
    private static final String DAT = "dat";
    private static final String POS = "pos";
    private static final String SUDOKU_PATH = "resources/Model/sudoku/sudoku_enunciado.json";

    @Override
    public Board create() {
        try {
            JSONObject gameObject = getGameObject();
            int rows = 0;
            rows = getRows(gameObject, rows);
            int columns = 0;
            columns = getColumns(gameObject, columns);
            JSONArray cellsObjects = (JSONArray)
                    (gameObject != null ? gameObject.get(CELLS) : null);
            ArrayList<HashMap> cells = new ArrayList<>();
            buildCells(cellsObjects, cells);
            return new Board(rows, columns, cells);
        } catch (ParseException | NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

    private int getColumns(JSONObject gameObject, int columns) {
        if (gameObject != null) {
            columns = ((Long) gameObject.get(COLUMNS)).intValue();
        }
        return columns;
    }

    private int getRows(JSONObject gameObject, int rows) {
        if (gameObject != null) {
            rows = ((Long) gameObject.get(ROWS)).intValue();
        }
        return rows;
    }

    private void buildCells(JSONArray cellsObjects, ArrayList<HashMap> cells) {
        for (Object cell : cellsObjects) {
            JSONObject cellObject = (JSONObject) cell;
            if (cellObject.get(TYPE).equals(DAT)) {
                parsePosition(cells, cellObject);
            }
        }
    }

    private void parsePosition(ArrayList<HashMap> cells, JSONObject cellObject) {
        JSONArray posObject = (JSONArray) cellObject.get(POS);
        HashMap<String, Object> map = new HashMap<>();
        ArrayList<String> array = generatePosition(posObject);
        parseTypeAndValues(cellObject, map, array);
        cells.add(map);
    }

    private void parseTypeAndValues(JSONObject cellObject, HashMap<String, Object> map,
                                    ArrayList<String> array) {
        int value = ((Long) cellObject.get(VALUE)).intValue();
        map.put(POS, array);
        map.put(VALUE, value);
        map.put(TYPE, cellObject.get(TYPE).toString());
    }

    private ArrayList<String> generatePosition(JSONArray posObject) {
        ArrayList<String> array = new ArrayList<>();
        array.add(posObject.get(0).toString());
        array.add(posObject.get(1).toString());
        return array;
    }

    private JSONObject getGameObject() throws ParseException {
        try {
            Reader reader;
            reader = new FileReader(new File(SUDOKU_PATH));
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
