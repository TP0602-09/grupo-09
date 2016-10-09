package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PathGenerator {
    private static final int LEFT_SLASH = 1;
    private static final int RIGHT_SLASH = 2;

    public Graph generateGokigenPath(Position position, Board board) {
        Integer graphSize = 0;
        Cell cell = board.getCells().get(position);
        ArrayList<Edge> array = new ArrayList<>();
        buildPath(cell, array, board.getCells(), graphSize);
        Graph graph = new Graph(graphSize);
        generateGraphEdges(array, graph);
        return graph;
    }

    private void generateGraphEdges(ArrayList<Edge> array, Graph graph) {
        for (Edge edge : array) {
            graph.addEdge(edge.x, edge.y);
        }
    }

    private void buildPath(Cell cell, ArrayList<Edge> array, HashMap<Position, Cell> cells, int graphSize) {
        if (cell.getValue() == RIGHT_SLASH) {
            graphSize += 2;
            buildRight(cell, array, cells, graphSize);
        } else {
            if (cell.getValue() == LEFT_SLASH) {
                graphSize += 2;
                buildLeft(cell, array, cells, graphSize);
            }
        }
    }

    private void buildLeft(Cell cell, ArrayList<Edge> array, HashMap<Position, Cell> cells, int graphSize) {
        Edge edge = new Edge(cell.getPosition().getX(),
                cell.getPosition().getX() + 7);
        array.add(edge);

        Position position1 = getDownLeftCell(cell, cells);
        Position position2 = getUpperRightCell(cell, cells);
        if (position1 != null) {
            buildPath(cells.get(position1), array, cells, graphSize);
        }
        if (position2 != null) {
            buildPath(cells.get(position2), array, cells, graphSize);
        }
    }

    private void buildRight(Cell cell, ArrayList<Edge> array, HashMap<Position, Cell> cells, int graphSize) {
        Edge edge = new Edge(cell.getPosition().getX(),
                cell.getPosition().getX() + 7);
        array.add(edge);

        Position position1 = getUpperLeftCell(cell, cells);
        Position position2 = getDownRightCell(cell, cells);
        if (position1 != null) {
            buildPath(cells.get(position1), array, cells, graphSize);
        }
        if (position2 != null) {
            buildPath(cells.get(position2), array, cells, graphSize);
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

    private static class Edge {
        public int x;
        public int y;

        public Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
