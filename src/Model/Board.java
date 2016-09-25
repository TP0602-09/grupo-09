package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Lucía on 24/9/2016.
 */
public class Board {

    private ArrayList<HashMap> dicCells;
    private HashMap<Position,Cell> cells;

    private int rows;
    private int cols;

    public Board (int rows,int cols,ArrayList<HashMap>dicCells){
        cells = new HashMap<Position, Cell>();
        this.rows = rows;
        this.cols = cols;
        this.dicCells = dicCells;
        this.createCells();
    }

    private void createCells(){
        Iterator itr = dicCells.iterator();
        while(itr.hasNext()) {
            Object cellDic = itr.next(); //diccionario de la celda que trae del json
            Map mapCell = (Map)cellDic;
            ArrayList<String> position = (ArrayList<String>)mapCell.get("pos");
            System.out.print(position);
            String type = mapCell.get("type").toString();
            int value = Integer.parseInt(mapCell.get("value").toString());
            Cell cellInstance = factoryCellCreator(position,type,value);
            this.cells.put(cellInstance.getPosition(),cellInstance);
        }
        this.createEditableCells();
    }

    private void createEditableCells(){
        for (int i = 1; i <= this.rows; i++){
            for (int j = 1; j <= this.cols; j++){
                Position pos = new Position(i,j);
                if (this.cells.get(pos) == null){
                    Cell cell = new EditableCell(pos);
                    this.cells.put(pos,cell);
                }
            }
        }
    }

    private Cell factoryCellCreator(ArrayList<String> position,String type,int value){
        int posx = 1;//String.valueOf(position.get(1));
        int posy = 1;//Integer.parseInt(position.get(2));
        Position pos = new Position(posx,posy);
        Cell cell;
        if (type == "dat"){
            cell = new DataCell(pos);
        }else if (type == "Double"){
            cell = new DoubleCell(pos);
        }else{
            cell = new EditableCell(pos);
        }
        cell.setValue(value);
        return cell;
    }

    public int getRows(){
        return this.rows;
    }

    public HashMap<Position,Cell> getCells(){
        return this.cells;
    }

}
