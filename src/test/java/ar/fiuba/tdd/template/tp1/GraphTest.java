package ar.fiuba.tdd.template.tp1; /**
 * Created by Ignacio on 23/10/2016.
 */
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GraphTest {

    @Before
    public void setUp() {

    }

/*    @Test
    public void testGraphIsNotCyclic() {
        Graph graph = new Graph();
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        assertFalse(graph.isCyclic());
    }*/

    @Test
    public void testGraphIsCyclic() {
        Graph graph = new Graph();
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(4,1);
        assertTrue(graph.isCyclic());
    }
}