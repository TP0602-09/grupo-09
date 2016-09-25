package Model;

/**
 * Created by Lucía on 24/9/2016.
 */
public abstract class Cell {
    private Position pos;
    private int value;
    public boolean canChangeValue;

    public Cell(int x,int y){
        this.pos = new Position(x,y);
    }

    public void setValue(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public Position getPosition (){
        return this.pos;
    }

}
