package Model;

import java.util.List;


public class GameInshiNoHesha extends Game {

    public GameInshiNoHesha(List<Rule> rules) {
        super(rules);
    }

    @Override
    public SectorBuilderStrategy currentStrategy() {
        return new RoomSectorBuilderStrategy();
    }
}
