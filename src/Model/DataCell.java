package Model;

/**
 * Created by Lucía on 24/9/2016.
 */
public class DataCell extends Cell {
    public DataCell(Position pos){
        super(pos);
    }

    public boolean canChangeValue() {
        return false;
    }
}
