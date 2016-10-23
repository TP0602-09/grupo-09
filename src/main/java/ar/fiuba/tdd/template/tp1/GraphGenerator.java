package ar.fiuba.tdd.template.tp1;

/**
 * Created by Ignacio on 23/10/2016.
 */
public class GraphGenerator {

    public Graph generateGraph(Board board) {
        Graph graph = new Graph();
        for (Sector sector : board.getSectors()) {
            for (BoardElement boardElement1 : sector.getBoardElements()) {
                for (BoardElement boardElement2 : sector.getBoardElements()) {
                    for (Join join : board.getJoins()) {
                        if (join.hasBoardElement(boardElement1)
                                && join
                                .hasBoardElement(boardElement2)) {
                            Edge edge = createEdge(boardElement1
                                            .getPosition(),
                                    boardElement2.getPosition(),
                                    board.getRows());
                            graph.addEdge(edge.xcoordinate,
                                    edge.ycoordinate);
                        }
                    }
                }
            }
        }
        return graph;
    }

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
