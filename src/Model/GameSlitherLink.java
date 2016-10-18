package Model;

import java.util.ArrayList;
import java.util.List;

public class GameSlitherLink extends Game {
    private PathGenerator pathGenerator;
    public GameSlitherLink(List<Rule> rules) {
        super(rules);
        pathGenerator =  new SlitherlinkPathGenerator();
    }

    @Override
    public SectorBuilderStrategy currentStrategy() {
        return new NullSectorBuilderStrategy();
    }

    @Override
    public boolean isValid(Cell cell) {
        Graph graph = pathGenerator.generatePath(cell.getPosition(),
                getBoard());
        List<Cell> array = new ArrayList<>();
        array.add(cell);
        if (graph.isCyclic()) {
            BorderCountRule rule = new BorderCountRule();
            return rule.isValid(array);
        }
        LimitedBorderDrawn rule = new LimitedBorderDrawn();
        return rule.isValid(array);
    }

}
