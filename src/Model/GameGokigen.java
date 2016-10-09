package Model;

import java.util.HashMap;
import java.util.List;


public class GameGokigen extends Game {
    private HashMap<Position, CornerValues> corners;

    public GameGokigen(List<Rule> rules, HashMap<Position, CornerValues> corners) {
        super(rules);
        this.corners = corners;
    }
}
