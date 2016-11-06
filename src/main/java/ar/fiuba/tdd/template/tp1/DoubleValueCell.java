package ar.fiuba.tdd.template.tp1;

/**
 * Created by Ignacio on 6/11/2016.
 */
public class DoubleValueCell extends Cell {
    private int doubleValue;

    public int getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(int doubleValue) {
        this.doubleValue = doubleValue;
    }

    public void setValues(int value, int doubleValue) {
        setValue(value);
        setDoubleValue(doubleValue);
    }
}
