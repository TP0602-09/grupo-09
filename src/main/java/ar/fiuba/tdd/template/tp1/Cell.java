package ar.fiuba.tdd.template.tp1;

/**
 * Created by Lucía on 16/10/2016.
 */
public class Cell extends BoardElement{

    private int value;
    private boolean hasValue;

    public Cell() {
        super();
        this.hasValue = false;
    }

    public void setValue(int value) {
        this.value = value;
        this.hasValue = (value != -1);
    }

    public boolean hasValue() {
        return this.hasValue;
    }

    public int getValue() {

        return this.value;
    }
}
