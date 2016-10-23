package ar.fiuba.tdd.template.tp1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Graph {

    public static final int NO_PARENT = -1;
    private int vertexCount;
    private List<LinkedList<Integer>> adjacents;

    // Constructor
    Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        adjacents = new ArrayList<>();
        for (int i = 0; i < vertexCount; ++i)
            adjacents.add(new LinkedList<>());
    }


    void addEdge(int vertex1, int vertex2) {
        adjacents.get(vertex1).add(vertex2);
        adjacents.get(vertex2).add(vertex1);
    }

    // A recursive function that uses visited[] and parent to detect
    // cycle in subgraph reachable from vertex vertex.
    Boolean isCyclicUtil(int vertex, Boolean visited[], int parent) {
        // Mark the current node as visited
        visited[vertex] = true;

        // Recur for all the vertices adjacent to this vertex
        for (int next : adjacents.get(vertex)) {

            // If an adjacent is not visited, then recur for that
            // adjacent
            if (!visited[next]) {
                if (isCyclicUtil(next, visited, vertex))
                    return true;
            }

            // If an adjacent is visited and not parent of current
            // vertex, then there is a cycle.
            else if (next != parent)
                return true;
        }
        return false;
    }

    // Returns true if the graph contains a cycle, else false.
    Boolean isCyclic() {
        // Mark all the vertices as not visited and not part of
        // recursion stack
        Boolean visited[] = new Boolean[vertexCount];
        for (int i = 0; i < vertexCount; i++)
            visited[i] = false;

        // Call the recursive helper function to detect cycle in
        // different DFS trees
        for (int u = 0; u < vertexCount; u++)
            if (!visited[u]) // Don't recur for u if already visited
                if (isCyclicUtil(u, visited, NO_PARENT))
                    return true;

        return false;
    }

}
