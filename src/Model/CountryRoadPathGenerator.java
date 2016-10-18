package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class CountryRoadPathGenerator extends PathGenerator {
    private static final int VISITED = 1;
    private static final int LEFT = 1;
    private static final int RIGHT = 2;
    private static final int UP = 3;
    private static final int DOWN = 4;

    @Override
    protected void buildPath(Cell cell, ArrayList<Edge> array,
                             HashMap<Position, Cell> cells, int boardSize) {
        if (cell != null) {

            if (cell.getValue()[LEFT] == 1) {
                buildLeft(cell.getPosition(), array, cells, boardSize);
            }

            if (cell.getValue()[RIGHT] == 1) {
                buildRight(cell.getPosition(), array, cells, boardSize);
            }
            if (cell.getValue()[UP] == 1) {
                buildUp(cell.getPosition(), array, cells, boardSize);
            }
            if (cell.getValue()[DOWN] == 1) {
                buildDown(cell.getPosition(), array, cells, boardSize);
            }
        }
    }

    private void buildDown(Position position, ArrayList<Edge> array,
                           HashMap<Position, Cell> cells,
                           int boardSize) {
        HashMap<Position, Cell> map = new HashMap<>(cells);
        map.remove(position);
        Iterator<Position> iterator = cells.keySet().iterator();
        boolean found = false;
        Cell cell = null;
        Position position1 = null;
        while (iterator.hasNext() && !found) {
            position1 = iterator.next();
            if (position1.getX() == position.getX() + 1 && position1.getY() ==
                    position.getY()) {
                cell = cells.get(position1);
                found = true;
            }

        }
        createEdge(position, cell, position1, array, boardSize);
        buildPath(cell, array, map, boardSize);

    }

    private void createEdge(Position position, Cell cell,
                            Position position1,
                            List<Edge> array, int boardSize) {

        if (cell != null && position1 != null) {
            Edge edge = new Edge((boardSize * position1.getX() - 1) +
                    position1.getY(),
                    boardSize * (position.getX() - 1) + position.getY());
            array.add(edge);

        }
    }

    private void buildUp(Position position, ArrayList<Edge> array,
                         HashMap<Position, Cell> cells,
                         int boardSize) {
        HashMap<Position, Cell> map = new HashMap<>(cells);
        map.remove(position);
        Iterator<Position> iterator = cells.keySet().iterator();
        boolean found = false;
        Cell cell = null;
        Position position1 = null;
        while (iterator.hasNext() && !found) {
            position1 = iterator.next();
            if (position1.getX() == position.getX() - 1 && position1.getY() ==
                    position.getY()) {
                cell = cells.get(position1);
                found = true;
            }

        }
        createEdge(position, cell, position1, array, boardSize);
        buildPath(cell, array, map, boardSize);
    }

    private void buildRight(Position position, ArrayList<Edge> array,
                            HashMap<Position, Cell> cells,
                            int boardSize) {
        HashMap<Position, Cell> map = new HashMap<>(cells);
        map.remove(position);
        Iterator<Position> iterator = cells.keySet().iterator();
        boolean found = false;
        Cell cell = null;
        Position position1 = null;
        while (iterator.hasNext() && !found) {
            position1 = iterator.next();
            if (position1.getX() == position.getX() && position1.getY() ==
                    position.getY() + 1) {
                cell = cells.get(position1);
                found = true;
            }
        }
        createEdge(position, cell, position1, array, boardSize);
        buildPath(cell, array, map, boardSize);
    }

    private void buildLeft(Position position, ArrayList<Edge> array,
                           HashMap<Position, Cell> cells,
                           int boardSize) {
        HashMap<Position, Cell> map = new HashMap<>(cells);
        map.remove(position);
        Iterator<Position> iterator = cells.keySet().iterator();
        boolean found = false;
        Cell cell = null;
        Position position1 = null;
        while (iterator.hasNext() && !found) {
            position1 = iterator.next();
            if (position1.getX() == position.getX() && position1.getY() ==
                    position.getY() - 1) {
                cell = cells.get(position1);
                found = true;
            }
        }
        createEdge(position, cell, position1, array, boardSize);
        buildPath(cell, array, map, boardSize);
    }
}
