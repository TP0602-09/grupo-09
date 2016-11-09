package ar.fiuba.tdd.template.tp1;

import java.util.*;


public class Graph {

    private Map<Position, LinkedList<Position>> adjacents;
    private Map<Position, Boolean> visited;

    public Graph(int dimension) {
        this.visited = new HashMap<>();
        this.adjacents = new HashMap<>();
        for (int i = 1; i <= dimension; i ++) {
            for (int j = 1; j <= dimension; j ++) {
                this.adjacents.put(new Position(i,j), new LinkedList<>());
                this.visited.put(new Position(i,j), false);
            }
        }
    }

    public void addEdge(Position vertex1, Position vertex2) {
        if (!existsAdjacency(vertex1, vertex2)) {
            adjacents.get(vertex1).add(vertex2);
            adjacents.get(vertex2).add(vertex1);
        }
    }

    public boolean isCyclicUtil(Position vertex, Position parent) {

        visited.put(vertex, true);
        Position next;

        Iterator<Position> iterator = adjacents.get(vertex).iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (!visited.get(next)) {
                if (isCyclicUtil(next, vertex)) {
                    System.out.print("cycle with vertex");
                    System.out.print(" (" + vertex.getXcoordinate() + "," + vertex.getYcoordinate() + ")");
                    System.out.println(" (" + next.getXcoordinate() + "," + next.getYcoordinate() + ")");
                    return true;
                }
            } else if (!next.equals(parent)) {
                return true;
            }

        }
        return false;
    }

    public boolean isCyclic() {
        putVisitedInFalse();
        Iterator entries = adjacents.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry thisEntry = (Map.Entry) entries.next();
            Position position = (Position) thisEntry.getKey();
            if (!visited.get(position)) {
                if (isCyclicUtil(position, new Position(0,0))) {
                    return true;
                }
            }
        }
        return false;
    }

    private void putVisitedInFalse() {
        Iterator entries = visited.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry thisEntry = (Map.Entry) entries.next();
            Position position = (Position) thisEntry.getKey();
            visited.put(position, false);
        }
    }

    private boolean existsAdjacency(Position vertex1, Position vertex2) {
        for (Position vertex : this.adjacents.get(vertex1)) {
            if (vertex.equals(vertex2)) {
                return true;
            }
        }
        return false;
    }
}
