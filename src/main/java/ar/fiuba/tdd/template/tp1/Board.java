package ar.fiuba.tdd.template.tp1;

import java.util.*;

public class Board {

    private int rows;
    private int columns;
    private HashMap<Position, BoardElement> elements;
    private List<Sector> sectors;
    private Set<Join> joins;

    public Board(int rows, int cols, List<Sector> sectors) {
        this.rows = rows;
        this.columns = cols;
        this.sectors = sectors;
        this.elements = obtainElements();
        this.joins = new HashSet<>();
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

    public BoardElement getElement(Position position) {
        return this.elements.get(position);
    }

    public int getCols() {
        return this.columns;
    }

    public List<Sector> getSectors() {
        return this.sectors;
    }

    public Set<Join> getJoins() {
        return joins;
    }

    public void addJoin(Join join) {
        this.joins.add(join);
    }

    public void deleteJoin(Join join) {
        this.joins.remove(join);
    }
}
