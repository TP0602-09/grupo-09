package Model;

public class DataCell extends Cell {
    public DataCell(Position pos){
        super(pos);
    }

    public boolean canChangeValue() {
        return false;
    }
}
