package Model;

import java.util.List;

public class GameKakuro extends Game {

    public GameKakuro(List<Rule> rules){
        super(rules);
    }

    public boolean validate(Cell cell){
        return true;
    }
}
