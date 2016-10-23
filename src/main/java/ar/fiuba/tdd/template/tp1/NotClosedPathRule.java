package ar.fiuba.tdd.template.tp1;

/**
 * Created by Ignacio on 23/10/2016.
 */
public class NotClosedPathRule extends Rule {


    @Override
    public boolean isValidBoard(Board board) {
        GraphGenerator graphGenerator = new GraphGenerator();
        Graph graph = graphGenerator.generateGraph(board);
        return !graph.isCyclic();
    }


    @Override
    public boolean isValidSector(Sector sector) {
        return true;
    }
}
