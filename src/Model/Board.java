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
            Map mapCell = (Map) cellDic;
            if (mapCell.size() > 0) {
                ArrayList<Integer> position = (ArrayList<Integer>) mapCell.get("pos");
                String type = mapCell.get("type").toString();
                int value = Integer.parseInt(mapCell.get("value").toString());
                Cell cellInstance = factoryCellCreator(position, type, value);
                this.cells.put(position.get(1) + this.cols * (position.get(0) - 1), cellInstance);
                count++;
            }
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

    private Integer getPositionInMap(Position position){
        int i = position.getX();
        int j = position.getY();
        Integer positionInMap =  i + this.cols*(j-1);
        return positionInMap;
    }

    private Cell getCellAtPosition(Position position){
        Integer positionInMap = this.getPositionInMap(position);
        return this.cells.get(positionInMap);
    }

    public ArrayList<Cell> getCellsForRowOrCol(int row,boolean isGettingRow){
        ArrayList<Cell> cellRows = new ArrayList<Cell>();
        for(int i = 1; i <= this.rows ; i++){
            Position pos = (isGettingRow) ? new Position(row,i) : new Position(i,row);
            Cell cellToAdd = this.getCellAtPosition(pos);
            cellRows.add(cellToAdd);
        }
        return cellRows;
    }

    public void setCell(Cell cell){
        Position position = cell.getPosition();
        Integer positionInMap = this.getPositionInMap(position);
        System.out.print("Se coloca la celda ");
        System.out.print(cell.getValue());
        System.out.print(" Posicion: ");
        System.out.print(position.getX());
        System.out.print(" , ");
        System.out.println(position.getY());
        this.cells.put(positionInMap,cell);
    }

    public void imprimirPosisicion(Position pos){
        System.out.print(" Posicion: [ ");
        System.out.print(pos.getX());
        System.out.print(" , ");
        System.out.print(pos.getY());
        System.out.println(" ]");

    }
    public int getRows(){
        return this.rows;
    }

    public HashMap<Integer,Cell> getCells(){
        return this.cells;
    }

}
