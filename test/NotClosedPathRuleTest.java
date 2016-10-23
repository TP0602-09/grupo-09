/**
 * Created by Ignacio on 23/10/2016.
 */

import ar.fiuba.tdd.template.tp1.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class NotClosedPathRuleTest {
    private static final int ROWS = 5;
    private static final int COLS = 5;
    private Board board;
    private List<Sector> sectors;
    private List<BoardElement> closePathElements;
    private List<BoardElement> openPathElements;
    @Before
    public void setUp() {
        closePathElements = new ArrayList<>();
        openPathElements = new ArrayList<>();
        generateBoardElements(closePathElements);
        generateBoardElements(openPathElements);
        setupOpenPathJoins(openPathElements);
        setupClosedPathJoins(closePathElements);

    }

    @Test
    public void testClosedPathShouldReturnFalse() {
        generateSectors(closePathElements);
        NotClosedPathRule rule = new NotClosedPathRule();
        assertFalse(rule.isValidBoard(board));
    }

    @Test
    public void testNotClosedPathShouldReturnTrue() {
        generateSectors(openPathElements);
        NotClosedPathRule rule = new NotClosedPathRule();
        assertTrue(rule.isValidBoard(board));
    }

    private void setupClosedPathJoins(List<BoardElement> elements) {
        setupOpenPathJoins(elements);
        board.addJoin(new Join(elements.get(elements.size() - 1),elements.get(0)));
    }


    private void generateSectors(List<BoardElement> elements) {
        Sector sector = new Sector(elements, 0);
        sectors = new ArrayList<>();
        sectors.add(sector);
        board = new Board(ROWS, COLS, sectors);
    }

    private void generateBoardElements(List<BoardElement> elements) {
        for (int i = 1; i <= ROWS; ++i) {
            for (int j = 1; j <= COLS; ++j) {
                Position position = new Position(i, j);
                BoardElement boardElement = new Vorterix();
                boardElement.setPosition(position);
                elements.add(boardElement);
            }
        }
    }



    private void setupOpenPathJoins(List<BoardElement> elements) {
        generateJoins(elements);
    }

    private void generateJoins(List<BoardElement> elements) {
        List<Join> joins = new ArrayList<>();
        for (int i = 0; i < elements.size() - 1; i++) {
            for (int j = i + 1; j < elements.size(); j++) {
                Join join = new Join(elements.get(i), elements.get(j));
                joins.add(join);
            }
        }

        for (Join join:joins){
            board.addJoin(join);
        }
    }


}
