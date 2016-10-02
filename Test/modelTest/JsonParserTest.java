package modelTest;

import model.JsonParser;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class JsonParserTest {
    private static final String SUDOKU_PATH = "resources/Model/sudoku/sudoku_enunciado.json";
    private static final String KAKURO_PATH = "resources/Model/kakuro/kakuro_enunciado.json";

    @Before
    public void setUp() {

    }

    @Test
    public void testCreateParser() {
        JsonParser parser = JsonParser.instance();
        assertNotNull(parser);
        assertEquals("sudoku", parser.getGameName());
        assertEquals(9, parser.getRows());
        assertEquals(9, parser.getColumns());
        assertNotNull(parser.getCells());
    }

    @Test
    public void testParseNullPath() {
        JsonParser parser = JsonParser.instance();
        parser.parseElements(null);
        assertEquals(9, parser.getRows());
        assertEquals(9, parser.getColumns());
        assertEquals("sudoku", parser.getGameName());
    }

}
