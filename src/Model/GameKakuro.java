package Model;

import java.util.List;

public class GameKakuro extends Game {

    public GameKakuro(List<Rule> rules){
        super(rules);
    }

    @Override
    public SectorBuilderStrategy currentStrategy() {
        return new RoomSectorBuilderStrategy();
    }

}
