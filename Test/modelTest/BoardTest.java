import Model.Board;
import Model.Cell;
import Model.EditableCell;
import Model.Position;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class BoardTest {

    private Board board;
    private final ThreadLocal<HashMap<Position, Cell>> cells = new ThreadLocal<HashMap<Position, Cell>>();

    @Before
    public void setUp() {
        cells.set(new HashMap<Position, Cell>());
        for (int i = 1; i < 10; i ++) {
            Cell cell = new EditableCell(new Position(i,i));
            cells.get().put(new Position(i,i), cell);
        }

        board = new Board(9, 9, cells.get());
    }

    @Test
    public void getBoardDimension() {
        assertEquals(9, board.getRows());
    }

}
