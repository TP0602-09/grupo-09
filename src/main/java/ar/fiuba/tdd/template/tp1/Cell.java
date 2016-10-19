package ar.fiuba.tdd.template.tp1;

/**
 * Created by Lucía on 16/10/2016.
 */
public class Cell extends BoardElement{

    private Position pos;
    private int value;
    private boolean hasValue;

    public Cell(Position pos) {
        super(pos);
        this.pos = pos;
        this.hasValue = false;
    }

    public void setValue(int value) {
        this.value = value;
        this.hasValue = true;
    }

    public boolean hasValue() {
        return this.hasValue;
    }

    public int getValue() {

        return this.value;
    }

    public Position getPosition() {
        return this.pos;
    }
}
