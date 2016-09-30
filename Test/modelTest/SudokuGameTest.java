package modelTest;

import Model.AllDifferentRule;
import Model.GameSudoku;
import Model.Rule;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SudokuGameTest {
    private ArrayList<Rule> rulesSudoku;

    @Before
    public void setUp() {
        rulesSudoku = new ArrayList<>();
        rulesSudoku.add(AllDifferentRule.getInstance());
    }

    @Test
    public void testStartGame() {
        GameSudoku gameSudoku = new GameSudoku(rulesSudoku);
        assertNull(gameSudoku.getBoard());
        gameSudoku.startGame();
        assertNotNull(gameSudoku.getBoard());
        assertEquals(9, gameSudoku.getBoard().getRows());
        assertNotNull(gameSudoku.getBoard().getCells());
    }

    @Test
    public void testStartConfiguration() {
        GameSudoku gameSudoku = new GameSudoku(rulesSudoku);
        assertNull(gameSudoku.getBoard());
        gameSudoku.startConfiguration();
        assertNotNull(gameSudoku.getBoard());
        assertNotNull(gameSudoku.getBoard().getCells());
    }

    @Test
    public void testSudokuGameHasCorrectRowSize() {
        GameSudoku gameSudoku = new GameSudoku(rulesSudoku);
        gameSudoku.startGame();
        assertEquals(9, gameSudoku.getBoard().getRows());
    }

}
