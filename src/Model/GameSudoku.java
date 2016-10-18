package Model;
import java.util.List;

public class GameSudoku extends Game{

    public GameSudoku(List<Rule> rules){
        super(rules);
    }

    @Override
    public SectorBuilderStrategy currentStrategy() {
        return new SudokuSectorBuilderStrategy();
    }
}
