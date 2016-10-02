package model;

public class EditableCell extends Cell {
    public EditableCell(Position pos){
        super(pos);
        this.setValue(0);
    }
}
