package Model;

/**
 * Created by Lucía on 24/9/2016.
 */
public class EditableCell extends Cell {
    public EditableCell(int x, int y){
        super(x,y);
        this.setValue(0);
        this.canChangeValue = true;
    }
}
