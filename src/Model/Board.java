package Model;

import java.util.*;

/**
 * Created by Lucía on 24/9/2016.
 */
public class Board {

    private int rows;
    private int columns;
    private HashMap<Position,Cell> cells;

    public Board(int rows, int cols, HashMap<Position,Cell> cells) {
        this.rows = rows;
        this.columns = cols;
        this.cells = cells;
    }

    public int getRows() {
        return this.rows;
    }

    public HashMap<Position,Cell> getCells() { return this.cells; }

    public List<List<Cell>> getSectorsToValidate(Cell cell) {

        ArrayList<List<Cell>> sectores = new ArrayList<List<Cell>>();

        sectores.add(getRow(cell));
        sectores.add(getColumn(cell));
        sectores.add(getMatrix(cell));

        return sectores;
    }

    private List<Cell> getColumn(Cell cell) {
        ArrayList<Cell> cells = new ArrayList<Cell>();

        int posX = cell.getPosition().getX();
        int posY = cell.getPosition().getY();

        for (Position pos: this.cells.keySet() ) {
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
        ArrayList<Cell> cells = new ArrayList<Cell>();

        int posX = cell.getPosition().getX();
        int posY = cell.getPosition().getY();

        for (Position pos: this.cells.keySet() ) {
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
        ArrayList<Cell> cells = new ArrayList<Cell>();

        int posX = cell.getPosition().getX();
        int posY = cell.getPosition().getY();

        int modX = posX % 3;
        int modY = posY % 3;

        int posIniX = posX - modX;
        int posIniY = posY - modY;

        for (int x = posIniX; x < posIniX + 3; x++ ) {
            for (int y = posIniY; y < posIniY + 3; y++ ) {
                Position pos = new Position(x,y);
                if(pos.equals(cell.getPosition())) {
                    cells.add(cell);
                } else {
                    cells.add(this.cells.get(pos));
                }
            }
        }
        return cells;
    }

}
