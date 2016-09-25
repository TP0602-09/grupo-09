package Model;

/**
 * Created by Lucía on 24/9/2016.
 */
public class DataCell extends Cell {
    public DataCell(int x, int y){
        super(x,y);
        this.canChangeValue = false;
    }
}
