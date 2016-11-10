package ar.fiuba.tdd.template.tp1;

import java.util.*;

public class Board {

    private int rows;
    private int columns;
    private HashMap<Position, BoardElement> elements;
    private List<Sector> sectors;
    private Set<Join> joins;
    private Stack<Play> madePlays;

    public Board(int rows, int cols, List<Sector> sectors) {
        this.rows = rows;
        this.columns = cols;
        this.sectors = sectors;
        this.elements = obtainElements();
        this.joins = new HashSet<>();
        this.madePlays = new Stack<>();
    }

    public Stack<Play> getMadePlays() {
        return madePlays;
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

    public List<Sector> getColumnsSectors() {
        List<Sector> columns = new ArrayList<>();

        for (int x = 0; x < this.columns; x++) {
            List<BoardElement> elements = new ArrayList<>();
            for (int y = 0; y < this.rows; y++) {
                Position position = new Position(x,y);
                BoardElement element = this.elements.get(position);
                elements.add(element);
            }
            columns.add(new Sector(elements));
        }
        return columns;
    }

    public List<Sector> getRowsSectors() {
        List<Sector> rows = new ArrayList<>();

        for (int y = 0; y < this.columns; y++) {
            List<BoardElement> elements = new ArrayList<>();
            for (int x = 0; x < this.rows; x++) {
                Position position = new Position(y,x);
                BoardElement element = this.elements.get(position);
                elements.add(element);
            }
            rows.add(new Sector(elements));
        }
        return rows;
    }
}
