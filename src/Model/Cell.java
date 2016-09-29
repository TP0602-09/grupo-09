package Model;

/**
 * Created by Lucía on 24/9/2016.
 */
public abstract class Cell {
    private Position pos;
    private int value;

    public Cell(Position pos){
        this.pos = pos;
    }

    public void setValue(int... value){
        this.value = value[0];
    }

    public boolean hasValue() { return this.value != 0; }

    public int getValue(){
        return this.value;
    }

    public Position getPosition (){
        return this.pos;
    }

    public boolean canChangeValue() {return true; }

}
