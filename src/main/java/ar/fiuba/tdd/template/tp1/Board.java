package ar.fiuba.tdd.template.tp1;

import java.util.HashMap;
import java.util.List;

public class Board {

    private int rows;
    private int columns;
    private HashMap<Position, BoardElement> elements;
    private List<Sector> sectors;

    public Board(int rows, int cols, List<Sector> sectors) {
        this.rows = rows;
        this.columns = cols;
        this.sectors = sectors;
        this.elements = obtainElements();
    }

    private HashMap<Position, BoardElement> obtainElements() {
        HashMap<Position, BoardElement> elements = new HashMap<>();
        for (Sector sector : sectors) {
            for (BoardElement anElement : sector.getBoardElements()) {
                elements.put(anElement.getPosition(), anElement);
            }
        }
        return elements;
    }

    public int getRows() {
        return this.rows;
    }

    public HashMap<Position, BoardElement> getElements() {
        return this.elements;
    }

    public int getCols() {
        return this.columns;
    }

    public List<Sector> getSectors() {
        return this.sectors;
    }

    public boolean validate() {
        //TODO implement method
        return true;
    }

    public void update(Play play) {

    }
}
