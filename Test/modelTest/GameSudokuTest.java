package modelTest;

import model.AllDifferentRule;
import model.GameNotFoundException;
import model.GameSudoku;
import model.Rule;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GameSudokuTest {
    private ArrayList<Rule> rulesSudoku;

    @Before
    public void setUp() {
        rulesSudoku = new ArrayList<Rule>();
        rulesSudoku.add(AllDifferentRule.getInstance());
    }

    @Test
    public void testStartGame() throws GameNotFoundException {
        GameSudoku gameSudoku = new GameSudoku(rulesSudoku);
        assertNull(gameSudoku.getBoard());
        gameSudoku.startGame("sudoku");
        assertNotNull(gameSudoku.getBoard());
        assertEquals(9, gameSudoku.getBoard().getRows());
        assertNotNull(gameSudoku.getBoard().getCells());
    }

    @Test
    public void testStartConfiguration() throws GameNotFoundException {
        GameSudoku gameSudoku = new GameSudoku(rulesSudoku);
        assertNull(gameSudoku.getBoard());
        gameSudoku.startConfiguration("sudoku");
        assertNotNull(gameSudoku.getBoard());
        assertNotNull(gameSudoku.getBoard().getCells());
    }

    @Test
    public void testSudokuGameHasCorrectRowSize() throws GameNotFoundException{
        GameSudoku gameSudoku = new GameSudoku(rulesSudoku);
        gameSudoku.startGame("sudoku");
        assertEquals(9, gameSudoku.getBoard().getRows());
    }

}
