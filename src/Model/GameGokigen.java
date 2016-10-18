package Model;

import java.util.List;


public class GameGokigen extends Game {
    private PathGenerator pathGenerator;

    public GameGokigen(List<Rule> rules) {
        super(rules);
        pathGenerator = new GokigenPathGenerator();
    }

    @Override
    public SectorBuilderStrategy currentStrategy() {
        return new RoomSectorBuilderStrategy();
    }

    @Override
    public boolean isValid(Cell cell) {
        Graph graph = pathGenerator.
                generatePath(cell.getPosition(), getBoard());
        return !graph.isCyclic() && super.isValid(cell);

    }
}
