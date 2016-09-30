package modelTest;

import Model.AllDifferentRule;
import Model.Game;
import Model.Rule;
import Model.SumOfNumbersEqXRule;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


public class GameTest {
    ArrayList<Rule> rules;

    @Before
    public void setUp() {
        rules = new ArrayList<>();
        rules.add(AllDifferentRule.getInstance());
        rules.add(SumOfNumbersEqXRule.getInstance());
    }

    @Test
    public void testStartConfiguration() {
        Game game = new Game(rules);
        assertNull(game.getBoard());
        game.startConfiguration();
        assertNotNull(game.getBoard());
    }

    @Test
    public void testStartGame() {
        Game game = new Game(rules);
        assertNull(game.getBoard());
        game.startGame();
        assertNotNull(game.getBoard());
    }
}
