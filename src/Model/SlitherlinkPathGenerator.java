package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class SlitherlinkPathGenerator extends PathGenerator {
    private static final int LEFT = 1;
    private static final int RIGHT = 2;
    private static final int UP = 3;
    private static final int DOWN = 4;
    private static final int VISITED = 1;

    @Override
    protected void buildPath(Cell cell, ArrayList<Edge> array,
                             HashMap<Position, Cell> cells
            , int boardSize) {
        if (cell != null) {
            if (cell.getValue()[LEFT] == VISITED) {
                buildLeft(cell, array, cells, boardSize);
            }

            if (cell.getValue()[RIGHT] == VISITED) {
                buildRight(cell, array, cells, boardSize);
            }
            if (cell.getValue()[UP] == VISITED) {
                buildUp(cell, array, cells, boardSize);
            }
            if (cell.getValue()[DOWN] == VISITED) {
                buildDown(cell, array, cells, boardSize);
            }
        }
    }

    private void buildDown(Cell cell, ArrayList<Edge> array, HashMap<Position, Cell> cells, int boardSize) {
        HashMap<Position, Cell> map = removeActualCell(cell, cells);
        Edge edge = new Edge(cell.getPosition().getX() * boardSize +
                cell.getPosition().getY(), cell.getPosition().getX() * boardSize +
                cell.getPosition().getY() + 1);
        array.add(edge);
        Position position = getDownCell(cell, map);
        if (position != null) {
            buildPath(map.get(position), array, map, boardSize);
        }
    }

    private Position getDownCell(Cell cell, HashMap<Position, Cell> cells) {

        for (Position position : cells.keySet()) {
            if (position.getX() == cell.getPosition().getX() + 1 &&
                    position.getY() == cell.getPosition().getY()) {
                return position;
            }
        }
        return null;
    }

    private HashMap<Position, Cell> removeActualCell(Cell cell, HashMap<Position, Cell> cells) {
        HashMap<Position, Cell> map = new HashMap<>(cells);
        map.remove(cell.getPosition());
        return map;
    }

    private void buildUp(Cell cell, ArrayList<Edge> array, HashMap<Position, Cell> cells, int boardSize) {
        HashMap<Position, Cell> map = removeActualCell(cell, cells);
        Edge edge = new Edge((cell.getPosition().getX() - 1) * boardSize +
                cell.getPosition().getY(), (cell.getPosition().getX() - 1) * boardSize +
                cell.getPosition().getY() + 1);
        array.add(edge);

        Position position = getUpCell(cell, map);
        if (position != null) {
            buildPath(map.get(position), array, map, boardSize);
        }
    }

    private Position getUpCell(Cell cell, HashMap<Position, Cell> cells) {
        for (Position position : cells.keySet()) {
            if (position.getX() == cell.getPosition().getX() - 1 &&
                    position.getY() == cell.getPosition().getY()) {
                return position;
            }
        }
        return null;

    }

    private void buildRight(Cell cell, ArrayList<Edge> array, HashMap<Position, Cell> cells, int boardSize) {
        HashMap<Position, Cell> map = removeActualCell(cell, cells);
        Edge edge = new Edge((cell.getPosition().getX() - 1) * boardSize +
                cell.getPosition().getY() + 1, cell.getPosition().getX() * boardSize +
                cell.getPosition().getY() + 1);
        array.add(edge);
        Position position = getRightCell(cell, map);
        if (position != null) {
            buildPath(map.get(position), array, map, boardSize);
        }

    }

    private Position getRightCell(Cell cell, HashMap<Position, Cell> cells) {
        for (Position position : cells.keySet()) {
            if (position.getX() == cell.getPosition().getX() &&
                    position.getY() == cell.getPosition().getY() + 1) {
                return position;
            }
        }
        return null;

    }

    private void buildLeft(Cell cell, ArrayList<Edge> array,
                           HashMap<Position, Cell> cells, int boardSize) {
        HashMap<Position, Cell> map = removeActualCell(cell, cells);
        Edge edge = new Edge((cell.getPosition().getX() - 1) * boardSize +
                cell.getPosition().getY() + 1, cell.getPosition().getX() * boardSize +
                cell.getPosition().getY() + 1);
        array.add(edge);

        Position position = getLeftCell(cell, map);
        if (position != null) {
            buildPath(map.get(position), array, map, boardSize);
        }
    }

    private Position getLeftCell(Cell cell, HashMap<Position, Cell> cells) {
        for (Position position : cells.keySet()) {
            if (position.getX() == cell.getPosition().getX() &&
                    position.getY() == cell.getPosition().getY() - 1) {
                return position;
            }
        }
        return null;

    }
}
