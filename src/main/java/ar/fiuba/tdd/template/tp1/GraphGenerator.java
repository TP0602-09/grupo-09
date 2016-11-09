package ar.fiuba.tdd.template.tp1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Ignacio on 23/10/2016.
 */
public class GraphGenerator {

    public Graph generateGraph(Board board) {
        Graph graph = new Graph();
        for (Sector sector : board.getSectors()) {
            Set<Join> joinsPossibles = makeAllJoinsPossibles(sector.getBoardElements());
            for (Join join : board.getJoins()) {
                if (joinsPossibles.contains(join)) {
                    Edge edge = createEdge(join.getFirstElement().getPosition(),
                            join.getSecondElement().getPosition(), board.getRows());
                    graph.addEdge(edge.xcoordinate,
                            edge.ycoordinate);
                }
            }
        }
        return graph;
    }

    @SuppressWarnings("CPD-START")
    private Set<Join> makeAllJoinsPossibles(List<BoardElement> elements) {

        Set<Join> joinsPossibles = new HashSet<>();

        for (BoardElement firstElement : elements) {
            joinsPossibles.addAll(elements.stream().map(secondElement ->
                    new Join(firstElement, secondElement)).collect(Collectors.toList()));
        }

        return joinsPossibles;
    }

    @SuppressWarnings("CPD-END")
    private Edge createEdge(Position position1, Position position2, int rows) {
        return new Edge((position1.getXcoordinate() - 1)
                * rows + position1.getYcoordinate(),
                (position2.getXcoordinate() - 1)
                        * rows + position2.getYcoordinate());
    }

    private static class Edge {

        public int xcoordinate;
        public int ycoordinate;

        public Edge(int xcoordinate, int ycoordinate) {
            this.xcoordinate = xcoordinate;
            this.ycoordinate = ycoordinate;
        }
    }
}
