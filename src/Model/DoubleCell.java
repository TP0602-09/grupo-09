package Model;

/**
 * Created by Lucía on 24/9/2016.
 */
public class DoubleCell extends Cell {

    private int x;
    private int y;

    public DoubleCell(Position pos){
        super(pos);
    }
    @Override
    public void setValue(int... values) {
        this.x = values[1];
        this.y = values[0];
    }

    public boolean canChangeValue() {
        return false;
    }
}
