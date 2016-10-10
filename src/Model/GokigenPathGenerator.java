package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GokigenPathGenerator extends PathGenerator {
    private static final int LEFT_SLASH = 1;
    private static final int RIGHT_SLASH = 2;

    @Override
    protected void buildPath(Cell cell, ArrayList<Edge> array,
                             HashMap<Position, Cell> cells,
                             int boardSize) {
        if (cell.getValue()[0] == RIGHT_SLASH) {

            buildRight(cell, array, cells, boardSize);
        } else {
            if (cell.getValue()[0] == LEFT_SLASH) {
                buildLeft(cell, array, cells, boardSize);
            }
        }
    }

    private void buildLeft(Cell cell, ArrayList<Edge> array, HashMap<Position, Cell> cells, int size) {
        Edge edge = new Edge(cell.getPosition().getX(),
                cell.getPosition().getX() + size + 2);
        array.add(edge);
        HashMap<Position, Cell> map = removeCellFromMap(cell, cells);
        Position position1 = getDownLeftCell(cell, cells);
        Position position2 = getUpperRightCell(cell, cells);
        if (position1 != null) {
            buildPath(cells.get(position1), array, map, size);
        }
        if (position2 != null) {
            buildPath(cells.get(position2), array, map, size);
        }
    }

    private HashMap<Position, Cell> removeCellFromMap(Cell cell, HashMap<Position, Cell> cells) {
        HashMap<Position, Cell> map = new HashMap<>(cells);
        map.remove(cell.getPosition());
        return map;
    }

    private void buildRight(Cell cell, ArrayList<Edge> array, HashMap<Position, Cell> cells, Integer size) {
        Edge edge = new Edge(cell.getPosition().getX(),
                cell.getPosition().getX() + size + 2);
        array.add(edge);
        HashMap<Position, Cell> map = removeCellFromMap(cell, cells);
        Position position1 = getUpperLeftCell(cell, cells);
        Position position2 = getDownRightCell(cell, cells);
        if (position1 != null) {
            buildPath(cells.get(position1), array, map, size);
        }
        if (position2 != null) {
            buildPath(cells.get(position2), array, map, size);
        }
    }

    private Position getUpperLeftCell(Cell cell, HashMap<Position, Cell> cells) {
        Position position = null;
        Iterator<Position> iterator = cells.keySet().iterator();
        boolean found = false;
        while (iterator.hasNext() && !found) {
            position = iterator.next();
            found = position.getX() == cell.getPosition().getX() - 1 &&
                    position.getY() == cell.getPosition().getY() - 1;
        }
        return position;
    }


    private Position getDownRightCell(Cell cell, HashMap<Position, Cell> cells) {
        Position position = null;
        Iterator<Position> iterator = cells.keySet().iterator();
        boolean found = false;
        while (iterator.hasNext() && !found) {
            position = iterator.next();
            found = position.getX() == cell.getPosition().getX() + 1 &&
                    position.getY() == cell.getPosition().getY() + 1;
        }
        return position;
    }

    private Position getDownLeftCell(Cell cell, HashMap<Position, Cell> cells) {
        Position position = null;
        Iterator<Position> iterator = cells.keySet().iterator();
        boolean found = false;
        while (iterator.hasNext() && !found) {
            position = iterator.next();
            found = position.getX() == cell.getPosition().getX() + 1 &&
                    position.getY() == cell.getPosition().getY() - 1;
        }
        return position;
    }


    private Position getUpperRightCell(Cell cell, HashMap<Position, Cell> cells) {
        Position position = null;
        Iterator<Position> iterator = cells.keySet().iterator();
        boolean found = false;
        while (iterator.hasNext() && !found) {
            position = iterator.next();
            found = position.getX() == cell.getPosition().getX() - 1 &&
                    position.getY() == cell.getPosition().getY() + 1;
        }
        return position;
    }


}
