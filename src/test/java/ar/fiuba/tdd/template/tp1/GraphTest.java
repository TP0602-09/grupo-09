package ar.fiuba.tdd.template.tp1; /**
 * Created by Ignacio on 23/10/2016.
 */
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GraphTest {

    @Before
    public void setUp() {

    }

    @Test
    public void testGraphIsNotCyclic() {
        Graph graph = new Graph(2);
        graph.addEdge(new Position(1,1), new Position(1,2));
        graph.addEdge(new Position(1,2), new Position(2,1));
        assertFalse(graph.isCyclic());
    }

    @Test
    public void testGraphIsCyclic() {
        Graph graph = new Graph(2);
        graph.addEdge(new Position(1,1), new Position(1,2));
        graph.addEdge(new Position(1,2), new Position(2,1));
        graph.addEdge(new Position(2,1), new Position(1,1));
        assertTrue(graph.isCyclic());
    }
}
