package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class PathGenerator {

    public Graph generatePath(Position position, Board board) {
        Cell cell = board.getCells().get(position);
        ArrayList<Edge> array = new ArrayList<>();
        buildPath(cell, array, board.getCells(), board.getRows());

        removeDuplicateEdges(array);
        int graphSize = vertexCount(array);
        Graph graph = new Graph(graphSize);
        generateGraphEdges(array, graph);
        return graph;
    }

    private int vertexCount(ArrayList<Edge> array) {
        return array.size()*2;
    }

    protected abstract void buildPath(Cell cell, ArrayList<Edge> array,
                                      HashMap<Position, Cell> cells
            , int boardSize);


    private void generateGraphEdges(ArrayList<Edge> array, Graph graph) {
        for (Edge edge : array) {
            graph.addEdge(edge.x, edge.y);
        }
    }

    private void removeDuplicateEdges(List<Edge> edges) {
        for (Edge edge : edges) {
            ArrayList<Edge> auxiliar = new ArrayList<>(edges);
            auxiliar.remove(edge);
            for (Edge edgeToCompare : auxiliar) {
                if (edge.x
                        == edgeToCompare.x && edge.y
                        == edgeToCompare.y) {
                    edges.remove(edgeToCompare);
                }
            }
        }
    }

    protected static class Edge {
        public int x;
        public int y;

        public Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
