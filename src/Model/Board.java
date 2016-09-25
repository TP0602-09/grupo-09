package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Lucía on 24/9/2016.
 */
public class Board {

    private ArrayList<Cell> dicCells;
    private ArrayList<Cell> cells;

    public Board (){
        cells = new ArrayList<Cell>();

    }

    private void createCells(){
        Iterator itr = dicCells.iterator();
        while(itr.hasNext()) {
            Object cellDic = (Map<String,String>)itr.next(); //diccionario de la celda que trae del json
            String key = "value";
            //   Cell cellInsance = factoryCellCreator(cellDic.get(key));
           // cells.add(cellInsance);
        }
    }

    private Cell factoryCellCreator(int x, int y,String type){
        return new DataCell(x,y);
    }
}
