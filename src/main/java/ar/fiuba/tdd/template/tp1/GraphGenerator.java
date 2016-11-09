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
        Graph graph = new Graph(board.getCols());
        for (Sector sector : board.getSectors()) {
            Set<Join> joinsPossibles = makeAllJoinsPossibles(sector.getBoardElements());
            for (Join join : board.getJoins()) {
                if (joinsPossibles.contains(join)) {
                    graph.addEdge(join.getFirstElement().getPosition(),
                            join.getSecondElement().getPosition());
                }
            }
        }
        return graph;
    }

    @SuppressWarnings("CPD-START")
    private Set<Join> makeAllJoinsPossibles(List<BoardElement> elements) {
        Set<Join> joinsPossibles = new HashSet<>();
        BoardElement first;
        BoardElement second;
        for (int i = 0; i < elements.size(); i ++) {
            first = elements.get(i);
            for (int j = i + 1; j < elements.size(); j ++) {
                second = elements.get(j);
                joinsPossibles.add(new Join(first, second));
            }
        }
        return joinsPossibles;
    }

}
