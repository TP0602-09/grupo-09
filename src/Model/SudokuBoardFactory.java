package Model;

import Model.*;


import java.io.*;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by Ignacio on 25/9/2016.
 */
public class SudokuBoardFactory extends BoardFactory {
    private static final String VALUE ="value";
    private static  final String ROWS = "rows";
    private static  final String COLUMNS = "columns";
    private static final String CELLS = "cells";
    private static final String GAME = "columns";
    private static final String TYPE = "type";
    private static final String DAT = "dat";
    private static final String POS = "pos";
    private static final String SUDOKU_PATH = "../../../resources/Model/sudoku";
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
            if (cellObject.get(TYPE).equals(DAT)) {
                JSONArray posObject = (JSONArray)cellObject.get(POS);
                int value = (int) cellObject.get(VALUE);
                Position position = new Position((int)posObject.get(0),
                        (int)posObject.get(0));
                DataCell dataCell = new DataCell(position);
                dataCell.setValue(value);
                cells.add(dataCell);
            }


        }
    }

    private JSONObject getGameObject() throws IOException, ParseException {
        Reader reader;
        reader = new FileReader(new File(SUDOKU_PATH));
        JSONParser parser = new JSONParser();
        Object rootObject = parser.parse(reader);
        JSONObject root = (JSONObject)rootObject;
        return (JSONObject) root.get(GAME);
    }
}
