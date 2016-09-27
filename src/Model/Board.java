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
    private HashMap<Integer,Cell> cells;
    /* Las celdas estan guardadas como 1=Celda1;2=Celda2 y asi
    no me dejaba guardarla por posiciones pero estan en orden del a matriz
     */

    private int rows;
    private int cols;

    public Board (int rows,int cols,ArrayList<HashMap>dicCells){
        cells = new HashMap<Integer, Cell>();
        this.rows = rows;
        this.cols = cols;
        this.dicCells = dicCells;
        this.createCells();
    }

    private void createCells(){
        Iterator itr = dicCells.iterator();
        int count = 1;
        while(itr.hasNext()) {
            Object cellDic = itr.next(); //diccionario de la celda que trae del json
            Map mapCell = (Map)cellDic;
            ArrayList<Integer> position = (ArrayList<Integer>)mapCell.get("pos");
            String type = mapCell.get("type").toString();
            int value = Integer.parseInt(mapCell.get("value").toString());
            Cell cellInstance = factoryCellCreator(position,type,value);
            this.cells.put(position.get(1)+this.cols*(position.get(0)-1),cellInstance);
            count++;
        }
        this.createEditableCells();
    }

    private void createEditableCells(){
        /*En todos los lugares del mapa vacio le meto una celda editable*/
        for (int i = 1; i <= this.rows; i++){
            for (int j = 1; j <= this.cols; j++){
                int positionInMap = i + this.cols*(j-1);
                Position pos = new Position(i,j);
                if (this.cells.get(positionInMap) == null){
                    Cell cell = new EditableCell(pos);
                    this.cells.put(positionInMap,cell);
                }
            }
        }
    }

    private Cell factoryCellCreator(ArrayList<Integer> position,String type,int value){
        int posx = position.get(0);
        int posy = position.get(1);
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

    public HashMap<Integer,Cell> getCells(){
        return this.cells;
    }

}
