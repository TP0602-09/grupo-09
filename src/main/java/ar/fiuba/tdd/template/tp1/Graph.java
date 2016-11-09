package ar.fiuba.tdd.template.tp1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Graph {

    private static final int NO_PARENT = -1;
    private static final int MAX_VERTEX = 100;
    private List<LinkedList<Integer>> adjacents;

    Graph() {
        createAdjacentsList();
    }

    private void createAdjacentsList() {
        adjacents = new ArrayList<>();
        for (int i = 0; i < MAX_VERTEX; ++i) {
            adjacents.add(new LinkedList<>());
        }
    }


    public void addEdge(int vertex1, int vertex2) {
        adjacents.get(vertex1).add(vertex2);
        adjacents.get(vertex2).add(vertex1);
    }

    public boolean isCyclicUtil(int vertex, boolean[] visited, int parent) {

        visited[vertex] = true;

        for (int next : adjacents.get(vertex)) {
            if ((!visited[next]) && (isCyclicUtil(next, visited, vertex))) {
                return true;
            } else {
                if (next != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCyclic() {

        boolean[] visited = new boolean[MAX_VERTEX];
        for (int i = 0; i < MAX_VERTEX; i++) {
            visited[i] = false;
        }

        for (int u = 0; u < MAX_VERTEX; u++) {
            if (!visited[u] && isCyclicUtil(u, visited, NO_PARENT)) {
                return true;
            }
        }
        return false;
    }
}
