package modelTest;

import Model.Board;
import Model.Cell;
import Model.EditableCell;
import Model.Position;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.HashMap;

public class BoardTest {

    private Board board;
    private HashMap<Position, Cell> cells;

    @Before
    public void setUp() {
        cells = new HashMap<Position, Cell>();
        for (int i = 1; i < 10; i ++) {
            Cell cell = new EditableCell(new Position(i,i));
            cells.put(new Position(i,i), cell);
        }

        board = new Board(9, 9, cells);
    }

    @Test
    public void getBoardDimension() {
        assertEquals(9, board.getRows());
    }

}
