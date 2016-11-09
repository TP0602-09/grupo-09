package ar.fiuba.tdd.template.tp1;

public class ValuePlay extends Play {

    private Position position;
    private int value;
    private int lastValue = 0;

    public ValuePlay() {
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public void doIt(Board board) {
        Cell oneCell = (Cell) board.getElement(position);
        lastValue = oneCell.getValue();
        oneCell.setValue(value);
        System.out.println("You are going to set value " + value + " into position ("
                + position.getXcoordinate() + "," + position.getYcoordinate() + ")");
        board.getMadePlays().push(this);
    }

    @Override
    public void rollback(Board board) {
        Cell oneCell = (Cell) board.getElement(position);
        oneCell.setValue(lastValue);
    }
}
