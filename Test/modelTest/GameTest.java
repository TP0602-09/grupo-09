package modelTest;

import model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


public class GameTest {
    ArrayList<Rule> rules;

    @Before
    public void setUp() {
        rules = new ArrayList<Rule>();
        rules.add(AllDifferentRule.getInstance());
        rules.add(SumOfNumbersEqXRule.getInstance());
    }

    @Test
    public void testStartConfiguration() throws GameNotFoundException {
        Game game = new Game(rules);
        assertNull(game.getBoard());
        game.startConfiguration("sudoku");
        assertNotNull(game.getBoard());
    }

    @Test
    public void testStartGame() throws GameNotFoundException {
        Game game = new Game(rules);
        assertNull(game.getBoard());
        game.startGame("sudoku");
        assertNotNull(game.getBoard());
    }
}
