package Model;

import java.util.*;

public class Board {

    private int rows;
    private int columns;
    private HashMap<Position, Cell> cells;

    public Board(int rows, int cols, HashMap<Position, Cell> cells) {
        this.rows = rows;
        this.columns = cols;
        this.cells = cells;
    }

    public void addCell(Cell cell){
        this.cells.put(cell.getPosition(),cell);
    }

    public int getRows() {
        return this.rows;
    }

    public HashMap<Position, Cell> getCells() {
        return this.cells;
    }

    public List<List<Cell>> getSectorsToValidate(Cell cell) {

        List<List<Cell>> sectors = new ArrayList<List<Cell>>();

        sectors.add(getRow(cell));
        sectors.add(getColumn(cell));
        sectors.add(getMatrix(cell));

        return sectors;
    }

    private List<Cell> getColumn(Cell cell) {
        List<Cell> cells = new ArrayList<Cell>();

        int posX = cell.getPosition().getX();
        int posY = cell.getPosition().getY();

        for (Position pos : this.cells.keySet()) {
            if (pos.getX() == posX) {
                if (pos.getY() == posY) {
                    cells.add(cell);
                } else {
                    cells.add(this.cells.get(pos));
                }
            }
        }
        return cells;
    }

    private List<Cell> getRow(Cell cell) {
        List<Cell> cells = new ArrayList<Cell>();

        int posX = cell.getPosition().getX();
        int posY = cell.getPosition().getY();

        for (Position pos : this.cells.keySet()) {
            if (pos.getY() == posY) {
                if (pos.getX() == posX) {
                    cells.add(cell);
                } else {
                    cells.add(this.cells.get(pos));
                }
            }
        }
        return cells;
    }

    private List<Cell> getMatrix(Cell cell) {
        List<Cell> cells = new ArrayList<Cell>();

        int posX = cell.getPosition().getX();
        int posY = cell.getPosition().getY();

        int modX = (posX + 2) % 3; //resultados = 0, 1, 2
        int modY = (posY + 2) % 3;

        int posIniX = posX - modX;
        int posIniY = posY - modY;

        for (int x = posIniX; x < posIniX + 3; x++) {
            for (int y = posIniY; y < posIniY + 3; y++) {
                Position pos = new Position(x, y);
                if (pos.equals(cell.getPosition())) {
                    cells.add(cell);
                } else {

                    cells.add(this.cells.get(pos));
                }

            }
        }
        return cells;
    }

    public int getCols(){
        return this.columns;
    }

}
